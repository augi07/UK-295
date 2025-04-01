package ch.csbe.productstore.service;

import ch.csbe.productstore.dto.category.*;
import ch.csbe.productstore.entity.Category;
import ch.csbe.productstore.exception.ResourceNotFoundException;
import ch.csbe.productstore.mapper.CategoryMapper;
import ch.csbe.productstore.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepo;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryDetailDto getById(Long id) {
        return categoryMapper.toDetailDto(
                categoryRepo.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Category not found")));
    }

    @Override
    public List<CategoryShowDto> getAll() {
        return categoryRepo.findAll().stream()
                .map(categoryMapper::toShowDto).toList();
    }

    @Override
    public CategoryDetailDto create(CategoryCreateDto dto) {
        Category category = Category.builder()
                .name(dto.getName())
                .build();
        return categoryMapper.toDetailDto(categoryRepo.save(category));
    }

    @Override
    public CategoryDetailDto update(Long id, CategoryUpdateDto dto) {
        Category category = categoryRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        category.setName(dto.getName());
        return categoryMapper.toDetailDto(categoryRepo.save(category));
    }

    @Override
    public void delete(Long id) {
        categoryRepo.deleteById(id);
    }
}
