package com.tucompras.pe.domain.entity;

import com.google.cloud.firestore.annotation.DocumentId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.gcp.data.firestore.Document;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collectionName = "product")
public class Product {

  @DocumentId
  private String id;
  private String name;
  private String description;
  private String shopId;
  private List<String> images;
  private Boolean isActive;
  private Price price;
}
