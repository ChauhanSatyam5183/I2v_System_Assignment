package com.example.satyam_I2v_Assigment.Service;

import com.example.satyam_I2v_Assigment.Dto.ProductDto;
import com.example.satyam_I2v_Assigment.Modal.Product;
import com.example.satyam_I2v_Assigment.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public ProductDto add(Product p) {
        Product saved = productRepo.add(p);
        ProductDto dto = new ProductDto();
        dto.setMessage("Product added successfully");
        dto.setProduct(saved);
        return dto;
    }

    public ProductDto update(Product p) {
        if (productRepo.checkProduct(p.getProductId())) {
            Product updated = productRepo.update(p);
            ProductDto dto = new ProductDto();
            dto.setMessage("Product updated successfully");
            dto.setProduct(updated);
            return dto;
        }
        ProductDto dto = new ProductDto();
        dto.setMessage("Product not found");
        dto.setProduct(null);
        return dto;
    }

    public String delete(int id) {
        if (productRepo.checkProduct(id)) {
            productRepo.delete(id);
            return "Product deleted successfully";
        }
        return "Product not found";
    }

    public Product getById(int id) {
        return productRepo.getById(id);
    }

    public List<Product> getAll() {
        return productRepo.getAll();
    }
}
