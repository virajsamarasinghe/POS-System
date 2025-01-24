package com.springbootacademy.batch12.pos.dto.queryinterfaces;

import java.util.ArrayList;
import java.util.Date;

public interface OrderDetailInterface {

    String getCustomerName();
    String getCustomerAddress();
    ArrayList getContactNumbers();
    Date getDate();
    Double getTotal();
}
