package VendingMachine.Exception;

import java.util.UUID;

public class ProductNotFoundException extends RuntimeException{
    private  UUID productId;

    public ProductNotFoundException(UUID id){
        this.productId  =id;
    }
    public void Message(){

        System.out.println("Product not found for : "+ productId);

    }
}
