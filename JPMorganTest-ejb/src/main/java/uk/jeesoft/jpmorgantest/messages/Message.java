/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.jeesoft.jpmorgantest.messages;

import uk.jeesoft.jpmorgantest.sales.Sale;

/**
 *
 * @author carl
 */
public class Message {

    private final int id;
    private final Sale sale;

    private boolean processed;

    public Message(int newId, Sale newSales) {
        id = newId;
        sale = newSales;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    Sale getSales() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
