package pl.piasecki.restfulwebservicespringmvc.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.piasecki.restfulwebservicespringmvc.api.v1.mapper.CustomerMapper;
import pl.piasecki.restfulwebservicespringmvc.api.v1.model.CustomerDTO;
import pl.piasecki.restfulwebservicespringmvc.bootstrap.Bootstrap;
import pl.piasecki.restfulwebservicespringmvc.domain.Customer;
import pl.piasecki.restfulwebservicespringmvc.repositories.CategoryRepository;
import pl.piasecki.restfulwebservicespringmvc.repositories.CustomerRepository;

import java.util.List;


import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerServiceImplIT {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CategoryRepository categoryRepository;

    CustomerService customerService;

    @Before
    public void setUp() throws Exception {
        System.out.println("Loading Customer Data");
        System.out.println(customerRepository.findAll().size());

        Bootstrap bootstrap = new Bootstrap(categoryRepository, customerRepository);
        bootstrap.run();

        customerService = new CustomerServiceImpl(CustomerMapper.INSTANCE, customerRepository);
    }

    @Test
    public void patchCustomerUpdateFistName() throws Exception {
        String updatedName = "UpdatedName";
        long id = getCustomerIdValue();

        Customer originalCustomer = customerRepository.getOne(id);
        assertNotNull(originalCustomer);

        String originalFirstName = originalCustomer.getFirstName();
        String originalLastName = originalCustomer.getLastName();

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName(updatedName);

        customerService.patchCustomer(id, customerDTO);

        Customer updatedCostumer = customerRepository.findById(id).get();

        assertNotNull(updatedCostumer);
        assertEquals(updatedName, updatedCostumer.getFirstName());
        assertThat(originalFirstName, not(equalTo(updatedCostumer.getFirstName())));
        assertThat(originalLastName, equalTo(updatedCostumer.getLastName()));
    }

    @Test
    public void patchCustomerUpdateLastName() throws Exception {
        String updatedName = "UpdatedName";
        long id = getCustomerIdValue();

        Customer originalCustomer = customerRepository.getOne(id);
        assertNotNull(originalCustomer);

        String originalFirstName = originalCustomer.getFirstName();
        String originalLastName = originalCustomer.getLastName();

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setLastName(updatedName);

        customerService.patchCustomer(id, customerDTO);

        Customer updatedCostumer = customerRepository.findById(id).get();

        assertNotNull(updatedCostumer);
        assertEquals(updatedName, updatedCostumer.getLastName());
        assertThat(originalLastName, not(equalTo(updatedCostumer.getLastName())));
        assertThat(originalFirstName, equalTo(updatedCostumer.getFirstName()));
    }

    private Long getCustomerIdValue(){
        List<Customer> customers = customerRepository.findAll();
        System.out.println("Customers Found: " + customers.size());
        return customers.get(0).getId();
    }
}