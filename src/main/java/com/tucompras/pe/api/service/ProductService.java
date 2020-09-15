package com.tucompras.pe.api.service;

import com.tucompras.pe.api.dto.ProductDTO;
import com.tucompras.pe.api.dto.SearchDTO;
import com.tucompras.pe.api.mapper.ProductMapper;
import com.tucompras.pe.domain.entity.Product;
import com.tucompras.pe.domain.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@AllArgsConstructor
public class ProductService implements IProductService {

  private final ProductRepository productRepository;
  private final ProductMapper productMapper;

  @Override
  public Mono<ProductDTO> getById(String id) {
    return productRepository.findById(id).map(x -> productMapper.toProductDTO(x));
  }

  @Override
  public Flux<ProductDTO> search(SearchDTO searchShopDTO) {
    Flux<Product> shopFlux = null;

    if (searchShopDTO.getShopId() != null) {
      shopFlux =
          productRepository.findAllByIsActiveAndShopId(
              searchShopDTO.getIsActive(), searchShopDTO.getShopId());
    }

    return shopFlux.map(x -> productMapper.toProductDTO(x));
  }

  @Override
  public Mono<ProductDTO> save(ProductDTO shopDTO) {
    Mono<Product> shopMono = productRepository.save(productMapper.toProduct(shopDTO));
    return shopMono.map(x -> productMapper.toProductDTO(x));
  }

  @Override
  public Mono<Void> deleteById(String id) {
    return productRepository.deleteById(id);
  }
}
