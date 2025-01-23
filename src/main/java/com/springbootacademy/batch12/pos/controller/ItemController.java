package com.springbootacademy.batch12.pos.controller;


import com.springbootacademy.batch12.pos.dto.paginated.PaginatedResponseItemDTO;
import com.springbootacademy.batch12.pos.dto.request.ItemSaveRequestDTO;

import com.springbootacademy.batch12.pos.dto.response.ItemGetResponseDTO;
import com.springbootacademy.batch12.pos.service.ItemService;
import com.springbootacademy.batch12.pos.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;

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
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO) {
        String message =itemService.saveItem(itemSaveRequestDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", message), HttpStatus.CREATED
        );
    }

//
//    @GetMapping(
//            path = "/get-by-name",
//            params = "name"
//    )
//    public List<ItemGetResponseDTO> getItemByNameAndStatus(@RequestParam(value = "name") String itemName) {
//        List<ItemGetResponseDTO> itemDTOS = itemService.getItemByNameAndStatus(itemName);
//        return itemDTOS;
//
//    }


    @GetMapping(
            path = "/get-by-name-with-modelmapper",
            params = "name"
    )
    public ResponseEntity<StandardResponse> getItemByNameAndStatus(@RequestParam(value = "name") String itemName) {
        List<ItemGetResponseDTO> itemDTOS = itemService.getItemByNameAndStatus(itemName);
        return new ResponseEntity<>(
                new StandardResponse(200, "Success", itemDTOS), HttpStatus.OK
        );

    }

    @GetMapping(
            path = "/get-all-item-by-status",
            params = {"activeStatus","page","size"}
    )
    public ResponseEntity<StandardResponse> getItemsByActiveStatus(
            @RequestParam(value = "activeStatus") boolean activeStatus,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(50)int size){
//        List<ItemGetResponseDTO> itemDTOS = itemService.getItemsByActiveStatus(activeStatus);
        PaginatedResponseItemDTO paginatedResponseItemDTO = itemService.getItemsByActiveStatusWithPagination(activeStatus,page,size);
        return new ResponseEntity<>(
                new StandardResponse(200, "Success", paginatedResponseItemDTO), HttpStatus.OK
        );

    }
}
