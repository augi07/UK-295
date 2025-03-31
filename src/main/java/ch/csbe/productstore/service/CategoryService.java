package ch.csbe.productstore.service;

import ch.csbe.productstore.dto.category.*;

import java.util.List;

public interface CategoryService {
    CategoryDetailDto getById(Long id);
    List<CategoryShowDto> getAll();
    CategoryDetailDto create(CategoryCreateDto dto);
    CategoryDetailDto update(Long id, CategoryUpdateDto dto);
    void delete(Long id);
}
