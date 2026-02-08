package VendingMachine.domain;

import VendingMachine.enums.Denomination;

import java.util.HashMap;
import java.util.UUID;


public class CashBox {

    private UUID id;
    private UUID machineId;
    private HashMap<Denomination, Integer> map;
    private double amount;

    public  CashBox(UUID machineId, double amount){
        this.id = UUID.randomUUID();
        this.machineId = machineId;
        this.amount = amount;
        this.map= new HashMap<>();
         populateMap();
    }

    private  void populateMap(){
        this.map.put(Denomination.FIVE, 2);
        this.map.put(Denomination.TEN, 20);
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

    public HashMap<Denomination, Integer> getMap() {
        return map;
    }

    public void setMap(HashMap<Denomination, Integer> map) {
        this.map = map;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean calculateChange(double ca){
        return true;
    }
}
