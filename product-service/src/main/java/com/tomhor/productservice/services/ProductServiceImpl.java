package com.tomhor.productservice.services;

import com.tomhor.productservice.model.Product;
import com.tomhor.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;


    @Override
    public List<Product> getAllByCreditId(Long id) {
        ArrayList<Product> getAllProductsByCreditId = new ArrayList<>();

        productRepository.findAllByCreditId(id).iterator().forEachRemaining(getAllProductsByCreditId::add);

        return getAllProductsByCreditId;
    }

    @Override
    public ArrayList<Product> getAllProducts() {

        ArrayList<Product> getAllProducts = new ArrayList<>();

        productRepository.findAll().iterator().forEachRemaining(getAllProducts::add);

        return getAllProducts;
    }

    @Override
    public Product saveProduct(Product product) {

        return productRepository.save(product);

    }
}
