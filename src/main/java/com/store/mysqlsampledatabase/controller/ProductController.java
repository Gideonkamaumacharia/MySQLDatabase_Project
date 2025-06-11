package com.store.mysqlsampledatabase.controller;

import com.store.mysqlsampledatabase.model.Product;
import com.store.mysqlsampledatabase.service.productServices.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/getProducts")
    ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.getProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping("/saveProduct")
    ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        return ResponseEntity.ok(savedProduct);
    }

    @PatchMapping("/updateProducts/{productCode}")
    ResponseEntity<Product> updateProduct(@PathVariable String productCode,@RequestBody Product product) {
        Product  updatedProduct = productService.updateProduct(productCode, product);
        return ResponseEntity.ok(updatedProduct);

    }
}
