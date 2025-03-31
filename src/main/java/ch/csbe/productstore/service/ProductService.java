package ch.csbe.productstore.service;

import ch.csbe.productstore.dto.product.*;

import java.util.List;

public interface ProductService {
    ProductDetailDto getById(Long id);
    List<ProductShowDto> getAll();
    ProductDetailDto create(ProductCreateDto dto);
    ProductDetailDto update(Long id, ProductUpdateDto dto);
    void delete(Long id);
    List<ProductShowDto> getByCategoryId(Long categoryId);
}
