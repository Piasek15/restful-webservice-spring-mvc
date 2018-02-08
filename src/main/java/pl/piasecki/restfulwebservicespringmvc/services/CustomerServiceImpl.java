package pl.piasecki.restfulwebservicespringmvc.services;

import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import pl.piasecki.restfulwebservicespringmvc.api.v1.mapper.CustomerMapper;
import pl.piasecki.restfulwebservicespringmvc.api.v1.model.CustomerDTO;
import pl.piasecki.restfulwebservicespringmvc.domain.Customer;
import pl.piasecki.restfulwebservicespringmvc.repositories.CustomerRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerMapper customerMapper, CustomerRepository customerRepository) {
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customer -> {
                    CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
                    customerDTO.setCustomerUrl("/api/v1/customer/" + customer.getId());
                    return customerDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
//        Optional<Customer> customerOptional = customerRepository.findById(id);
//        if (!customerOptional.isPresent()){
//            throw new NotFoundException("Customer not found, by ID: " + id.toString());
//        }
//        return customerMapper.customerToCustomerDTO(customerOptional.get());

        return customerRepository.findById(id)
                .map(customerMapper::customerToCustomerDTO)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {
        return null;
    }
}
