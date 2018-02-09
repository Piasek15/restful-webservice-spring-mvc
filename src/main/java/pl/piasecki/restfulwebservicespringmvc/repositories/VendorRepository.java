package pl.piasecki.restfulwebservicespringmvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piasecki.restfulwebservicespringmvc.domain.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
