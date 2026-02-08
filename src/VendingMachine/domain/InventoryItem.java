package VendingMachine.domain;

import java.util.UUID;

public class InventoryItem {

    private UUID id;
    private UUID productId;
    private int quantity;
    private int threshold;


    public InventoryItem(UUID pid , int q , int th){
        this.productId = pid;
        this.quantity = q;
        this.threshold = th;
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public int decrementQuantity(){
        if(quantity>0){
            quantity--;
            return quantity;
        }
        else throw new RuntimeException("Out of stock!!");
    }

    public int incrementQuantity(){
      quantity++;
      return quantity;
    }
}
