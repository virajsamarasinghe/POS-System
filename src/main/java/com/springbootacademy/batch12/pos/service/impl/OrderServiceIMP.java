package com.springbootacademy.batch12.pos.service.impl;

import com.springbootacademy.batch12.pos.dto.paginated.PaginatedResponseOrderDetails;
import com.springbootacademy.batch12.pos.dto.queryinterfaces.OrderDetailInterface;
import com.springbootacademy.batch12.pos.dto.request.RequestOrderSaveDTO;
import com.springbootacademy.batch12.pos.dto.response.ResponseOrderDetailsDTO;
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
import org.springframework.data.domain.PageRequest;
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

    @Override
    public PaginatedResponseOrderDetails getAllOrdersDetails(boolean status, int page, int size) {
        List<OrderDetailInterface> orderDetailsDTOS = orderRepo.getAllOrderDetails(status,PageRequest.of(page,size));

        List<ResponseOrderDetailsDTO> list = new ArrayList<>();
        for(OrderDetailInterface o: orderDetailsDTOS){
            ResponseOrderDetailsDTO r = new ResponseOrderDetailsDTO(
                    o.getCustomerName(),
                    o.getCustomerAddress(),
                    o.getContactNumbers(),
                    o.getDate(),
                    o.getTotal()
            );
            list.add(r);

        }
        PaginatedResponseOrderDetails paginatedResponseOrderDetails = new PaginatedResponseOrderDetails(
                list,
                orderRepo.countAllOrderDetails(status)
        );
        return paginatedResponseOrderDetails;
    }


}
