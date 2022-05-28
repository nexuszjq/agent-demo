package com.nexus.premain;

/**
 * desc
 *
 * @author nexus 2022/05/28 20:56
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            printMsg("Hello World");
            Thread.sleep(2000);
        }

    }

    private static void printMsg(String message) {
        System.out.println(message);
    }
}
