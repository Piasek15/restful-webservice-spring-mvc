package pl.piasecki.restfulwebservicespringmvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piasecki.restfulwebservicespringmvc.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
