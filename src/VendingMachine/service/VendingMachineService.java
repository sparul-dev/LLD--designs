package VendingMachine.service;

import VendingMachine.Dto.ProductBody;
import VendingMachine.Exception.ProductNotFoundException;
import VendingMachine.domain.Inventory;
import VendingMachine.domain.InventoryItem;
import VendingMachine.domain.Machine;
import VendingMachine.domain.Product;
import VendingMachine.repository.InventoryRepository;
import VendingMachine.repository.ProductRepository;
import VendingMachine.repository.VendingMachineRepository;

import javax.crypto.Mac;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class VendingMachineService {

    private VendingMachineRepository machineRepo;
    private ProductRepository productRepository;

    private InventoryRepository inventoryRepository;


    public VendingMachineService(VendingMachineRepository vr , ProductRepository pr, InventoryRepository ir){
        this.machineRepo = vr;
        this.productRepository = pr;
        this.inventoryRepository  =ir;
    }



    public Product getProductDetails(UUID productId){

        try{
            Optional<Product> product=  productRepository.findById(productId);
            if(product.isEmpty()){
                throw  new ProductNotFoundException(productId);
            }

            return product.get();

        }
        catch (ProductNotFoundException e){
            e.Message();
            throw  e;

        }
        catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }

    }

    public List<Product> displayProducts(UUID machineId){
        try{
            Optional<Inventory> inventory = inventoryRepository.findByMachineId(machineId);
            if(inventory.isEmpty()) {
                System.out.println("Machine does not exist");
                throw new RuntimeException();
            }
            List<Product> products = inventory.get().getInventoryItems().values().stream().map(curr -> curr.getProductId())
                    .flatMap(productId -> productRepository.findById(productId).stream()).toList();

            return  products;

        }
        catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public Product deleteProduct(UUID productId){
        try{

            Product product = productRepository.delete(productId);
            if (product ==null){
                System.out.println("product does not exist");
                throw  new RuntimeException();
            }

            return product;


        } catch (RuntimeException e) {

            throw new RuntimeException(e);
        }

    }

    public void createMachine(Machine machine){
        machineRepo.save(machine);
        System.out.println("machine created");
    }

    public Product addProduct(Product product){
        try{
           // Product product = new Product( productBody.getName() ,productBody.getType(), productBody.getPrice() );

            return productRepository.save(product);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            throw  e;
        }

    }

    public Machine getMachine(UUID machineID){
        return machineRepo.findById(machineID);
    }

    public void updateMachineState(Machine machine){
        machineRepo.save(machine);
    }

    public void updateInventory(UUID productId){

    }
}
