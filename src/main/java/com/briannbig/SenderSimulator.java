package com.briannbig;

import java.io.IOException;

public class SenderSimulator {
    static Send sender = new Send();
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(1000*5);
                sender.send("Hello rabbit mQ : " + i );
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}