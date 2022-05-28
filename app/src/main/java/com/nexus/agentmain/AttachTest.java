package com.nexus.agentmain;

import com.sun.tools.attach.*;

import java.io.IOException;

/**
 * desc
 *
 * @author nexus 2022/05/29 1:04
 */
public class AttachTest {
    public static void main(String[] args) throws IOException, AttachNotSupportedException, AgentLoadException, AgentInitializationException {
        for (VirtualMachineDescriptor descriptor: VirtualMachine.list()) {
            if (descriptor.displayName().equals("com.nexus.agentmain.RunnableTask")) {
                VirtualMachine virtualMachine = VirtualMachine.attach(descriptor.id());
                virtualMachine.loadAgent("C:\\Users\\Nexus\\.m2\\repository\\com\\nexus\\agentmain\\1.0-SNAPSHOT\\agentmain-1.0-SNAPSHOT.jar", "com.nexus.agentmain.RunnableTask");
                virtualMachine.detach();
            }
        }
    }
}
