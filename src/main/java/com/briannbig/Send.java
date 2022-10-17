package com.briannbig;

import com.rabbitmq.client.MessageProperties;

import java.io.IOException;

public class Send {
    public void send(String message) throws IOException {
        String msg = String.join(" ", message);
        Config.getInstance().getDefaultChannel().queueDeclare(Config.DURABLE_QUEUE, true, false, false, null);
        Config.getInstance().getDefaultChannel().basicPublish("", Config.QUEUE_NAME,
                MessageProperties.PERSISTENT_TEXT_PLAIN, msg.getBytes());
        System.out.println(" [x] Sent '" + msg +"'");
    }
}
