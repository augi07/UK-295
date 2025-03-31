package ch.csbe.productstore.dto.product;

import lombok.Data;

@Data
public class ProductShowDto {
    private Long id;
    private String name;
    private double price;
}
