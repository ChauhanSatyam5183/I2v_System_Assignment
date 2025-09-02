package com.example.satyam_I2v_Assigment.Modal;


import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private int ProductId;

    private String Productname;

    private double Price;

   private List<SalesItem> SalesItemsList;

   private List<CartItem> CartItemsList;



}
