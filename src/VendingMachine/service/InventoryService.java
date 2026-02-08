package VendingMachine.service;

import VendingMachine.domain.Inventory;
import VendingMachine.repository.InventoryRepository;

import java.util.Optional;
import java.util.UUID;

public class InventoryService {

    private InventoryRepository inventoryRepository;

    public  InventoryService(InventoryRepository inv){
        this.inventoryRepository = inv;
    }

    public void createInventory(Inventory inventory){

        inventoryRepository.save(inventory);



    }

    public Inventory getInventory(UUID machineId){

        Optional<Inventory> inventory=  inventoryRepository.findByMachineId(machineId);

        return inventory.orElseThrow(() ->
                new RuntimeException("Inventory does not exist"));

    }
}
