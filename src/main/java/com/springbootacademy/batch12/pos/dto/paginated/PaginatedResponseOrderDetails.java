package com.springbootacademy.batch12.pos.dto.paginated;


import com.springbootacademy.batch12.pos.dto.response.ResponseOrderDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseOrderDetails {
    private List<ResponseOrderDetailsDTO> list;
    private long dataCount;
}
