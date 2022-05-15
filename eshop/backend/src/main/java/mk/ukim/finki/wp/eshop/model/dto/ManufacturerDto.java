package mk.ukim.finki.wp.eshop.model.dto;

import lombok.Data;

@Data
public class ManufacturerDto {

    private String name;

    private String address;

    public ManufacturerDto() {
    }

    public ManufacturerDto(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
