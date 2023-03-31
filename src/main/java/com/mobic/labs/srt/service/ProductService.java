package com.mobic.labs.srt.service;

import com.mobic.labs.srt.dto.ProductInputDto;
import com.mobic.labs.srt.model.Product;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
  List<Product> products = new ArrayList<>();

  public ProductService() {
    Product kitchenItem =
        Product.builder().price(100d).id(1l).name("Test 1").category("Kitchen").image("https://demo.mobiclabs.sample")
            .build();

    Product kitchenItem1 =
        Product.builder().price(100d).id(2l).name("Test 2d").category("Kitchen").image("https://demo.mobiclabs.sample")
            .build();
    products.add(kitchenItem);
    products.add(kitchenItem1);
  }

  public Product findById(Long id){
    return products.stream().filter(x -> x.getId() == id).findAny().get();
  }

  public Product createProduct(ProductInputDto productCreateDto){
    Product newItem =
        Product.builder().price(productCreateDto.price()).id(productCreateDto.id())
            .name(productCreateDto.name()).category(productCreateDto.category()).image("https://demo.mobiclabs.sample")
            .build();
    products.add(newItem);
    return newItem;
  }

  public List<Product> getAllProducts() {
    return products;
  }

}
