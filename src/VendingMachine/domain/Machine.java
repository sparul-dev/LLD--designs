package VendingMachine.domain;

import VendingMachine.enums.MachineState;

import javax.crypto.Mac;
import java.util.UUID;



public class Machine {

    private UUID id;
    private MachineState state;
    private boolean isOperational;

    public Machine(MachineState state){
        this.state= state;
        this.isOperational= true;
        this.id = UUID.randomUUID();
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public MachineState getState() {
        return state;
    }

    public void setState(MachineState state) {
        this.state = state;
    }

    public boolean isOperational() {
        return isOperational;
    }

    public void setOperational(boolean operational) {
        isOperational = operational;
    }
}
