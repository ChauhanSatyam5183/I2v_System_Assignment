package com.example.satyam_I2v_Assigment.Service;

import com.example.satyam_I2v_Assigment.Dto.DiscountDto;
import com.example.satyam_I2v_Assigment.Modal.Discount;
import com.example.satyam_I2v_Assigment.Repository.DiscountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {

    @Autowired
    private DiscountRepo discountRepo;


    public DiscountDto add(Discount discount) {
        discountRepo.add(discount);
        DiscountDto dto = new DiscountDto();
        dto.setMessage("Discount added successfully!");
        dto.setDiscount(discount);
        return dto;
    }


    public DiscountDto update(int id, Discount discount) {
        DiscountDto dto = new DiscountDto();
        if (discountRepo.exists(id)) {
            discount.setDiscountID(id);
            discountRepo.update(id, discount);
            dto.setMessage("Discount updated successfully!");
            dto.setDiscount(discount);
        } else {
            dto.setMessage("Discount not found with id: " + id);
            dto.setDiscount(null);
        }
        return dto;
    }


    public DiscountDto delete(int id) {
        DiscountDto dto = new DiscountDto();
        if (discountRepo.exists(id)) {
            Discount deleted = discountRepo.getById(id);
            discountRepo.delete(id);
            dto.setMessage("Discount deleted successfully!");
            dto.setDiscount(deleted);
        } else {
            dto.setMessage("Discount not found with id: " + id);
            dto.setDiscount(null);
        }
        return dto;
    }


    public DiscountDto get(int id) {
        DiscountDto dto = new DiscountDto();
        if (discountRepo.exists(id)) {
            dto.setMessage("Discount fetched successfully!");
            dto.setDiscount(discountRepo.getById(id));
        } else {
            dto.setMessage("Discount not found with id: " + id);
            dto.setDiscount(null);
        }
        return dto;
    }
}
