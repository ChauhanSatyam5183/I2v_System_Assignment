package com.example.satyam_I2v_Assigment.Controller;

import com.example.satyam_I2v_Assigment.Dto.SalesItemDto;
import com.example.satyam_I2v_Assigment.Modal.SalesItem;
import com.example.satyam_I2v_Assigment.Service.SalesItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("i2v/salesitem")
public class SalesItemController {

    @Autowired
    private SalesItemService salesItemService;


    @PostMapping("/add")
    public ResponseEntity<SalesItemDto> add(@RequestBody SalesItem salesItem) {
        return new ResponseEntity<>(salesItemService.add(salesItem), HttpStatus.CREATED);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<SalesItemDto> update(@PathVariable int id, @RequestBody SalesItem salesItem) {
        return new ResponseEntity<>(salesItemService.update(id, salesItem), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SalesItemDto> delete(@PathVariable int id) {
        return new ResponseEntity<>(salesItemService.delete(id), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<SalesItemDto> get(@PathVariable int id) {
        return new ResponseEntity<>(salesItemService.get(id), HttpStatus.OK);
    }
}
