package com.briannbig;

import java.io.IOException;

public class Send {
    public void send(String message) throws IOException {
        String msg = String.join(" ", message);
        Config.getInstance().getDefaultChannel().basicPublish("", Config.QUEUE_NAME, null, msg.getBytes());
        System.out.println(" [x] Sent '" + msg +"'");
    }
}
