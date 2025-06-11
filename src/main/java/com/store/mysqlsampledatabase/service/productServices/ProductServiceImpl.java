package com.store.mysqlsampledatabase.service.productServices;

import com.store.mysqlsampledatabase.model.Product;
import com.store.mysqlsampledatabase.model.ResourceNotFoundException;
import com.store.mysqlsampledatabase.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(String productCode) {
        return productRepository.findById(productCode)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productCode));
    }

    @Override
    public void deleteProductById(String productCode) {
        Product product = productRepository.findById(productCode)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productCode));
        productRepository.delete(product);

    }

    @Override
    public Product updateProduct(String productCode, Product product) {
        return productRepository.findById(productCode)
                .map(existingProduct -> {
                    existingProduct.setProductName(product.getProductName());
                    existingProduct.setProductLine(product.getProductLine());
                    existingProduct.setProductScale(product.getProductScale());
                    existingProduct.setProductVendor(product.getProductVendor());
                    existingProduct.setProductDescription(product.getProductDescription());
                    existingProduct.setQuantityInStock(product.getQuantityInStock());
                    existingProduct.setBuyPrice(product.getBuyPrice());
                    existingProduct.setMsrp(product.getMsrp());
                    return productRepository.save(existingProduct);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with code: " + productCode));
    }


    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
