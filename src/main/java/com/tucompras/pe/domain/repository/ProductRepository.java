package com.tucompras.pe.domain.repository;

import com.tucompras.pe.domain.entity.Product;
import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;
import reactor.core.publisher.Flux;

public interface ProductRepository extends FirestoreReactiveRepository<Product> {

  Flux<Product> findAllByIsActiveAndShopId(Boolean isActive, String shopId);
}
