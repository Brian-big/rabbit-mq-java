package com.briannbig;

import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class HelloReceiver {
    public void startReceiving() {
        DeliverCallback deliverCallback = ((consumerTag, message) -> {
            String receivedMessage  = new String(message.getBody(), StandardCharsets.UTF_8);
            try {
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(" [ x ] received ' " + receivedMessage + "'");
        });
        try {
            Config.getInstance().getDefaultChannel().basicConsume(Config.QUEUE_NAME, true, deliverCallback, consumerTag -> {} );
        } catch (IOException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }

    }
}
