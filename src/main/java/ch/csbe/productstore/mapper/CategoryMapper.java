package ch.csbe.productstore.mapper;

import ch.csbe.productstore.dto.category.*;
import ch.csbe.productstore.entity.Category;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = ProductMapper.class)
public interface CategoryMapper {

    Category toEntity(CategoryCreateDto dto);

    Category toEntity(CategoryUpdateDto dto);

    CategoryShowDto toShowDto(Category category);

    CategoryDetailDto toDetailDto(Category category);
}
