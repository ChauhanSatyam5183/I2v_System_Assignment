package com.example.satyam_I2v_Assigment.Controller;

import com.example.satyam_I2v_Assigment.Dto.SaleDto;
import com.example.satyam_I2v_Assigment.Modal.Sale;
import com.example.satyam_I2v_Assigment.Service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("i2v/sale")
public class SaleController {

    @Autowired
    private SaleService saleService;


    @PostMapping("/add")
    public ResponseEntity<SaleDto> add(@RequestBody Sale sale) {
        return new ResponseEntity<>(saleService.add(sale), HttpStatus.CREATED);
    }

        @PutMapping("/update/{id}")
    public ResponseEntity<SaleDto> update(@PathVariable int id, @RequestBody Sale sale) {
        return new ResponseEntity<>(saleService.update(id, sale), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SaleDto> delete(@PathVariable int id) {
        return new ResponseEntity<>(saleService.delete(id), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<SaleDto> get(@PathVariable int id) {
        return new ResponseEntity<>(saleService.get(id), HttpStatus.OK);
    }
}
