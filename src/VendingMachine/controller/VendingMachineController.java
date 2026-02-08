package VendingMachine.controller;

import VendingMachine.domain.Product;
import VendingMachine.service.VendingMachineService;

import java.util.List;
import java.util.UUID;

public class VendingMachineController {

    private VendingMachineService vendingMachineService;

    public Product getProductDetails(UUID productId){

        return vendingMachineService.getProductDetails(productId);
    }

    public List<Product> displayProduct(UUID machineId){
        return vendingMachineService.displayProducts(machineId);
    }

}
