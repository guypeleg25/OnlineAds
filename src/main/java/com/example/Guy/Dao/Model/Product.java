package com.example.Guy.Dao.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Product {

    Integer serialNumber;
    String title;
    String category;
    Integer price;

}
