package com.nexus.jvmattach;

import com.sun.tools.attach.*;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * desc
 *
 * @author nexus 2022/05/29 0:41
 */
public class JvmAttach {
    public static void main(String[] args) throws IOException, AttachNotSupportedException, AgentLoadException, AgentInitializationException {
        List<VirtualMachineDescriptor> list = VirtualMachine.list();
        for (VirtualMachineDescriptor vmd : list) {
            if (vmd.displayName().endsWith("com.nexus.premain.App")) {
                System.out.println("Process pid: " + vmd.id());
                VirtualMachine virtualMachine = VirtualMachine.attach(vmd.id());
                Properties properties = virtualMachine.getSystemProperties();
                String javaVersion = properties.getProperty("java.version");
                System.out.println("Java version: " + javaVersion);
                System.out.println("Java properties: " + properties);
                virtualMachine.detach();
            }
        }
    }
}
