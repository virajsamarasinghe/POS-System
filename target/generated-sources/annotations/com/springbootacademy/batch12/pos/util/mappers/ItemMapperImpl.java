package com.springbootacademy.batch12.pos.util.mappers;

import com.springbootacademy.batch12.pos.dto.request.ItemSaveRequestDTO;
import com.springbootacademy.batch12.pos.dto.response.ItemGetResponseDTO;
import com.springbootacademy.batch12.pos.entity.Item;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-23T15:00:11+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Homebrew)"
)
@Component
public class ItemMapperImpl implements ItemMapper {

    @Override
    public List<ItemGetResponseDTO> entityListToDtoList(List<Item> items) {
        if ( items == null ) {
            return null;
        }

        List<ItemGetResponseDTO> list = new ArrayList<ItemGetResponseDTO>( items.size() );
        for ( Item item : items ) {
            list.add( entityToDto( item ) );
        }

        return list;
    }

    @Override
    public ItemGetResponseDTO entityToDto(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemGetResponseDTO itemGetResponseDTO = new ItemGetResponseDTO();

        return itemGetResponseDTO;
    }

    @Override
    public Item dtoToEntity(ItemSaveRequestDTO itemSaveRequestDTO) {
        if ( itemSaveRequestDTO == null ) {
            return null;
        }

        Item item = new Item();

        return item;
    }

    @Override
    public List<ItemGetResponseDTO> LisDTOToEntity(Page<Item> items) {
        if ( items == null ) {
            return null;
        }

        List<ItemGetResponseDTO> list = new ArrayList<ItemGetResponseDTO>();
        for ( Item item : items ) {
            list.add( entityToDto( item ) );
        }

        return list;
    }
}
