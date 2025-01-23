package com.springbootacademy.batch12.pos.util.mappers;


import com.springbootacademy.batch12.pos.dto.request.ItemSaveRequestDTO;
import com.springbootacademy.batch12.pos.dto.response.ItemGetResponseDTO;
import com.springbootacademy.batch12.pos.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface  ItemMapper {
    List<ItemGetResponseDTO> entityListToDtoList(List<Item> items);
    ItemGetResponseDTO entityToDto(Item item);
    Item dtoToEntity(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemGetResponseDTO> LisDTOToEntity(Page<Item> items);
}
