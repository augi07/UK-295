package ch.csbe.productstore.service;

import ch.csbe.productstore.dto.product.*;
import ch.csbe.productstore.entity.Category;
import ch.csbe.productstore.entity.Product;
import ch.csbe.productstore.exception.ResourceNotFoundException;
import ch.csbe.productstore.mapper.ProductMapper;
import ch.csbe.productstore.repository.CategoryRepository;
import ch.csbe.productstore.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepo;
    private final CategoryRepository categoryRepo;
    private final ProductMapper productMapper;

    @Override
    public ProductDetailDto getById(Long id) {
        return productMapper.toDetailDto(productRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found")));
    }

    @Override
    public List<ProductShowDto> getAll() {
        return productRepo.findAll().stream()
                .map(productMapper::toShowDto).toList();
    }

    @Override
    public ProductDetailDto create(ProductCreateDto dto) {
        Category category = categoryRepo.findById(dto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        Product product = Product.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .category(category)
                .build();

        return productMapper.toDetailDto(productRepo.save(product));
    }

    @Override
    public ProductDetailDto update(Long id, ProductUpdateDto dto) {
        Product existing = productRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        existing.setName(dto.getName());
        existing.setDescription(dto.getDescription());
        existing.setPrice(dto.getPrice());

        if (dto.getCategoryId() != null) {
            Category category = categoryRepo.findById(dto.getCategoryId())
                    .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
            existing.setCategory(category);
        } else {
            existing.setCategory(null);
        }

        return productMapper.toDetailDto(productRepo.save(existing));
    }

    @Override
    public void delete(Long id) {
        productRepo.deleteById(id);
    }

    @Override
    public List<ProductShowDto> getByCategoryId(Long categoryId) {
        return productRepo.findAllByCategoryId(categoryId).stream()
                .map(productMapper::toShowDto).toList();
    }
}
