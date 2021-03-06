package mk.ukim.finki.wp.eshop.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class ProductAlreadyInShoppingCartException extends RuntimeException {

    public ProductAlreadyInShoppingCartException(Long id, String username) {
        super(String.format("Product with id %d is already in shopping cart for User with username %s", id, username));
    }
}
