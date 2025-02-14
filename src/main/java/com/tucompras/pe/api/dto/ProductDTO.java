package com.tucompras.pe.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

  private String id;
  private String name;
  private String description;
  private String shopId;
  private List<String> images;
  private Boolean isActive;
  private PriceDTO price;
}
