package ch.csbe.productstore.dto.product;

import ch.csbe.productstore.dto.category.CategoryShowDto;
import lombok.Data;

@Data
public class ProductDetailDto {
    private Long id;
    private String name;
    private String description;
    private double price;
    private CategoryShowDto category;
}
