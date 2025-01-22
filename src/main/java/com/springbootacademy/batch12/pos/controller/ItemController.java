package com.springbootacademy.batch12.pos.controller;


import com.springbootacademy.batch12.pos.dto.request.ItemSaveRequestDTO;

import com.springbootacademy.batch12.pos.dto.response.ItemGetResponseDTO;
import com.springbootacademy.batch12.pos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {


    @Autowired
    private ItemService itemService;

    @PostMapping(
            path = {"/item"}
    )
    public String saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO) {
        String message =itemService.saveItem(itemSaveRequestDTO);
        return message;
    }


    @GetMapping(
            path = "/get-by-name",
            params = "name"
    )
    public List<ItemGetResponseDTO> getItemByNameAndStatus(@RequestParam(value = "name") String itemName) {
        List<ItemGetResponseDTO> itemDTOS = itemService.getItemByNameAndStatus(itemName);
        return itemDTOS;

    }
}
