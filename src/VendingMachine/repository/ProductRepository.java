package VendingMachine.repository;

import VendingMachine.domain.Product;

import java.util.*;

public class ProductRepository {

    Map<UUID, Product> productMap ;

    public ProductRepository(){
        productMap = new HashMap<>();
    }

    public Optional<Product> findById(UUID productId){
        Product product = productMap.get(productId);
        return Optional.ofNullable(product);
    }

    public List<Product> findAll(){
        return new ArrayList<>(productMap.values());
    }

    public Product save(Product product){

        productMap.put(product.getId() , product);
        return product;

    }

    public Product delete(UUID productId){
       Product pr =  productMap.remove(productId);
       return pr;
    }


}
