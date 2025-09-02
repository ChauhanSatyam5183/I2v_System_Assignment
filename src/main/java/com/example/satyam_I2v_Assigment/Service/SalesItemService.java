package com.example.satyam_I2v_Assigment.Service;

import com.example.satyam_I2v_Assigment.Dto.SalesItemDto;
import com.example.satyam_I2v_Assigment.Modal.SalesItem;
import com.example.satyam_I2v_Assigment.Repository.SalesItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesItemService {

    @Autowired
    private SalesItemRepo salesItemRepo;


    public SalesItemDto add(SalesItem salesItem) {
        salesItemRepo.add(salesItem);
        SalesItemDto dto = new SalesItemDto();
        dto.setMessage("Sales item added successfully!");
        dto.setSalesItem(salesItem);
        return dto;
    }


    public SalesItemDto update(int id, SalesItem salesItem) {
        SalesItemDto dto = new SalesItemDto();
        if (salesItemRepo.exists(id)) {
            salesItem.setSalesItemID(id);
            salesItemRepo.update(id, salesItem);
            dto.setMessage("Sales item updated successfully!");
            dto.setSalesItem(salesItem);
        } else {
            dto.setMessage("Sales item not found with id: " + id);
            dto.setSalesItem(null);
        }
        return dto;
    }


    public SalesItemDto delete(int id) {
        SalesItemDto dto = new SalesItemDto();
        if (salesItemRepo.exists(id)) {
            SalesItem deleted = salesItemRepo.getById(id);
            salesItemRepo.delete(id);
            dto.setMessage("Sales item deleted successfully!");
            dto.setSalesItem(deleted);
        } else {
            dto.setMessage("Sales item not found with id: " + id);
            dto.setSalesItem(null);
        }
        return dto;
    }


    public SalesItemDto get(int id) {
        SalesItemDto dto = new SalesItemDto();
        if (salesItemRepo.exists(id)) {
            dto.setMessage("Sales item fetched successfully!");
            dto.setSalesItem(salesItemRepo.getById(id));
        } else {
            dto.setMessage("Sales item not found with id: " + id);
            dto.setSalesItem(null);
        }
        return dto;
    }
}
