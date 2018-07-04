/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.jeesoft.jpmorgantest.messages;

import java.util.ArrayList;
import uk.jeesoft.jpmorgantest.config.AppConfig;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import uk.jeesoft.jpmorgantest.sales.Sale;
import uk.jeesoft.jpmorgantest.xml.XMLDocumentHandler;

/**
 *
 * @author carl
 */
public class MessageProcessor extends LinkedList<Message> {

    public void process(MessageQueue queue) {
        Iterator<Message> iterator = queue.iterator();

        List<Sale> processedSales = new ArrayList<>();
        while (iterator.hasNext()) {
            if (processedSales.size() >= AppConfig.MESSAGES_REPORTING_INTERVAL) {
                IReport report = new XMLReport(processedSales);
                XMLDocumentHandler.write(report);
            }
            Message message = iterator.next();
            processedSales.add(message.getSales());
            message.setProcessed(true);
            addMessage(message);
        }
        queue.clear();
    }

    private void addMessage(Message message) {
        if (size() >= AppConfig.MAXIMUM_PROCESSED_MESSAGES_STORED) {
            removeFirst();
        }
        add(message);
    }

}
