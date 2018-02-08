package pl.piasecki.restfulwebservicespringmvc.services;

import pl.piasecki.restfulwebservicespringmvc.api.v1.model.CategoryDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryByName(String name);

}
