package com.springbootacademy.batch12.pos.service.impl;

import com.springbootacademy.batch12.pos.dto.request.RequestOrderSaveDTO;
import com.springbootacademy.batch12.pos.entity.Item;
import com.springbootacademy.batch12.pos.entity.Order;
import com.springbootacademy.batch12.pos.entity.OrderDetails;
import com.springbootacademy.batch12.pos.repo.CustomerRepo;
import com.springbootacademy.batch12.pos.repo.ItemRepo;
import com.springbootacademy.batch12.pos.repo.OrderDetailRepo;
import com.springbootacademy.batch12.pos.repo.OrderRepo;
import com.springbootacademy.batch12.pos.service.OrderService;
import com.springbootacademy.batch12.pos.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class OrderServiceIMP implements OrderService {



    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private OrderDetailRepo orderDetailRepo;

    @Autowired
    private ItemRepo itemRepo;



    @Override
    @Transactional
    public String addOrder(RequestOrderSaveDTO requestOrderSaveDTO) {
       Order order = new Order(
               customerRepo.getById(requestOrderSaveDTO.getCustomer()),
               requestOrderSaveDTO.getDate(),
               requestOrderSaveDTO.getTotal()


       );
       orderRepo.save(order);

       if(orderRepo.existsById(order.getOrderId())){
           List<OrderDetails> orderDetails =modelMapper.map(requestOrderSaveDTO.getOrderDetails(), new TypeToken<List<OrderDetails>>(){}.getType());

           for(int i =0 ; i<orderDetails.size();i++){
               orderDetails.get(i).setOrders(order);
               orderDetails.get(i).setItems(itemRepo.getById(new ArrayList<>(requestOrderSaveDTO.getOrderDetails()).get(i).getItems()));

           }

           if(orderDetails.size()>0){
               orderDetailRepo.saveAll(orderDetails);
           }
           return  "Order saved successfully";


       }
       return null;
    }
}
