package VendingMachine.controller;

import VendingMachine.Dto.ProductBody;
import VendingMachine.domain.Product;
import VendingMachine.service.VendingMachineService;

public class AdminController {

    public VendingMachineService vendingMachineService;

    public Product addProduct(Product product){
        return vendingMachineService.addProduct(product);
    }
}
