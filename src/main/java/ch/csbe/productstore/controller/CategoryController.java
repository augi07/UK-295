package ch.csbe.productstore.controller;

import ch.csbe.productstore.dto.category.*;
import ch.csbe.productstore.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
@Tag(name = "Categories", description = "Kategorienverwaltung")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    @Operation(summary = "Gibt alle Kategorien zurück")
    public List<CategoryShowDto> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Gibt eine Kategorie zurück")
    public CategoryDetailDto getById(@PathVariable Long id) {
        return categoryService.getById(id);
    }

    @PostMapping
    @Operation(summary = "Erstellt eine neue Kategorie")
    public CategoryDetailDto create(@RequestBody @Valid CategoryCreateDto dto) {
        return categoryService.create(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Aktualisiert eine Kategorie")
    public CategoryDetailDto update(@PathVariable Long id, @RequestBody @Valid CategoryUpdateDto dto) {
        return categoryService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Löscht eine Kategorie")
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }
}
