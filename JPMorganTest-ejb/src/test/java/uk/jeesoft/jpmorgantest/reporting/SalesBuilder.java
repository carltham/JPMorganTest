/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.jeesoft.jpmorgantest.reporting;

import uk.jeesoft.jpmorgantest.sales.Sale;

/**
 *
 * @author carl
 */
public class SalesBuilder {

    static Sale build(int nrOfProducts) {
        
        Sale sale = new Sale(ProductsSoldBuilder.build(10));
        return sale;
    }

}
