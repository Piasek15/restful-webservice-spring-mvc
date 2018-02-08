package pl.piasecki.restfulwebservicespringmvc.services;

import javassist.NotFoundException;
import pl.piasecki.restfulwebservicespringmvc.api.v1.model.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomerById(Long id);
    CustomerDTO createNewCustomer(CustomerDTO customerDTO);
}
