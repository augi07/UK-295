package ch.csbe.productstore.dto.category;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategoryCreateDto {
    @NotNull
    private String name;
}
