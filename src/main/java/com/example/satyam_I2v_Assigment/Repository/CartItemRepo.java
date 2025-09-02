package com.example.satyam_I2v_Assigment.Repository;

import com.example.satyam_I2v_Assigment.Modal.CartItem;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

@Repository
public class CartItemRepo {

    private final HashMap<Integer, CartItem> cartItems = new HashMap<>();
    private static int idCounter = 1;

    public CartItemRepo() {

        CartItem c1 = new CartItem(idCounter++, 1, 2);
        CartItem c2 = new CartItem(idCounter++, 2, 1);
        cartItems.put(c1.getCartItemID(), c1);
        cartItems.put(c2.getCartItemID(), c2);
    }

    public CartItem add(CartItem cartItem) {
        cartItem.setCartItemID(idCounter++);
        cartItems.put(cartItem.getCartItemID(), cartItem);
        return cartItem;
    }

    public boolean exists(int id) {
        return cartItems.containsKey(id);
    }

    public CartItem getById(int id) {
        return cartItems.get(id);
    }

    public List<CartItem> getAll() {
        return new ArrayList<>(cartItems.values());
    }

    public void update(CartItem cartItem) {
        cartItems.put(cartItem.getCartItemID(), cartItem);
    }

    public void delete(int id) {
        cartItems.remove(id);
    }
}
