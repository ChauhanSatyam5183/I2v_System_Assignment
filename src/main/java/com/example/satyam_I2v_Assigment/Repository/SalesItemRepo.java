package com.example.satyam_I2v_Assigment.Repository;

import com.example.satyam_I2v_Assigment.Modal.SalesItem;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class SalesItemRepo {

    private final HashMap<Integer, SalesItem> salesItemMap = new HashMap<>();
    private static int idCounter = 1;

    public SalesItemRepo() {

        SalesItem si1 = new SalesItem(idCounter++, 1, 1, 2);
        SalesItem si2 = new SalesItem(idCounter++, 2, 2, 1);

        salesItemMap.put(si1.getSalesItemID(), si1);
        salesItemMap.put(si2.getSalesItemID(), si2);
    }

    public SalesItem add(SalesItem salesItem) {
        salesItem.setSalesItemID(idCounter);
        salesItemMap.put(idCounter, salesItem);
        idCounter++;
        return salesItem;
    }


    public boolean exists(int id) {
        return salesItemMap.containsKey(id);
    }


    public SalesItem getById(int id) {
        return salesItemMap.get(id);
    }


    public void update(int id, SalesItem salesItem) {
        salesItemMap.put(id, salesItem);
    }


    public void delete(int id) {
        salesItemMap.remove(id);
    }
}
