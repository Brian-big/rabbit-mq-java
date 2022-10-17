package com.briannbig;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Config {
    public static final String QUEUE_NAME = "hello";
    private static final ConnectionFactory factory = new ConnectionFactory();
    private static Config INSTANCE = null;
    private static Channel channel = null;

    public static Config getInstance() {
        if (INSTANCE == null){
            INSTANCE = new Config();
            factory.setHost("172.17.0.2");
            try {
                Connection connection = factory.newConnection();
                channel = connection.createChannel();
                channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            } catch (IOException | TimeoutException e) {
                throw new RuntimeException(e);
            }
        }
        return INSTANCE;
    }

    public Channel getDefaultChannel(){
       return channel;
    }
}
