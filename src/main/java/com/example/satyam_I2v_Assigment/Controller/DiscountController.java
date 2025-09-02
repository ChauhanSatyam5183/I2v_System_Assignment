package com.example.satyam_I2v_Assigment.Controller;

import com.example.satyam_I2v_Assigment.Dto.DiscountDto;
import com.example.satyam_I2v_Assigment.Modal.Discount;
import com.example.satyam_I2v_Assigment.Service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("i2v/discount")
public class DiscountController {

    @Autowired
    private DiscountService discountService;


    @PostMapping("/add")
    public ResponseEntity<DiscountDto> add(@RequestBody Discount discount) {
        return new ResponseEntity<>(discountService.add(discount), HttpStatus.CREATED);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<DiscountDto> update(@PathVariable int id, @RequestBody Discount discount) {
        return new ResponseEntity<>(discountService.update(id, discount), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DiscountDto> delete(@PathVariable int id) {
        return new ResponseEntity<>(discountService.delete(id), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<DiscountDto> get(@PathVariable int id) {
        return new ResponseEntity<>(discountService.get(id), HttpStatus.OK);
    }
}
