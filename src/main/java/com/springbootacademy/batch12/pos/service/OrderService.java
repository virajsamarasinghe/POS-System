package com.springbootacademy.batch12.pos.service;

import com.springbootacademy.batch12.pos.dto.paginated.PaginatedResponseOrderDetails;
import com.springbootacademy.batch12.pos.dto.request.RequestOrderSaveDTO;

public interface OrderService {
    String addOrder(RequestOrderSaveDTO requestOrderSaveDTO);



    PaginatedResponseOrderDetails getAllOrdersDetails(boolean status, int page, int size);
}
