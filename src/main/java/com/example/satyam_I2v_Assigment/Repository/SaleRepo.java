package com.example.satyam_I2v_Assigment.Repository;

import com.example.satyam_I2v_Assigment.Modal.Sale;
import com.example.satyam_I2v_Assigment.Modal.SalesItem;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class SaleRepo {

    private final HashMap<Integer, Sale> sales = new HashMap<>();
    private static int idCounter = 1;

    public SaleRepo() {

        List<SalesItem> sale1Items = new ArrayList<>();
        sale1Items.add(new SalesItem(1, 1, 1, 2));
        Sale s1 = new Sale(idCounter++, 120000.0, LocalDate.now(), sale1Items);

        List<SalesItem> sale2Items = new ArrayList<>();
        sale2Items.add(new SalesItem(2, 2, 2, 1));
        Sale s2 = new Sale(idCounter++, 25000.0, LocalDate.now().minusDays(1), sale2Items);

        sales.put(s1.getSaleID(), s1);
        sales.put(s2.getSaleID(), s2);
    }


    public Sale add(Sale sale) {
        sale.setSaleID(idCounter);
        sales.put(idCounter, sale);
        idCounter++;
        return sale;
    }


    public boolean exists(int id) {
        return sales.containsKey(id);
    }


    public Sale getById(int id) {
        return sales.get(id);
    }


    public void update(int id, Sale sale) {
        sales.put(id, sale);
    }


    public void delete(int id) {
        sales.remove(id);
    }
}
