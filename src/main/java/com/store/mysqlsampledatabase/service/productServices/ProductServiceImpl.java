package com.store.mysqlsampledatabase.service.productServices;

import com.store.mysqlsampledatabase.model.Product;
import com.store.mysqlsampledatabase.model.Productline;
import com.store.mysqlsampledatabase.model.ResourceNotFoundException;
import com.store.mysqlsampledatabase.repository.ProductLineRepository;
import com.store.mysqlsampledatabase.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductLineRepository productLineRepository;

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
    public Product updateProductFields(String productCode, Map<String, Object> updates) {
        Product product = productRepository.findById(productCode)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with code: " + productCode));

        updates.forEach((key, value) -> {
            switch (key) {
                case "productName":
                    product.setProductName((String) value);
                    break;
                case "productScale":
                    product.setProductScale((String) value);
                    break;
                case "productVendor":
                    product.setProductVendor((String) value);
                    break;
                case "productDescription":
                    product.setProductDescription((String) value);
                    break;
                case "quantityInStock":
                    product.setQuantityInStock(((Number) value).shortValue());
                    break;
                case "buyPrice":
                    product.setBuyPrice(new java.math.BigDecimal(value.toString()));
                    break;
                case "msrp":
                    product.setMsrp(new java.math.BigDecimal(value.toString()));
                    break;
                case "productLine":
                    Map<String, Object> lineMap = (Map<String, Object>) value;
                    String lineName = (String) lineMap.get("productLine");
                    Productline line = productLineRepository.findById(lineName)
                            .orElseThrow(() -> new ResourceNotFoundException("ProductLine not found"));
                    product.setProductLine(line);
                    break;
            }
        });

        return productRepository.save(product);
    }


    private String generateProductCode() {
        int random = new Random().nextInt(9999);
        return "S99_" + String.format("%04d", random);
    }

    @Override
    public Product saveProduct(Product product) {
        if(product.getProductCode() == null || product.getProductCode().isBlank()){
            String productCode = generateProductCode();
            while(productRepository.existsById(productCode)){
                productCode = generateProductCode();
            }
            product.setProductCode(productCode);
        }
        return productRepository.save(product);
    }

}
