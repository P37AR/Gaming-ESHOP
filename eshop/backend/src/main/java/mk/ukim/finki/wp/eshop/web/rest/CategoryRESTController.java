package mk.ukim.finki.wp.eshop.web.rest;

import mk.ukim.finki.wp.eshop.model.Category;
import mk.ukim.finki.wp.eshop.model.dto.CategoryDto;
import mk.ukim.finki.wp.eshop.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/api/categories")
public class CategoryRESTController {

    private final CategoryService categoryService;

    public CategoryRESTController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> findAll() {
        return this.categoryService.listCategories();
    }

    @PostMapping("/add")
    public ResponseEntity<Category> save(@RequestBody CategoryDto categoryDto) {
        return this.categoryService.create(categoryDto)
                .map(category -> ResponseEntity.ok().body(category))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}

