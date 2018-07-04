/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.jeesoft.jpmorgantest.messages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import uk.jeesoft.jpmorgantest.domain.ProductsSold;
import uk.jeesoft.jpmorgantest.sales.Sale;
import uk.jeesoft.jpmorgantest.types.ProductType;

/**
 *
 * @author carl
 */
public class XMLReport implements IReport {

    Map<ProductType, ProductsSold> productsMap = new HashMap<>();

    public XMLReport(List<Sale> salesList) {
        for (Sale sale : salesList) {
            Map<ProductType, ProductsSold> soldProductsMap = sale.getProducts();
            productsMap.putAll(soldProductsMap);
        }
    }

}
