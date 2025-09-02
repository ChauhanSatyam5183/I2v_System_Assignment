package com.example.satyam_I2v_Assigment.Repository;

import com.example.satyam_I2v_Assigment.Modal.Discount;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class DiscountRepo {

    private final HashMap<Integer, Discount> discountMap = new HashMap<>();
    private static int idCounter = 1;

    public DiscountRepo() {

        Discount d1 = new Discount(idCounter++, "NEW10", 10.0);
        Discount d2 = new Discount(idCounter++, "FESTIVE20", 20.0);

        discountMap.put(d1.getDiscountID(), d1);
        discountMap.put(d2.getDiscountID(), d2);
    }
    public Discount add(Discount discount) {
        discount.setDiscountID(idCounter);
        discountMap.put(idCounter, discount);
        idCounter++;
        return discount;
    }


    public boolean exists(int id) {
        return discountMap.containsKey(id);
    }


    public Discount getById(int id) {
        return discountMap.get(id);
    }


    public void update(int id, Discount discount) {
        discountMap.put(id, discount);
    }


    public void delete(int id) {
        discountMap.remove(id);
    }
}
