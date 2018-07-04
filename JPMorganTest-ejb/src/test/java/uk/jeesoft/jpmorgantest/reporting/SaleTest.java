/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.jeesoft.jpmorgantest.reporting;

import uk.jeesoft.jpmorgantest.sales.Sale;
import uk.jeesoft.jpmorgantest.sales.SalesHandler;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import uk.jeesoft.jpmorgantest.domain.ProductsSold;

/**
 *
 * @author carl
 */
public class SaleTest {

    public SaleTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of perform method, of class Sale.
     */
    @Test
    public void allSalesMustBeRecorded() {
        System.out.println("perform");
        Sale sale = new Sale(ProductsSoldBuilder.build(10));
        boolean expResult = true;
        boolean result = sale.perform();
        assertThat(SalesHandler.isRecorded(sale)).isTrue();
        assertEquals(expResult, result);
    }

}
