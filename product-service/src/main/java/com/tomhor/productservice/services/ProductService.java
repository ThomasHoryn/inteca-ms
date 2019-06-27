package com.tomhor.productservice.services;

import com.tomhor.productservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface ProductService {

    List<Product> getAllByCreditId(Long id);

    ArrayList<Product> getAllProducts();

    Product saveProduct(Product product);
}
