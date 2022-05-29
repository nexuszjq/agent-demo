package com.nexus.agentmain2;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;

/**
 * desc
 *
 * @author nexus 2022/05/29 10:48
 */
public class Attacher {
    public static void main(String[] args) throws AttachNotSupportedException, IOException, AgentLoadException, AgentInitializationException {

        VirtualMachine vm = VirtualMachine.attach("2964"); // 目标 JVM pid
        vm.loadAgent("D:\\learning_workspace\\agent-demo\\agentmain2\\target\\agentmain2-1.0-SNAPSHOT-jar-with-dependencies.jar");
    }
}
