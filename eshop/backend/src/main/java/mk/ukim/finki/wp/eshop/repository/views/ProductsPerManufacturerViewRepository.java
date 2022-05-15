package mk.ukim.finki.wp.eshop.repository.views;

import mk.ukim.finki.wp.eshop.model.views.ProductsPerManufacturerView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ProductsPerManufacturerViewRepository extends JpaRepository<ProductsPerManufacturerView, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "REFRESH MATERIALIZED VIEW public.products_per_manufacturer",
    nativeQuery = true)
    void refreshMaterializedView();
}
