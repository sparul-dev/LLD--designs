package VendingMachine.repository;

import VendingMachine.domain.CashBox;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

public class CashBoxRepository {

    HashMap<UUID, CashBox> cashBoxHashMap = new HashMap<>();

    public void save(CashBox cb){
        cashBoxHashMap.put(cb.getMachineId(), cb);
    }

    public Optional<CashBox> findByMachineId(UUID machineID){

        return Optional.ofNullable(cashBoxHashMap.get(machineID));

    }
}
