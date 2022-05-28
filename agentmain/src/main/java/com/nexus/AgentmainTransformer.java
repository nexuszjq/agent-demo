package com.nexus;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

/**
 * desc
 *
 * @author nexus 2022/05/29 0:52
 */
public class AgentmainTransformer implements ClassFileTransformer {

    private final String targetClassName;

    public AgentmainTransformer(String targetClassName) {
        this.targetClassName = targetClassName;
    }

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        className = className.replaceAll("/", ".");
        if (!className.equals(targetClassName)) {
            return null;
        }

        try {
            ClassPool classPool = ClassPool.getDefault();
            classPool.insertClassPath(className);
            CtClass ctClass = classPool.get(className);
            for (CtMethod ctMethod : ctClass.getDeclaredMethods()) {
                if (Modifier.isPublic(ctMethod.getModifiers()) && !ctMethod.getName().equals("main")) {
                    // 修改字节码
                    ctMethod.addLocalVariable("begin", CtClass.longType);
                    ctMethod.addLocalVariable("end", CtClass.longType);
                    ctMethod.insertBefore("begin = System.nanoTime();");
                    ctMethod.insertAfter("end = System.nanoTime();");
                    ctMethod.insertAfter("System.out.println(\"方法" + ctMethod.getName() + "耗时\"+ (end - begin) +\"ns\");");
                }
            }
            ctClass.detach();
            return ctClass.toBytecode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classfileBuffer;
    }
}
