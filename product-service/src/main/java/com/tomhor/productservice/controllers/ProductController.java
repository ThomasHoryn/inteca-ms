package com.tomhor.productservice.controllers;

import com.tomhor.productservice.model.Product;
import com.tomhor.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;


@RequestMapping("/credit/product")
@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/new")
    public Product addNewProduct(@RequestBody Product product){

        return productService.saveProduct(product);
    }

    @GetMapping("/get-all")
    public ArrayList<Product> getAllProducts(){

        return productService.getAllProducts();
    }
}
