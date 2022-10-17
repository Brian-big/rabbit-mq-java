package com.briannbig;

import java.io.IOException;

public class Send {
    public void send(String message) throws IOException {
        Config.getInstance().getDefaultChannel().basicPublish("", Config.QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message +"'");
    }
}
