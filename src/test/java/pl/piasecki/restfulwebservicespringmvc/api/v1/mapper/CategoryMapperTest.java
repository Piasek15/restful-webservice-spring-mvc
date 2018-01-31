package pl.piasecki.restfulwebservicespringmvc.api.v1.mapper;

import org.junit.Test;
import pl.piasecki.restfulwebservicespringmvc.api.v1.model.CategoryDTO;
import pl.piasecki.restfulwebservicespringmvc.domain.Category;

import static org.junit.Assert.*;

public class CategoryMapperTest {

    public static final String NAME = "aaa";
    public static final long ID = 1L;
    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @Test
    public void categoryToCategoryDTO() throws Exception {

        //given
        Category category = new Category();
        category.setName(NAME);
        category.setId(ID);

        //when
        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);

        //then
        assertEquals(Long.valueOf(ID), categoryDTO.getId());
        assertEquals(NAME, categoryDTO.getName());

    }
}