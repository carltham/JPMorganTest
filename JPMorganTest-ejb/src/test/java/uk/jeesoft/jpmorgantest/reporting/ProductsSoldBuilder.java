/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.jeesoft.jpmorgantest.reporting;

import java.util.ArrayList;
import java.util.List;
import uk.jeesoft.jpmorgantest.domain.ProductsSold;
import uk.jeesoft.jpmorgantest.types.ProductType;

/**
 *
 * @author carl
 */
public class ProductsSoldBuilder {

    public static List<ProductsSold> build(int nrOfProducts) {
        List<ProductsSold> builtProductsSoldList = new ArrayList<>();
        for (int productNr = 0; productNr < nrOfProducts; productNr++) {
            ProductsSold productsSold = new ProductsSold(ProductType.BAG, 100);
            builtProductsSoldList.add(productsSold);
        }
        return builtProductsSoldList;
    }

}
