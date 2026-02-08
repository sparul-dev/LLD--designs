package VendingMachine;

import VendingMachine.Dto.TransactionDTO;
import VendingMachine.domain.*;

import VendingMachine.enums.MachineState;
import VendingMachine.enums.ProductType;
import VendingMachine.enums.TransactionState;
import VendingMachine.repository.*;
import VendingMachine.service.InventoryService;
import VendingMachine.service.PaymentService;
import VendingMachine.service.VendingMachineService;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Main {

    public static void main(String[] args){
        Product product = new Product("coca-cola", ProductType.BEVERAGE, 20.0);
        Machine machine = new Machine(MachineState.IDLE);

        InventoryItem inventoryItem = new InventoryItem(product.getId(), 40 , 5);

        Inventory inventory = new Inventory(machine.getId());
        Map<UUID, InventoryItem> items = inventory.getInventoryItems();
        items.put(inventoryItem.getId(), inventoryItem);
        inventory.setInventoryItems(items);

        InventoryRepository inventoryRepository = new InventoryRepository();

        ProductRepository productRepository = new ProductRepository();
        VendingMachineRepository vendingMachineRepository = new VendingMachineRepository();

        InventoryService inventoryService = new InventoryService(inventoryRepository);

        VendingMachineService vendingMachineService = new VendingMachineService(vendingMachineRepository , productRepository , inventoryRepository);
        vendingMachineService.addProduct(product);
        vendingMachineService.createMachine(machine);
        inventoryService.createInventory(inventory);

        List<Product> products = vendingMachineService.displayProducts(machine.getId());
        for(Product p : products) {
           System.out.println(p.toString());
        }

        CashBox cashBox = new CashBox(machine.getId(), 400);
        CashBoxRepository cashBoxRepository = new CashBoxRepository();
        cashBoxRepository.save(cashBox);

        TransactionDTO transactionDTO = new TransactionDTO(machine.getId(), product.getId(), product.getPrice() , 300.0 , TransactionState.PENDING);
        PaymentRepository paymentRepository = new PaymentRepository();
        PaymentService paymentService = new PaymentService(vendingMachineService, inventoryService, paymentRepository, cashBoxRepository);
        TransactionDTO returnedDTO = paymentService.processPayment(transactionDTO);

        System.out.println(returnedDTO);




    }
}
