package ch.csbe.productstore.controller;

import ch.csbe.productstore.dto.product.*;
import ch.csbe.productstore.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Tag(name = "Products", description = "Produktverwaltung")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @Operation(summary = "Gibt alle Produkte zurück")
    public List<ProductShowDto> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Gibt ein Produkt nach ID zurück")
    public ProductDetailDto getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @GetMapping("/category/{id}")
    @Operation(summary = "Gibt alle Produkte einer Kategorie zurück")
    public List<ProductShowDto> getByCategory(@PathVariable Long id) {
        return productService.getByCategoryId(id);
    }

    @PostMapping
    @Operation(summary = "Erstellt ein neues Produkt")
    public ProductDetailDto create(@RequestBody @Valid ProductCreateDto dto) {
        return productService.create(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Aktualisiert ein Produkt")
    public ProductDetailDto update(@PathVariable Long id, @RequestBody @Valid ProductUpdateDto dto) {
        return productService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Löscht ein Produkt")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
}
