package com.nexus.agentmain2;

/**
 * desc
 *
 * @author nexus 2022/05/29 10:51
 */
public class TransformTarget {
    public static void main(String[] args) {
        while (true) {
            try {
                Thread.sleep(3000L);
            } catch (Exception e) {
                break;
            }
            printSomething();
        }
    }

    public static void printSomething() {
        System.out.println("hello");
    }

}
