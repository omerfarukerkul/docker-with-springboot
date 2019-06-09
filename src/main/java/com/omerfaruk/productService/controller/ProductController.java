package com.omerfaruk.productService.controller;

import com.omerfaruk.productService.ProductService;
import com.omerfaruk.productService.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        final long first = System.currentTimeMillis();
        List<Product> products = productService.findAll();
        final long last = System.currentTimeMillis();
        LOGGER.info((last - first)+"");
        return products;
    }

    @PostMapping("/products")
    public Product saveProduct(@RequestBody Product product) {
        return productService.save(product);
    }
}
