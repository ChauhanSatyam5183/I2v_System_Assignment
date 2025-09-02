package com.example.satyam_I2v_Assigment.Service;

import com.example.satyam_I2v_Assigment.Dto.CartItemDto;
import com.example.satyam_I2v_Assigment.Modal.CartItem;
import com.example.satyam_I2v_Assigment.Repository.CartItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepo cartItemRepo;

    public CartItemDto add(CartItem cartItem) {
        cartItemRepo.add(cartItem);
        CartItemDto dto = new CartItemDto();
        dto.setMessage("Cart item added successfully!");
        dto.setCartItem(cartItem);
        return dto;
    }

    public CartItemDto update(int id, CartItem cartItem) {
        CartItemDto dto = new CartItemDto();
        if (cartItemRepo.exists(id)) {
            cartItem.setCartItemID(id); // ensure correct ID
            cartItemRepo.update(cartItem); // ✅ now only 1 argument
            dto.setMessage("Cart item updated successfully!");
            dto.setCartItem(cartItem);
        } else {
            dto.setMessage("Cart item not found with id: " + id);
            dto.setCartItem(null);
        }
        return dto;
    }

    public CartItemDto delete(int id) {
        CartItemDto dto = new CartItemDto();
        if (cartItemRepo.exists(id)) {
            CartItem deleted = cartItemRepo.getById(id);
            cartItemRepo.delete(id);
            dto.setMessage("Cart item deleted successfully!");
            dto.setCartItem(deleted);
        } else {
            dto.setMessage("Cart item not found with id: " + id);
            dto.setCartItem(null);
        }
        return dto;
    }

    public CartItemDto get(int id) {
        CartItemDto dto = new CartItemDto();
        if (cartItemRepo.exists(id)) {
            dto.setMessage("Cart item fetched successfully!");
            dto.setCartItem(cartItemRepo.getById(id));
        } else {
            dto.setMessage("Cart item not found with id: " + id);
            dto.setCartItem(null);
        }
        return dto;
    }
}
