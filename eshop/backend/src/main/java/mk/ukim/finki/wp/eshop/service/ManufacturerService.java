package mk.ukim.finki.wp.eshop.service;

import mk.ukim.finki.wp.eshop.model.Manufacturer;
import mk.ukim.finki.wp.eshop.model.dto.ManufacturerDto;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {

    List<Manufacturer> listManufacturers();

    Optional<Manufacturer> findById(Long id);

    Optional<Manufacturer> save(String name, String address);

    Optional<Manufacturer> save(ManufacturerDto manufacturerDto);

    boolean deleteById(Long id);
}
