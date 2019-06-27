package com.tomhor.creditservice.controllers;

import com.tomhor.creditservice.commands.CreditCommand;
import com.tomhor.creditservice.commands.CustomerCommand;
import com.tomhor.creditservice.commands.ProductCommand;
import com.tomhor.creditservice.model.Credit;
import com.tomhor.creditservice.proxies.CustomerServiceProxy;
import com.tomhor.creditservice.proxies.ProductServiceProxy;
import com.tomhor.creditservice.services.CreditService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/credit")
@RestController
public class CreditController {

    private final CreditService creditService;
    private final ProductServiceProxy productProxy;
    private final CustomerServiceProxy customerProxy;

    public CreditController(CreditService creditService, ProductServiceProxy productProxy, CustomerServiceProxy customerProxy) {
        this.creditService = creditService;
        this.productProxy = productProxy;
        this.customerProxy = customerProxy;
    }

    @GetMapping("/get-all")
    public List<CreditCommand> getAllCredits(){
        List<CreditCommand> allCreditsCommand = new ArrayList<>();
        List<Credit> allCredits = creditService.getAllCredits();
        List<CustomerCommand> allCustomersCommand = customerProxy.getAllCustomers();
        List<ProductCommand> allProductsCommand = productProxy.getAllProducts();

        for (Credit credit: allCredits){

            for (CustomerCommand customerCommand: allCustomersCommand){
                for (ProductCommand productCommand: allProductsCommand){
                    if (credit.getId() == customerCommand.getCreditId() && credit.getId() == productCommand.getCreditId()){
                        CreditCommand creditCommand = new CreditCommand();
                        creditCommand.setId(credit.getId());
                        creditCommand.setCreditName(credit.getCreditName());
                        creditCommand.setCreditHolderFirstName(customerCommand.getFirstName());
                        creditCommand.setCreditHolderLastName(customerCommand.getLastName());
                        creditCommand.setCreditHolderPesel(customerCommand.getPesel());
                        creditCommand.setProductName(productCommand.getProductName());
                        creditCommand.setProductQuantity(productCommand.getQuantity());
                        creditCommand.setProductValue(productCommand.getValue());
                        allCreditsCommand.add(creditCommand);
                    }
                }

            }
        }

        return allCreditsCommand;
    }

    @PostMapping("/new")
    public Long createCredit(@RequestBody CreditCommand creditCommand){

        CreditCommand creditCommandToSave = new CreditCommand();
        ProductCommand productCommand = new ProductCommand();
        CustomerCommand customerCommand = new CustomerCommand();

        creditCommandToSave.setCreditName(creditCommand.getCreditName());

        Credit savedCredit = creditService.saveCreditCommand(creditCommandToSave);

        productCommand.setCreditId(savedCredit.getId());
        productCommand.setValue(creditCommand.getProductValue());
        productCommand.setProductName(creditCommand.getProductName());

        customerCommand.setFirstName(creditCommand.getCreditHolderFirstName());
        customerCommand.setLastName(creditCommand.getCreditHolderLastName());
        customerCommand.setPesel(creditCommand.getCreditHolderPesel());
        customerCommand.setCreditId(savedCredit.getId());

        productProxy.createCredit(productCommand);

        customerProxy.createCustomer(customerCommand);

        return savedCredit.getId();
    }

    @GetMapping("/product/get-all")
    public List<ProductCommand> getAllProducts(){

        return productProxy.getAllProducts();
    }

    @GetMapping("/customer/get-all")
    public List<CustomerCommand> getAllCustomers(){

        return customerProxy.getAllCustomers();
    }

//    Custom Method without using proxy
//    @GetMapping("/product/get-all")
//    public List<ProductCommand> getAllProducts(){
//
//        ResponseEntity<ProductCommand[]> responseEntity = new RestTemplate().getForEntity("http://localhost:8100/credit/product/get-all",
//                ProductCommand[].class);
//
//        ProductCommand[] productCommands = responseEntity.getBody();
//
//        productCommands = responseEntity.getBody();
//
//        return Arrays.asList(productCommands);
//
//    }

}
