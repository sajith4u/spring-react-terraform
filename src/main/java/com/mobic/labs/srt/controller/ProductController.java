package com.mobic.labs.srt.controller;

import com.mobic.labs.srt.dto.ProductInputDto;
import com.mobic.labs.srt.model.Product;
import com.mobic.labs.srt.service.ProductService;
import java.util.List;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @QueryMapping
  List<Product> products() {
    return productService.getAllProducts();
  }

  @QueryMapping
  Product productById(@Argument Long id) {
    return productService.findById(id);
  }

  @MutationMapping
  Product addProduct(@Argument(name = "product") ProductInputDto productCreateDto) {
    return productService.createProduct(productCreateDto);
  }

}
