package com.tucompras.pe.api.controllers;

import com.tucompras.pe.api.dto.ProductDTO;
import com.tucompras.pe.api.dto.SearchDTO;
import com.tucompras.pe.api.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

  private final IProductService productService;

  @GetMapping("/{id}")
  private Mono<ProductDTO> getById(@PathVariable("id") String id) {
    return productService.getById(id);
  }

  @PostMapping("/search")
  private Flux<ProductDTO> search(@RequestBody SearchDTO searchShopDTO) {
    return productService.search(searchShopDTO);
  }

  @PostMapping
  private Mono<ProductDTO> save(@RequestBody ProductDTO shopDTO) {
    return productService.save(shopDTO);
  }

  @PostMapping("/saveAll")
  private Flux<ProductDTO> saveAll(@RequestBody List<ProductDTO> products) {
    return productService.saveAll(products);
  }

  @DeleteMapping("/{id}")
  private Mono<Void> deleteById(@PathVariable("id") String id) {
    return productService.deleteById(id);
  }
}
