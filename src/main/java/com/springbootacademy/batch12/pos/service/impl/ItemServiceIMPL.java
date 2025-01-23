package com.springbootacademy.batch12.pos.service.impl;

import com.springbootacademy.batch12.pos.dto.paginated.PaginatedResponseItemDTO;
import com.springbootacademy.batch12.pos.dto.request.ItemSaveRequestDTO;
import com.springbootacademy.batch12.pos.dto.response.ItemGetResponseDTO;
import com.springbootacademy.batch12.pos.entity.Item;
import com.springbootacademy.batch12.pos.exception.NotFoundException;
import com.springbootacademy.batch12.pos.repo.ItemRepo;
import com.springbootacademy.batch12.pos.service.ItemService;

import com.springbootacademy.batch12.pos.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItemServiceIMPL implements ItemService {


    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;


    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {
//
//            Item item = new Item(
//                    1,
//                    itemSaveRequestDTO.getItemName(),
//                    itemSaveRequestDTO.getMeasuringUnitType(),
//                    itemSaveRequestDTO.getBalanceQty(),
//                    itemSaveRequestDTO.getSupplierPrice(),
//                    itemSaveRequestDTO.getSellingPrice(),
//                    true
//
//
//
//
//
//            );
//            itemRepo.save(item);
//            return item.getItemName();

        Item item = modelMapper.map(itemSaveRequestDTO,Item.class);
//        Item item = itemMapper.dtoToEntity(itemSaveRequestDTO);
        if(!itemRepo.existsById(item.getItemId())){
            itemRepo.save(item);
            return item.getItemId() + " saved succefully";


        }else{
            throw new DuplicateKeyException("Already Added");
        }
    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName) {

        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveStateEquals(itemName , true);
        if(items.size() > 0){
            List<ItemGetResponseDTO> itemGetResponseDTOS = modelMapper.map(items, new TypeToken<List<ItemGetResponseDTO>>(){}.getType());
            return  itemGetResponseDTOS;
        }else {
            throw new RuntimeException("Not found");
        }

    }




    @Override
    public List<ItemGetResponseDTO> getItemsByActiveStatus(boolean activeStatus) {

        List<Item> items = itemRepo.findAllByActiveStateEquals (activeStatus );
        if(items.size() > 0){
            List<ItemGetResponseDTO> itemGetResponseDTOS = modelMapper.map(items, new TypeToken<List<ItemGetResponseDTO>>(){}.getType());
            return  itemGetResponseDTOS;
        }else {
            throw new RuntimeException("Not found");
        }

    }

    @Override
    public PaginatedResponseItemDTO getItemsByActiveStatusWithPagination(boolean activeStatus, int page, int size) {
        Page<Item> items = itemRepo.findAllByActiveStateEquals(activeStatus, PageRequest.of(page, size));
        int count = itemRepo.countAllByActiveStateEquals(activeStatus);
        if(items.getSize()<1){
            throw new NotFoundException("No Items Found");
        }
        PaginatedResponseItemDTO paginatedResponseItemDTO = new PaginatedResponseItemDTO(
                itemMapper.LisDTOToEntity(items),count


        );

        return paginatedResponseItemDTO;
    }
}
