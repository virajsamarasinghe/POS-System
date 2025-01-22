package com.springbootacademy.batch12.pos.service;

import com.springbootacademy.batch12.pos.dto.request.ItemSaveRequestDTO;
import com.springbootacademy.batch12.pos.dto.response.ItemGetResponseDTO;

import java.util.List;


public interface ItemService {
    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName);
}
