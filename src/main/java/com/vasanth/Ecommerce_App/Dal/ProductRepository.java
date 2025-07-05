package com.vasanth.Ecommerce_App.Dal;

import com.vasanth.Ecommerce_App.Model.ProductModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<ProductModel, String> {

    Optional<ProductModel> findById(String id);


    @Query("{ 'name' : ?0 }")
    List<ProductModel> findByName(String name);







}
