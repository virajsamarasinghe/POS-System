package com.springbootacademy.batch12.pos.service.impl;

import com.springbootacademy.batch12.pos.dto.CustomerDTO;
import com.springbootacademy.batch12.pos.dto.request.CustomerUpdateDTO;
import com.springbootacademy.batch12.pos.entity.Customer;
import com.springbootacademy.batch12.pos.repo.CustomerRepo;
import com.springbootacademy.batch12.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;


    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getCustomerBalance(),
                customerDTO.getContactNumbers(),
                customerDTO.getNic(),
                customerDTO.isActiveState()




        );
        customerRepo.save(customer);
        return customerDTO.getCustomerName() + " saved successfully";
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {

        if(customerRepo.existsById(customerUpdateDTO.getCustomerId())) {
            Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());

            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setCustomerBalance(customerUpdateDTO.getCustomerBalance());

            customerRepo.save(customer);
            return customerUpdateDTO.getCustomerName()+ " updated successfully";
        }else {
            throw new RuntimeException("Customer not found");
        }
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        if(customerRepo.existsById(customerId)){
            Customer customer = customerRepo.getReferenceById(customerId);
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerBalance(),
                    customer.getContactNumbers(),
                    customer.getNic(),
                    customer.isActiveState()
            );
            return customerDTO;

        }else{
            throw new RuntimeException("Customer not found");
        }

    }



    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> getAllCustomers = customerRepo.findAll();//it has 10 data

        List<CustomerDTO>  customerDTOList = new ArrayList<>();


        for (Customer customer : getAllCustomers) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerBalance(),
                    customer.getContactNumbers(),
                    customer.getNic(),
                    customer.isActiveState()
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }

    @Override
    public String deleteCustomer(int customerId) {
        if(customerRepo.existsById(customerId)){
            customerRepo.deleteById(customerId);
            return "Customer deleted successfully " + customerId;
        }else{
            throw new RuntimeException("Customer not found");
        }

    }

    @Override
    public List<CustomerDTO> getAllCustomersByActiveState(boolean activeState) {
        List<Customer> getAllCustomers = customerRepo.findAllByActiveStateEquals(activeState);//it has 10 data

        List<CustomerDTO>  customerDTOList = new ArrayList<>();


        for (Customer customer : getAllCustomers) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerBalance(),
                    customer.getContactNumbers(),
                    customer.getNic(),
                    customer.isActiveState()
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;

    }


}
