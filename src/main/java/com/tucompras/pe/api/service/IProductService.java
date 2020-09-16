package com.tucompras.pe.api.service;

import com.tucompras.pe.api.dto.ProductDTO;
import com.tucompras.pe.api.dto.SearchDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IProductService {

    Mono<ProductDTO> getById(String id);

    Flux<ProductDTO> search(SearchDTO searchShopDTO);

    Mono<ProductDTO> save(ProductDTO createShopDTO);

    Mono<Void> deleteById(String id);

    Flux<ProductDTO> saveAll(List<ProductDTO> products);
}
