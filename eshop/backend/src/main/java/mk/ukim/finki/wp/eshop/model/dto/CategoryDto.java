package mk.ukim.finki.wp.eshop.model.dto;

import lombok.Data;

@Data
public class CategoryDto {

    private String name;

    private String description;

    public CategoryDto() {
    }

    public CategoryDto(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
