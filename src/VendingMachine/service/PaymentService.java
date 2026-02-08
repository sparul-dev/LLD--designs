package VendingMachine.service;

import VendingMachine.Dto.TransactionDTO;
import VendingMachine.domain.*;
import VendingMachine.enums.MachineState;
import VendingMachine.enums.TransactionState;
import VendingMachine.repository.CashBoxRepository;
import VendingMachine.repository.PaymentRepository;
import VendingMachine.repository.VendingMachineRepository;

import java.util.HashMap;
import java.util.UUID;

public class PaymentService {

    //validate machine state -> update state to not idle -> check inverntory for prouydct -> update the product ->
    //-> check cash -

    private VendingMachineService vendingMachineService;
    private InventoryService inventoryService;
    private PaymentRepository paymentRepository;
    private CashBoxRepository cashBoxRepository;


    public PaymentService(VendingMachineService vendingMachineService, InventoryService inventoryService, PaymentRepository pr, CashBoxRepository cashBoxRepository){
        this.vendingMachineService= vendingMachineService;
        this.inventoryService = inventoryService;
        this.paymentRepository = pr;
        this.cashBoxRepository = cashBoxRepository;
    }

    public TransactionDTO processPayment(TransactionDTO transactionDTO){


        Machine machine = vendingMachineService.getMachine(transactionDTO.getMachineID());

        if(machine==null || machine.getState()!= MachineState.IDLE){
            System.out.println("Machine not available");
            return null;
        }


        Inventory inventory = inventoryService.getInventory(machine.getId());

        InventoryItem inventoryItem= inventory.getInventoryItems()
                .values().stream()
                .filter(curr-> curr.getProductId() == transactionDTO.getProductId())
                .findFirst().orElseThrow(()->new RuntimeException("Inventory item not found!!"));

        if(inventoryItem.getQuantity()<=0){
            System.out.println("Product quanity not enough!!");
            throw  new RuntimeException();
        }


        //UUID machineID, UUID productId, double productPrice, double amountEntered, TransactionState state
        Transaction transaction = new Transaction(machine.getId(), transactionDTO.getProductId() ,transactionDTO.getProductPrice() ,transactionDTO.getAmountEntered() , TransactionState.PENDING);
        paymentRepository.save(transaction);


        try{
            //machine state updated
            machine.setState(MachineState.PROCESSING);
            vendingMachineService.updateMachineState(machine);
            CashBox cashBox = cashBoxRepository.findByMachineId(machine.getId()).get();
            if(cashBox == null) throw  new RuntimeException("cashbox does not exist");

            double changeAmount = transaction.getAmountEntered() - transaction.getProductPrice();

            if(changeAmount>0){
                if(cashBox.getAmount()< changeAmount){
                    throw  new RuntimeException("Not enough cash!!!");
                }

                if(!processCash(cashBox, changeAmount)) {
                    throw  new RuntimeException("Cash cant be processed");
                }
            }

            machine.setState(MachineState.DISPENSING);
            vendingMachineService.updateMachineState(machine);
            inventoryItem.decrementQuantity();
            inventory.getInventoryItems().put(inventoryItem.getId(), inventoryItem);
            inventoryService.createInventory(inventory);

            machine.setState(MachineState.IDLE);
            vendingMachineService.updateMachineState(machine);

            transaction.setChange(changeAmount);
            transaction.setState(TransactionState.COMPLETED);
            paymentRepository.save(transaction);


        }
        catch (Exception e){
                e.getMessage();
                throw  e;
        }

        return createDTO(transaction);
    }

    public boolean processCash(CashBox cb, double changeAmount){
        return cb.calculateChange(changeAmount);
    }



    public TransactionDTO createDTO(Transaction transaction){

        TransactionDTO transactionDTO = new TransactionDTO(transaction.getMachineID() ,
                transaction.getProductId(), transaction.getProductPrice(), transaction.getAmountEntered(), transaction.getState());

        transactionDTO.setChange(transaction.getChange());
        return transactionDTO;




    }
}
