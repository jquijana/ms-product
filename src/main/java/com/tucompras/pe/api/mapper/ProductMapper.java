package com.tucompras.pe.api.mapper;

import com.tucompras.pe.api.dto.PriceDTO;
import com.tucompras.pe.api.dto.ProductDTO;
import com.tucompras.pe.domain.entity.Price;
import com.tucompras.pe.domain.entity.Product;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProductMapper {

  public ProductDTO toProductDTO(Product product) {
    return ProductDTO.builder()
        .id(product.getId())
        .name(product.getName())
        .description(product.getDescription())
        .images(product.getImages())
        .isActive(product.getIsActive())
        .shopId(product.getShopId())
        .price(toPriceDTO(product.getPrice()))
        .build();
  }

  public Product toProduct(ProductDTO dto) {
    return Product.builder()
        .id(dto.getId() == null ? UUID.randomUUID().toString() : dto.getId())
        .name(dto.getName())
        .description(dto.getDescription())
        .images(dto.getImages())
        .isActive(dto.getIsActive())
        .price(toPrice(dto.getPrice()))
        .shopId(dto.getShopId())
        .build();
  }

  private Price toPrice(PriceDTO priceDTO) {
    if (priceDTO != null) return Price.builder().priceUnit(priceDTO.getPriceUnit()).build();
    return null;
  }

  private PriceDTO toPriceDTO(Price price) {
    if (price != null) return PriceDTO.builder().priceUnit(price.getPriceUnit()).build();
    return null;
  }
}
