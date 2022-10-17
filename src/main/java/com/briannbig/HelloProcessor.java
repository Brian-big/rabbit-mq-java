package com.briannbig;

public class HelloProcessor {
    public void doProcess(String message) throws InterruptedException {
        System.out.println("=====> processing " + message);
        for (char ch: message.toCharArray()){
            if (ch == '.') {
                Thread.sleep(1000 * 5);
                System.out.print(".");
            }
        }
        System.out.println("===== DONE =====");
    }
}
