package ch.csbe.productstore.dto.category;

import ch.csbe.productstore.dto.product.ProductShowDto;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDetailDto {
    private Long id;
    private String name;
    private List<ProductShowDto> products;
}