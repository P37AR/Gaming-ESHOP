package mk.ukim.finki.wp.eshop.service.impl;

import mk.ukim.finki.wp.eshop.model.Category;
import mk.ukim.finki.wp.eshop.model.dto.CategoryDto;
import mk.ukim.finki.wp.eshop.repository.CategoryRepository;
import mk.ukim.finki.wp.eshop.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public Category create(String name, String description) {
        if(name==null || name.isEmpty())
            throw new IllegalArgumentException();
        Category c=new Category(name, description);
        this.categoryRepository.save(c);
        return c;
    }

    @Override
    public Optional<Category> create(CategoryDto categoryDto) {
        Category category=new Category(categoryDto.getName(), categoryDto.getDescription());
        this.categoryRepository.save(category);
        return Optional.of(category);
    }

    @Override
    public Category update(String name, String description) {
        if(name==null || name.isEmpty())
            throw new IllegalArgumentException();
        Category c=new Category(name, description);
        this.categoryRepository.save(c);
        return c;
    }

    @Override
    public List<Category> listCategories() {
        return this.categoryRepository.findAll();
    }

    @Override
    public List<Category> searchCategories(String searchText) {
        return this.categoryRepository.findAllByNameLike(searchText);
    }

    @Override
    public void delete(String name) {
        if(name==null || name.isEmpty())
            throw new IllegalArgumentException();
        this.categoryRepository.deleteByName(name);
    }

    @Override
    public void deleteById(Long id) {
        this.categoryRepository.deleteById(id);
    }
}
