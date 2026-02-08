package VendingMachine.repository;

import VendingMachine.domain.Inventory;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

public class InventoryRepository {


    HashMap<UUID, Inventory> inventoryMap;
    public  InventoryRepository(){
        inventoryMap = new HashMap<>();
    }

    public Optional<Inventory> findByMachineId (UUID machineID){

        Inventory in = inventoryMap.values().stream().filter(curr -> curr.getMachineId().equals(machineID))
                .findFirst().orElse(null);

        return Optional.ofNullable(in);

    }

    public  void save(Inventory inventory){
        inventoryMap.put(inventory.getId() ,inventory);
    }


}
