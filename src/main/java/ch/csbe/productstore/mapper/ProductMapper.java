package ch.csbe.productstore.mapper;

import ch.csbe.productstore.dto.product.*;
import ch.csbe.productstore.entity.Product;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toEntity(ProductCreateDto dto);

    Product toEntity(ProductUpdateDto dto);

    ProductShowDto toShowDto(Product product);

    ProductDetailDto toDetailDto(Product product);
}
