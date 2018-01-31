package pl.piasecki.restfulwebservicespringmvc.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.piasecki.restfulwebservicespringmvc.api.v1.model.CategoryDTO;
import pl.piasecki.restfulwebservicespringmvc.domain.Category;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDTO(Category category);

}
