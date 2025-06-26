package com.store.mysqlsampledatabase.controller;

import com.store.mysqlsampledatabase.model.Product;
import com.store.mysqlsampledatabase.repository.ProductRepository;
import com.store.mysqlsampledatabase.service.productServices.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
//@PreAuthorize("hasRole('ADMIN')")
public class ProductController {
    private final ProductService productService;
    private final ProductRepository productRepository;

    @GetMapping("/getProducts")
    ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.getProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/getProducts/{productCode}")
    ResponseEntity<Product> getProduct(@PathVariable String productCode) {
        Product product = productService.getProductById(productCode);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/saveProduct")
    ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        return ResponseEntity.ok(savedProduct);
    }

    @PatchMapping("/updateProducts/{productCode}")
    ResponseEntity<Product> updateProduct(@PathVariable String productCode,@RequestBody Map<String, Object> updates) {
        Product  updatedProduct = productService.updateProductFields(productCode, updates);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/deleteProduct/{productCode}")
    public ResponseEntity<?> deleteProduct(@PathVariable String productCode) {
        productService.deleteProductById(productCode);
        return ResponseEntity.ok().body(
                Map.of("Message", "Product deleted successfully!")
        );
    }

    @GetMapping("/total")
    ResponseEntity<?> getTotalProducts() {
         return ResponseEntity.ok(productRepository.countTotalProducts());
    }


}
