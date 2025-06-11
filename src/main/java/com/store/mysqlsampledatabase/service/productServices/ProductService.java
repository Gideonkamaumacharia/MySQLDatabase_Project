package com.store.mysqlsampledatabase.service.productServices;

import com.store.mysqlsampledatabase.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    Product getProductById(String productCode);
    void deleteProductById(String productCode);
    Product updateProduct(String productCode,Product product);
    Product saveProduct(Product product);
}
