package com.isaachome.ecom.product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;
    public Integer createProduct(ProductRequest request) {
        var product = mapper.toProduct(request);
        return repository.save(product).getId();
    }

    public List<ProductPurchaseResponse> purchaseProduct(ProductPurchaseRequest request) {
        return null;
    }

    public ProductResponse findProductByID(Integer productId) {
        return null;
    }

    public List<ProductResponse> findAll() {

    }
}
