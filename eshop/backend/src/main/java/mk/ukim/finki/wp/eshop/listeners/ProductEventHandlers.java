package mk.ukim.finki.wp.eshop.listeners;

import mk.ukim.finki.wp.eshop.model.events.ProductCreatedEvent;
import mk.ukim.finki.wp.eshop.service.ProductService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ProductEventHandlers {

    private final ProductService productService;

    public ProductEventHandlers(ProductService productService) {
        this.productService = productService;
    }

    @EventListener
    public void onProductCreated(ProductCreatedEvent productCreatedEvent) {
        this.productService.refreshMaterializedView();
    }
}
