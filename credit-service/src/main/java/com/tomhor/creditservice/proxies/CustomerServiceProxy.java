package com.tomhor.creditservice.proxies;

import com.tomhor.creditservice.commands.CustomerCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "customer-service", url = "localhost:8200")
public interface CustomerServiceProxy {

    @PostMapping("/credit/customer/new")
    CustomerCommand createCustomer(@RequestBody CustomerCommand customerCommand);

    @GetMapping("/credit/customer/get-all")
    List<CustomerCommand> getAllCustomers();
}
