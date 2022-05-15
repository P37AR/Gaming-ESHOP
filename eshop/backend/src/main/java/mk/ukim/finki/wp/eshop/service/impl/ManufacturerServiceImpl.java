package mk.ukim.finki.wp.eshop.service.impl;

import mk.ukim.finki.wp.eshop.model.Manufacturer;
import mk.ukim.finki.wp.eshop.model.dto.ManufacturerDto;
import mk.ukim.finki.wp.eshop.repository.ManufacturerRepository;
import mk.ukim.finki.wp.eshop.service.ManufacturerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Manufacturer> listManufacturers() {
        return this.manufacturerRepository.findAll();
    }

    @Override
    public Optional<Manufacturer> findById(Long id) {
        return this.manufacturerRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Manufacturer> save(String name, String address) {
        return Optional.of(this.manufacturerRepository.save(new Manufacturer(name, address)));
    }

    @Override
    public Optional<Manufacturer> save(ManufacturerDto manufacturerDto) {
        Manufacturer manufacturer=new Manufacturer(manufacturerDto.getName(), manufacturerDto.getAddress());
        this.manufacturerRepository.save(manufacturer);
        return Optional.of(manufacturer);
    }

    @Override
    public boolean deleteById(Long id) {
        this.manufacturerRepository.deleteById(id);
        return false;
    }
}
