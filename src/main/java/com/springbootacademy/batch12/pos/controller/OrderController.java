package com.springbootacademy.batch12.pos.controller;


import com.springbootacademy.batch12.pos.dto.paginated.PaginatedResponseOrderDetails;
import com.springbootacademy.batch12.pos.dto.request.RequestOrderSaveDTO;
import com.springbootacademy.batch12.pos.service.OrderService;
import com.springbootacademy.batch12.pos.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.sql.SQLOutput;

@RestController
@CrossOrigin
@RequestMapping("api/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;


    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody RequestOrderSaveDTO requestOrderSaveDTO){
        String id =orderService.addOrder(requestOrderSaveDTO);

        return new ResponseEntity<>(new StandardResponse(201, "Success", "Order saved successfully"), HttpStatus.CREATED);
    }

    @GetMapping(
            params = {"stateType","page","size"},
            path = {"/get-order-details"}
    )
    public ResponseEntity<StandardResponse> getAllOrderDetails(
            @RequestParam("stateType") String stateType,
            @RequestParam("page") int page,
            @RequestParam("size") @Max(50 )int size
    ){
        PaginatedResponseOrderDetails p = null;
        if(stateType.equalsIgnoreCase("active") | stateType.equalsIgnoreCase("inactive")){
            boolean status = stateType.equalsIgnoreCase("active")?true:false;
            p = orderService.getAllOrdersDetails(status,page,size);
        }

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", p),
                HttpStatus.OK
        );
        }

}
