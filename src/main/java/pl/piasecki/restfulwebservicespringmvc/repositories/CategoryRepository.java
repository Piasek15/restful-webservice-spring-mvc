package pl.piasecki.restfulwebservicespringmvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piasecki.restfulwebservicespringmvc.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

    Category findByName(String name);

}
