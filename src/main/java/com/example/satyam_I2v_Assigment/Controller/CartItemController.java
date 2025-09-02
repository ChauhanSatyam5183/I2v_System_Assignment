package com.example.satyam_I2v_Assigment.Controller;

import com.example.satyam_I2v_Assigment.Dto.CartItemDto;
import com.example.satyam_I2v_Assigment.Modal.CartItem;
import com.example.satyam_I2v_Assigment.Service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("i2v/cart")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;


    @PostMapping("/add")
    public ResponseEntity<CartItemDto> add(@RequestBody CartItem cartItem) {
        return new ResponseEntity<>(cartItemService.add(cartItem), HttpStatus.CREATED);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<CartItemDto> update(@PathVariable int id, @RequestBody CartItem cartItem) {
        return new ResponseEntity<>(cartItemService.update(id, cartItem), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CartItemDto> delete(@PathVariable int id) {
        return new ResponseEntity<>(cartItemService.delete(id), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CartItemDto> get(@PathVariable int id) {
        return new ResponseEntity<>(cartItemService.get(id), HttpStatus.OK);
    }
}
