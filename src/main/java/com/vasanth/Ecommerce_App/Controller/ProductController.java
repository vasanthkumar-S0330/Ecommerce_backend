package com.vasanth.Ecommerce_App.Controller;

import com.vasanth.Ecommerce_App.Model.ProductModel;
import com.vasanth.Ecommerce_App.Service.ProductService;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductModel> getAll() {
        return productService.getAllProducts();

    }

//    @GetMapping("/{id}")
//    public ResponseEntity<ProductModel> getById(@PathVariable String id) {
//        return productService.getProductById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductModel> getById(@PathVariable String id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }



    @PostMapping
    public ProductModel create(@RequestBody ProductModel productModel) {
        return productService.createProduct(productModel);
    }
}