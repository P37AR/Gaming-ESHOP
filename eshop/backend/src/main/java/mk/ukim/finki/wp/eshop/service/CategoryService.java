package mk.ukim.finki.wp.eshop.service;

import mk.ukim.finki.wp.eshop.model.Category;
import mk.ukim.finki.wp.eshop.model.dto.CategoryDto;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Category create(String name, String description);

    Optional<Category> create(CategoryDto categoryDto);

    Category update(String name, String description);

    List<Category> listCategories();

    List<Category> searchCategories(String searchText);

    void delete(String name);

    void deleteById(Long id);

}
