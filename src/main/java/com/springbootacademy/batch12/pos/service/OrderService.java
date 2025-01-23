package com.springbootacademy.batch12.pos.service;

import com.springbootacademy.batch12.pos.dto.request.RequestOrderSaveDTO;

public interface OrderService {
    String addOrder(RequestOrderSaveDTO requestOrderSaveDTO);
}
