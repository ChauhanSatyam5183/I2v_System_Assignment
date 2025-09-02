package com.example.satyam_I2v_Assigment.Dto;

import com.example.satyam_I2v_Assigment.Modal.CartItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemDto {
    private String message;
    private CartItem cartItem;
}
