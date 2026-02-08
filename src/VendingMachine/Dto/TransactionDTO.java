package VendingMachine.Dto;



import VendingMachine.enums.TransactionState;

import java.util.UUID;

public class TransactionDTO {

    private UUID id;
    private UUID machineID;
    private UUID productId;
    private  double productPrice;
    private double amountEntered;
    private double change;
    private TransactionState state;

    public TransactionDTO(UUID machineID, UUID productId, double productPrice, double amountEntered,  TransactionState state) {
        this.machineID = machineID;
        this.productId = productId;
        this.productPrice = productPrice;
        this.amountEntered = amountEntered;
        this.id = UUID.randomUUID();
        this.state = state;

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getMachineID() {
        return machineID;
    }

    public void setMachineID(UUID machineID) {
        this.machineID = machineID;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getAmountEntered() {
        return amountEntered;
    }

    public void setAmountEntered(double amountEntered) {
        this.amountEntered = amountEntered;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public TransactionState getState() {
        return state;
    }

    public void setState(TransactionState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "TransactionDTO{" +
                "id=" + id +
                ", machineID=" + machineID +
                ", productId=" + productId +
                ", productPrice=" + productPrice +
                ", amountEntered=" + amountEntered +
                ", change=" + change +
                ", state=" + state +
                '}';
    }
}
