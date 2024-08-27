package com.multiTenent.multiTenent.controller;


import com.multiTenent.multiTenent.enity.Customer;
import com.multiTenent.multiTenent.enity.CustomerDto;
import com.multiTenent.multiTenent.enity.Store;
import com.multiTenent.multiTenent.response.ApiResponse;
import com.multiTenent.multiTenent.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/tenant/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ApiResponse<Customer> addCustomer(@RequestBody CustomerDto customerDto){
        Store store = Store.builder()
                .id(customerDto.getStore())
                .build();
        Customer customer = Customer.builder()
                .name(customerDto.getName())
//                .store(store)
                .emailId(customerDto.getEmailId())
                .password(customerDto.getPassword())
                .build();
        try {
            Customer newCustomer = customerService.addCustomer(customer);
            return ApiResponse.<Customer>builder()
                    .status(true)
                    .data(newCustomer)
                    .error(null)
                    .build();
        }catch (Exception e){
            return ApiResponse.<Customer>builder()
                    .status(true)
                    .data(null)
                    .error(e.getMessage())
                    .build();
        }
    }
}
