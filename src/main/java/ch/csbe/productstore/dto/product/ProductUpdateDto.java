package ch.csbe.productstore.dto.product;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductUpdateDto {

    @NotNull
    private String name;

    private String description;

    @NotNull
    private double price;

    private Long categoryId;
}
