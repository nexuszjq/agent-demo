package com.nexus;

import java.lang.instrument.Instrumentation;

/**
 * premain 可以在main运行之前进行一些操作
 * -Xbootclasspath/a:C:\Users\Nexus\.m2\repository\org\javassist\javassist\3.28.0-GA\javassist-3.28.0-GA.jar
 * -javaagent:C:\Users\Nexus\.m2\repository\com\nexus\premain\1.0-SNAPSHOT\premain-1.0-SNAPSHOT.jar
 *
 * @author nexus 2022/05/28 20:57
 */
public class AgentByPremain {
    public static void premain(String agentOps, Instrumentation instrumentation) {
        System.out.println("======> premain started");
        instrumentation.addTransformer(new PremainTransformer());
    }
}
