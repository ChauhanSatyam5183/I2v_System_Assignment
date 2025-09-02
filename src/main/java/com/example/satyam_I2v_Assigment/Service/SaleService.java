package com.example.satyam_I2v_Assigment.Service;

import com.example.satyam_I2v_Assigment.Dto.SaleDto;
import com.example.satyam_I2v_Assigment.Modal.Sale;
import com.example.satyam_I2v_Assigment.Repository.SaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {

    @Autowired
    private SaleRepo saleRepo;


    public SaleDto add(Sale sale) {
        saleRepo.add(sale);
        SaleDto dto = new SaleDto();
        dto.setMessage("Sale added successfully!");
        dto.setSale(sale);
        return dto;
    }


    public SaleDto update(int id, Sale sale) {
        SaleDto dto = new SaleDto();
        if (saleRepo.exists(id)) {
            sale.setSaleID(id);
            saleRepo.update(id, sale);
            dto.setMessage("Sale updated successfully!");
            dto.setSale(sale);
        } else {
            dto.setMessage("Sale not found with id: " + id);
            dto.setSale(null);
        }
        return dto;
    }


    public SaleDto delete(int id) {
        SaleDto dto = new SaleDto();
        if (saleRepo.exists(id)) {
            Sale deleted = saleRepo.getById(id);
            saleRepo.delete(id);
            dto.setMessage("Sale deleted successfully!");
            dto.setSale(deleted);
        } else {
            dto.setMessage("Sale not found with id: " + id);
            dto.setSale(null);
        }
        return dto;
    }


    public SaleDto get(int id) {
        SaleDto dto = new SaleDto();
        if (saleRepo.exists(id)) {
            dto.setMessage("Sale fetched successfully!");
            dto.setSale(saleRepo.getById(id));
        } else {
            dto.setMessage("Sale not found with id: " + id);
            dto.setSale(null);
        }
        return dto;
    }
}
