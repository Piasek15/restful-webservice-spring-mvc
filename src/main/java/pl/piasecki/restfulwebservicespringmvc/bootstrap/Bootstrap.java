package pl.piasecki.restfulwebservicespringmvc.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.piasecki.restfulwebservicespringmvc.domain.Category;
import pl.piasecki.restfulwebservicespringmvc.domain.Customer;
import pl.piasecki.restfulwebservicespringmvc.repositories.CategoryRepository;
import pl.piasecki.restfulwebservicespringmvc.repositories.CustomerRepository;

@Component
public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCategories();
        loadCustomers();
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
}
