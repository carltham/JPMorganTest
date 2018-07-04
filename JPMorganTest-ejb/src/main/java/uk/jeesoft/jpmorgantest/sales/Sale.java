package uk.jeesoft.jpmorgantest.sales;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import uk.jeesoft.jpmorgantest.domain.ProductsSold;
import uk.jeesoft.jpmorgantest.types.ProductType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author carl
 */
public class Sale {

    Map<ProductType, ProductsSold> productMap = new HashMap<>();

    public Sale(List<ProductsSold> builtProductsSoldList) {
        for (ProductsSold newProductsSold : builtProductsSoldList) {
            ProductsSold productsSold = productMap.get(newProductsSold.getType());
            if (productsSold == null) {
                productsSold = new ProductsSold(ProductType.BAG, 100);
            }

        }
    }

    public boolean perform() {
        return true;
    }

    public Map<ProductType, ProductsSold> getProducts() {
        return productMap;
    }

}
