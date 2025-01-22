package com.springbootacademy.batch12.pos.controller;



import com.springbootacademy.batch12.pos.dto.CustomerDTO;
import com.springbootacademy.batch12.pos.dto.request.CustomerUpdateDTO;
import com.springbootacademy.batch12.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.saveCustomer(customerDTO);

        return "saved";
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO) {
        String message = customerService.updateCustomer(customerUpdateDTO);

        return message;
    }

    @GetMapping(
            path = "/get-by-id",
            params = "Id"

    )
    public CustomerDTO getCustomeById(@RequestParam(value = "Id") int customerId) {
        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        return customerDTO;

    }

    @GetMapping(
            path = "/get-all-customers"
    )
    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return allCustomers;
    }
    @DeleteMapping(
            path = "delete-customer/{Id}"

    )
    public String deleteCustomer(@PathVariable("Id") int customerId) {
        String deleted = customerService.deleteCustomer(customerId);
        return deleted;
    }
    @GetMapping(
            path = "/get-all-customers-by-active-state/{status}"
    )
    public List<CustomerDTO> getAllCustomersByActiveState(@PathVariable (value = "status") boolean activeState) {
        List<CustomerDTO> allCustomers = customerService.getAllCustomersByActiveState(activeState);
        return allCustomers;
    }





}
