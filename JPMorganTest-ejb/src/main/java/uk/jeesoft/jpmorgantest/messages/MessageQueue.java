/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.jeesoft.jpmorgantest.messages;

import java.util.LinkedList;

/**
 *
 * @author carl
 */
public class MessageQueue extends LinkedList<Message> {

    public MessageQueue(Message... messages) {
        for (Message message : messages) {
            add(message);
        }
    }

}
