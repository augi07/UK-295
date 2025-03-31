package ch.csbe.productstore.dto.product;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductCreateDto {

    @NotNull
    private String name;

    private String description;

    @NotNull
    private double price;

    private Long categoryId;
}
