package mk.ukim.finki.wp.eshop.service;

import mk.ukim.finki.wp.eshop.model.Discount;
import mk.ukim.finki.wp.eshop.model.dto.DiscountDto;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface DiscountService {

    List<Discount> findAll();

    Page<Discount> findAllWithPagination(Pageable pageable);

    Optional<Discount> findById(Long id);

    Optional<Discount> save(DiscountDto discountDto);

    Optional<Discount> edit(Long id, DiscountDto discountDto);

    void deleteById(Long id);

    Optional<Discount> assignDiscount(String username, Long discountId);
}