package com.example.Guy.Config;
import com.example.Guy.Dao.Model.Product;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.*;
import java.util.*;

@Configuration
public class ImportJson {

    @Bean(name = "loadProductsFromJson")
    public HashMap<Integer, Product> importDocumentsFromJsonFile() throws IOException, ParseException {
        HashMap<Integer, Product> hashMap = new HashMap<>();
        Integer index = 0;
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(("C:\\Users\\shavit\\Desktop\\products.json")));
        for(Object o : jsonArray){
            JSONObject product = (JSONObject) o;
            String title = (String) product.get("title");
            Number serialNumber = (Number) product.get("serialNumber");
            String category = (String) product.get("category");
            Number price = (Number) product.get("price");
            Product p = new Product(serialNumber.intValue(),title,category,price.intValue());
            hashMap.put(p.getSerialNumber(),p);
        }
        return hashMap;
    }
}
