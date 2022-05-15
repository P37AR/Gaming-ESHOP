package mk.ukim.finki.wp.eshop.model.views;

import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Subselect("SELECT * from public.products_per_manufacturer")
@Immutable
public class ProductsPerManufacturerView {

    @Id
    @Column(name = "manufacturer_id")
    private Long id;

    @Column(name = "num_products")
    private Integer numProducts;
}
