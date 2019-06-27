package com.tomhor.creditservice.proxies;

import com.tomhor.creditservice.commands.ProductCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "product-service", url = "localhost:8100")
public interface ProductServiceProxy {

    @PostMapping("/credit/product/new")
    ProductCommand createCredit(@RequestBody ProductCommand productCommand);

    @GetMapping("/credit/product/get-all")
    List<ProductCommand> getAllProducts();
}
