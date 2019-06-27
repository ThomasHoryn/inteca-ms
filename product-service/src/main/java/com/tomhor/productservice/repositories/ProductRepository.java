package com.tomhor.productservice.repositories;

import com.tomhor.productservice.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    ArrayList<Product> findAllByCreditId(Long id);
}
