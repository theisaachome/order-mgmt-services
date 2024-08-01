package com.isaachome.ecom.product;

import com.isaachome.ecom.category.Category;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public Product toProduct(ProductRequest request) {
        return  Product.builder()
                .id(request.id())
        .name(request.name())
                .description(request.description())
                .availableQuantity(request.availableQuantity())
                .price(request.price())
                .category(Category.builder().id(request.id()).build())
        .build();
    }
}
