/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.jeesoft.jpmorgantest.domain;

import uk.jeesoft.jpmorgantest.types.ProductType;

/**
 *
 * @author carl
 */
public class ProductsSold {

    ProductType type;
    int value;

    public ProductsSold(ProductType productType, int newValue) {
        type = productType;
        value = newValue;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }
    

}
