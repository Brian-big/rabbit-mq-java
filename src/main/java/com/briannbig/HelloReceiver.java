package com.briannbig;

import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class HelloReceiver {
    private final HelloProcessor processor = new HelloProcessor();
    public void startReceiving () throws IOException {
        DeliverCallback deliverCallback = ((consumerTag, message) -> {
            String receivedMessage  = new String(message.getBody(), StandardCharsets.UTF_8);
            System.out.println(" [ x ] received ' " + receivedMessage + "'");
            try {
                processor.doProcess(receivedMessage);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println(" [ x ] DONE");
                Config.getInstance().getDefaultChannel().queueDeclare(Config.DURABLE_QUEUE, true, false, false, null);
                Config.getInstance().getDefaultChannel().basicAck(message.getEnvelope().getDeliveryTag(), false);
            }
        });
        Config.getInstance().getDefaultChannel().basicConsume(Config.QUEUE_NAME, false, deliverCallback, consumerTag -> {} );




    }
}
