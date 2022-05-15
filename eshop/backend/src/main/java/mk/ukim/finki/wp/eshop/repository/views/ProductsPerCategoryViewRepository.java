package mk.ukim.finki.wp.eshop.repository.views;

import mk.ukim.finki.wp.eshop.model.views.ProductsPerCategoryView;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsPerCategoryViewRepository extends JpaRepository<ProductsPerCategoryView, Long> {
}
