package com.springbootacademy.batch12.pos.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseOrderDetailsDTO {
    //customer
    private String customerName;
    private String customerAddress;
    private ArrayList contactNumbers;

    //order
    private Date date ;
    private double total;

}
