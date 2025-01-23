package com.springbootacademy.batch12.pos.dto.request;


import com.springbootacademy.batch12.pos.entity.Customer;
import com.springbootacademy.batch12.pos.entity.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderSaveDTO {

    private int customer;
    private Date date ;
    private double total;
    private Set<RequestOrderDetailsSave> orderDetails;


}
