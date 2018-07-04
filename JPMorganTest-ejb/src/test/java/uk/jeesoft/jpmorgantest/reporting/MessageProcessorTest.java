/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.jeesoft.jpmorgantest.reporting;

import uk.jeesoft.jpmorgantest.logging.LogHandler;
import java.util.ArrayList;
import uk.jeesoft.jpmorgantest.messages.Message;
import uk.jeesoft.jpmorgantest.messages.MessageProcessor;
import uk.jeesoft.jpmorgantest.messages.MessageQueue;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import uk.jeesoft.jpmorgantest.config.AppConfig;

/**
 *
 * @author carl
 */
public class MessageProcessorTest {

    private int NR_OF_TEST_MESSAGES = 22;

    @Test
    public void allMessagesMustBeProcessed() {
        Message firstMessage = new Message(1, SalesBuilder.build(10));
        Message secondMessage = new Message(2, SalesBuilder.build(5));
        MessageQueue queue = new MessageQueue(firstMessage, secondMessage);
        MessageProcessor messageProcessor = new MessageProcessor();
        messageProcessor.process(queue);

        messageProcessor.forEach(message -> {
            assertThat(message.isProcessed()).isTrue();
        });

        assertThat(queue).isEmpty();
        assertThat(messageProcessor.size()).isEqualTo(2);
    }

    @Test
    public void logReport_nrOfSalesAndTotalValue_AfterEvery10Message() {
        // After every 10 th message received your application should log a report
        // detailing the number of sales of each product and their total value

        List<Message> messageList = new ArrayList<>();
        for (int messageNr = 0; messageNr < NR_OF_TEST_MESSAGES; messageNr++) {

            Message message = new Message(messageNr, SalesBuilder.build(messageNr));
            messageList.add(message);
        }
        MessageQueue queue = new MessageQueue(messageList.toArray(new Message[1]));
        MessageProcessor messageProcessor = new MessageProcessor();
        messageProcessor.process(queue);
        
        messageProcessor.forEach(message -> {
            assertThat(message.isProcessed()).isTrue();
        });

        assertThat(queue).isEmpty();
        assertThat(messageProcessor.size()).isEqualTo(AppConfig.MAXIMUM_PROCESSED_MESSAGES_STORED);
        assertThat(LogHandler.getLoggedReports().size()).isEqualTo(3);

    }

    @Test

    public void queueTest() {

        Queue<String> myQueue = new LinkedList();

        // add elements in the queue using offer() - return true/false
        myQueue.offer("Monday");
        myQueue.offer("Thusday");
        boolean flag = myQueue.offer("Wednesday");

        System.out.println("Wednesday inserted successfully? " + flag);

        // add more elements using add() - throws IllegalStateException
        try {
            myQueue.add("Thursday");
            myQueue.add("Friday");
            myQueue.add("Weekend");
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        System.out.println("Pick the head of the queue: " + myQueue.peek());

        String head = null;
        try {
            // remove head - remove()
            head = myQueue.remove();
            System.out.print("1) Push out " + head + " from the queue ");
            System.out.println("and the new head is now: " + myQueue.element());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        // remove the head - poll()
        head = myQueue.poll();
        System.out.print("2) Push out " + head + " from the queue");
        System.out.println("and the new head is now: " + myQueue.peek());

        // find out if the queue contains an object
        System.out.println("Does the queue contain 'Weekend'? " + myQueue.contains("Weekend"));
        System.out.println("Does the queue contain 'Monday'? " + myQueue.contains("Monday"));
    }

}
