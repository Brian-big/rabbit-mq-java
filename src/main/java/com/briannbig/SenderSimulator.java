package com.briannbig;

import java.io.IOException;

public class SenderSimulator {
    static Send sender = new Send();
    public static void main(String[] args) throws IOException {
        sender.send("Lighter task ..");
        sender.send("Light task ....");
        sender.send("Heavy task ........");
        sender.send("Heavier task ............");
        sender.send("Heaviest task ...............");
    }
}