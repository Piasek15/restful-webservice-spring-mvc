package pl.piasecki.restfulwebservicespringmvc.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.piasecki.restfulwebservicespringmvc.domain.Category;
import pl.piasecki.restfulwebservicespringmvc.domain.Customer;
import pl.piasecki.restfulwebservicespringmvc.domain.Vendor;
import pl.piasecki.restfulwebservicespringmvc.repositories.CategoryRepository;
import pl.piasecki.restfulwebservicespringmvc.repositories.CustomerRepository;
import pl.piasecki.restfulwebservicespringmvc.repositories.VendorRepository;

@Component
public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;
    private VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCategories();
        loadCustomers();
        loadVendors();
    }

    private void loadCustomers() {
        Customer customer1 = new Customer();
        customer1.setFirstName("Patrick");
        customer1.setLastName("Piasec");

        Customer customer2 = new Customer();
        customer2.setFirstName("Andrzej");
        customer2.setLastName("Duda");

        customerRepository.save(customer1);
        customerRepository.save(customer2);

        System.out.println("Customer Data Loaded: " + customerRepository.count());
    }

    private void loadCategories() {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category dried = new Category();
        dried.setName("Dried");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(fresh);
        categoryRepository.save(dried);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        System.out.println("Category Data Loaded: " + categoryRepository.count());
    }

    private void loadVendors(){
        Vendor vendor1 = new Vendor();
        vendor1.setName("vendor1");

        Vendor vendor2 = new Vendor();
        vendor2.setName("vendor2");

        Vendor vendor3 = new Vendor();
        vendor3.setName("vendor3");

        vendorRepository.save(vendor1);
        vendorRepository.save(vendor2);
        vendorRepository.save(vendor3);

        System.out.println("Vendor Data Loaded: " + vendorRepository.count());
    }
}
