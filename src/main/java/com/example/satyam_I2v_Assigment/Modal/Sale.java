package com.example.satyam_I2v_Assigment.Modal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sale {





    private int SaleID;
    private Double TotalAmount ;
    private LocalDate SaleDate ;
    private List<SalesItem> SalesItemList ;
}
