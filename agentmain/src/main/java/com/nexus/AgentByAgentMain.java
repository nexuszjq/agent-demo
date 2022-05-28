package com.nexus;

import com.nexus.agentmain.RunnableTask;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

/**
 * desc
 *
 * @author nexus 2022/05/29 0:51
 */
public class AgentByAgentMain {
    public static void agentmain(String agentOps, Instrumentation instrumentation) throws UnmodifiableClassException {
        System.out.println("======> agentmain started: " + agentOps);
        instrumentation.addTransformer(new AgentmainTransformer(agentOps), true);
        instrumentation.retransformClasses(RunnableTask.class);
    }
}
