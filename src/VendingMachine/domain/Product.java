package VendingMachine.domain;

import VendingMachine.enums.ProductType;

import java.util.UUID;


public class Product {

    private UUID id;
    private String name;
    private ProductType type ;
    private double price;

    public  Product(String name , ProductType type , double p){
        this.id= UUID.randomUUID();
        this.name = name;
        this.price= p;
        this.type = type;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", price=" + price +
                '}';
    }
}
