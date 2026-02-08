package VendingMachine.repository;

import VendingMachine.domain.Machine;
import VendingMachine.domain.Product;

import javax.crypto.Mac;
import java.util.HashMap;
import java.util.UUID;

public class VendingMachineRepository {

   HashMap<UUID, Machine> machines= new HashMap<>();

   public Machine findById(UUID id){
       Machine currMachine = machines.get(id);
       if(currMachine==null){
           System.out.println("Machine not found for id :" + id);
       }else {System.out.println("machine found for id : " + id);}
       return currMachine;
   }

   public void save(Machine machine){
       machines.put(machine.getId(), machine);
   }
}
