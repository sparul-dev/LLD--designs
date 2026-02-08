package VendingMachine.repository;

import VendingMachine.domain.Transaction;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PaymentRepository {

    Map<UUID, Transaction> transactionMap = new HashMap<>();

    public void save(Transaction t){
        transactionMap.put(t.getId(), t);
    }
}
