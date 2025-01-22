package com.springbootacademy.batch12.pos.dto.response;


import com.springbootacademy.batch12.pos.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemGetResponseDTO {

    private int itemId;
    private String itemName;
    private double balanceQty;
    private double SupplierPrice;
    private double sellingPrice;
    private boolean activeState;

}
