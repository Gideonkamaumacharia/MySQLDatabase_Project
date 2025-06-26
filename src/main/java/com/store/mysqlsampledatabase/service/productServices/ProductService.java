package com.store.mysqlsampledatabase.service.productServices;

import com.store.mysqlsampledatabase.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Product> getProducts();
    Product getProductById(String productCode);
    void deleteProductById(String productCode);
    Product saveProduct(Product product);
    Product updateProductFields(String productCode, Map<String, Object> updates);

}
