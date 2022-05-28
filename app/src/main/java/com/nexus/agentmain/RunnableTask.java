package com.nexus.agentmain;

import java.util.concurrent.TimeUnit;

/**
 * desc
 *
 * @author nexus 2022/05/29 0:45
 */
public class RunnableTask implements Runnable{

    @Override
    public void run() {
        System.out.println("Running...");
    }

    public void shout() {
        System.out.println("Shouting...");
    }

    public static void main(String[] args) throws InterruptedException {
        RunnableTask task = new RunnableTask();
        while (true) {
            task.run();
            TimeUnit.SECONDS.sleep(2);
            task.shout();
            TimeUnit.SECONDS.sleep(2);

        }
    }
}
