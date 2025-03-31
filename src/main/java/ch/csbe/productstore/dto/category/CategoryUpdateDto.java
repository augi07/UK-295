package ch.csbe.productstore.dto.category;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategoryUpdateDto {
    @NotNull
    private String name;
}
