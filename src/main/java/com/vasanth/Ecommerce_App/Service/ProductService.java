package com.vasanth.Ecommerce_App.Service;

import com.vasanth.Ecommerce_App.Dal.ProductRepository;
import com.vasanth.Ecommerce_App.Model.ProductModel;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {


    private final ProductRepository productRepo;


    public ProductService(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    public List<ProductModel> getAllProducts() {
        return productRepo.findAll();
    }

    public Optional<ProductModel> getProductById(String id) {
        return productRepo.findById(id);
    }







    public ProductModel createProduct(ProductModel productModel) {
        return productRepo.save(productModel);
    }


}
