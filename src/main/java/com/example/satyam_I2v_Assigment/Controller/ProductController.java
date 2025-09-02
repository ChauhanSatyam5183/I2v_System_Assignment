package com.example.satyam_I2v_Assigment.Controller;

import com.example.satyam_I2v_Assigment.Dto.ProductDto;
import com.example.satyam_I2v_Assigment.Modal.Product;
import com.example.satyam_I2v_Assigment.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("i2v/product")
public class ProductController {

    @Autowired
    private ProductService productService;



    @PostMapping("/add")
    public ResponseEntity<ProductDto> addProduct(@RequestBody Product p) {
        return new ResponseEntity<>(productService.add(p), HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody Product p) {
        return new ResponseEntity<>(productService.update(p), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        return new ResponseEntity<>(productService.delete(id), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product p = productService.getById(id);
        if (p != null) {
            return new ResponseEntity<>(p, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }
}
