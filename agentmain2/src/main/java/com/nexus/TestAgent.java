package com.nexus;

import com.nexus.agentmain2.TransformTarget;

import java.lang.instrument.Instrumentation;

/**
 * mvn assembly:assembly
 *
 * @author nexus 2022/05/29 10:40
 */
public class TestAgent {
    public static void agentmain(String args, Instrumentation inst) {
        inst.addTransformer(new TestTransformer(), true);
        try {
            inst.retransformClasses(TransformTarget.class);
            System.out.println("Agent Load Done.");
        } catch (Exception e) {
            System.out.println("agent load failed!");
        }
    }
}
