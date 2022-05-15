package mk.ukim.finki.wp.eshop.repository;

import mk.ukim.finki.wp.eshop.model.Product;
import mk.ukim.finki.wp.eshop.model.views.ProductsPerCategoryView;
import mk.ukim.finki.wp.eshop.model.views.ProductsPerManufacturerView;
import mk.ukim.finki.wp.eshop.repository.views.ProductsPerCategoryViewRepository;
import mk.ukim.finki.wp.eshop.repository.views.ProductsPerManufacturerViewRepository;
import mk.ukim.finki.wp.eshop.service.CategoryService;
import mk.ukim.finki.wp.eshop.service.ManufacturerService;
import mk.ukim.finki.wp.eshop.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductsPerManufacturerViewRepositoryTest {

    @Autowired
    private ProductsPerManufacturerViewRepository productsPerManufacturerViewRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ManufacturerService manufacturerService;

    @Autowired
    private ProductService productService;

    @Test
    public void testCreateNewProduct() {
        List<ProductsPerManufacturerView> list=this.productsPerManufacturerViewRepository.findAll();

        Product product=new Product();
        product.setName("Ski Jacket 667");
        product.setManufacturer(this.manufacturerService.listManufacturers().get(0));
        product.setCategory(this.categoryService.listCategories().get(0));

        productService.save(product.getName(), product.getPrice(), product.getQuantity(), product.getManufacturer().getId(), product.getCategory().getId());

        List<ProductsPerManufacturerView> list1=this.productsPerManufacturerViewRepository.findAll();
    }
}
