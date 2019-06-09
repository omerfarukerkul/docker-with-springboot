package com.omerfaruk.productService;

import com.omerfaruk.productService.model.Product;
import com.omerfaruk.productService.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Cacheable("products")
    public List<Product> findAll() {
        return productRepository.findAll();
    }


    public Product save(Product product) {
        return productRepository.save(product);
    }
}
