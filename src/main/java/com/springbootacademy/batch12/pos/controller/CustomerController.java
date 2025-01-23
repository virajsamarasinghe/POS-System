package com.springbootacademy.batch12.pos.controller;



import com.springbootacademy.batch12.pos.dto.CustomerDTO;
import com.springbootacademy.batch12.pos.dto.request.CustomerUpdateDTO;
import com.springbootacademy.batch12.pos.service.CustomerService;
import com.springbootacademy.batch12.pos.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

//    @PostMapping("/save")
//    public String saveCustomer(@RequestBody CustomerDTO customerDTO) {
//        customerService.saveCustomer(customerDTO);
//
//        return "saved";
//    }
@PostMapping("/save")
public ResponseEntity<StandardResponse> saveCustomer(@RequestBody CustomerDTO customerDTO) {
    customerService.saveCustomer(customerDTO);

    return new ResponseEntity<StandardResponse>(new StandardResponse(201, "Success", "Customer saved successfully"), HttpStatus.CREATED);
}

//    @PutMapping("/update")
//    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO) {
//        String message = customerService.updateCustomer(customerUpdateDTO);
//
//        return message;
//    }

    @PutMapping("/update")
    public ResponseEntity<StandardResponse> updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO) {
        String message = customerService.updateCustomer(customerUpdateDTO);

        return new ResponseEntity<StandardResponse>(new StandardResponse(200, "Success", message), HttpStatus.OK);
    }

//
//    @GetMapping(
//            path = "/get-by-id",
//            params = "Id"
//
//    )
//    public CustomerDTO getCustomeById(@RequestParam(value = "Id") int customerId) {
//        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
//        return customerDTO;
//
//    }


    @GetMapping(
            path = "/get-by-id",
            params = "Id"

    )
    public ResponseEntity<StandardResponse> getCustomeById(@RequestParam(value = "Id") int customerId) {
        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        return new ResponseEntity<StandardResponse>(new StandardResponse(201, "Success", customerDTO), HttpStatus.OK);

    }

//    @GetMapping(
//            path = "/get-all-customers"
//    )
//    public List<CustomerDTO> getAllCustomers() {
//        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
//        return allCustomers;
//    }

    @GetMapping(
            path = "/get-all-customers"
    )
    public ResponseEntity<StandardResponse> getAllCustomers() {
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return new ResponseEntity<StandardResponse>(new StandardResponse(201, "Success", allCustomers), HttpStatus.OK);
    }

//    @DeleteMapping(
//            path = "delete-customer/{Id}"
//
//    )
//    public String deleteCustomer(@PathVariable("Id") int customerId) {
//        String deleted = customerService.deleteCustomer(customerId);
//        return deleted;
//    }


    @DeleteMapping(
            path = "delete-customer/{Id}"

    )
    public ResponseEntity<StandardResponse> deleteCustomer(@PathVariable("Id") int customerId) {
        String deleted = customerService.deleteCustomer(customerId);
        return new ResponseEntity<StandardResponse>(new StandardResponse(201, "Success", deleted), HttpStatus.OK);
    }

//    @GetMapping(
//            path = "/get-all-customers-by-active-state/{status}"
//    )
//    public List<CustomerDTO> getAllCustomersByActiveState(@PathVariable (value = "status") boolean activeState) {
//        List<CustomerDTO> allCustomers = customerService.getAllCustomersByActiveState(activeState);
//        return allCustomers;
//    }

    @GetMapping(
            path = "/get-all-customers-by-active-state/{status}"
    )
    public ResponseEntity<StandardResponse> getAllCustomersByActiveState(@PathVariable (value = "status") boolean activeState) {
        List<CustomerDTO> allCustomers = customerService.getAllCustomersByActiveState(activeState);
        return new ResponseEntity<StandardResponse>(new StandardResponse(201, "Success", allCustomers), HttpStatus.OK);
    }






}
