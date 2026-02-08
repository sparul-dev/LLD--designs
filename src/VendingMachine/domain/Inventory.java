package VendingMachine.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Inventory {

    private UUID id;
    private UUID machineId;
    private Map<UUID, InventoryItem> inventoryItems ;

    public Inventory(UUID machineId){
        this.machineId= machineId;
        this.id = UUID.randomUUID();
        inventoryItems = new HashMap<>();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getMachineId() {
        return machineId;
    }

    public void setMachineId(UUID machineId) {
        this.machineId = machineId;
    }

    public Map<UUID, InventoryItem> getInventoryItems() {
        return inventoryItems;
    }

    public void setInventoryItems(Map<UUID, InventoryItem> inventoryItems) {
        this.inventoryItems = inventoryItems;
    }
}
