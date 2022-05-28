package com.nexus;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

/**
 * desc
 *
 * @author nexus 2022/05/28 20:58
 */
public class PremainTransformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        String loadName = className.replace("/", ".");
        if (className.endsWith("App")) {
            try {
                //javassist 完成字节码增强(打印方法的执行时间<纳秒>)
                CtClass ctClass = ClassPool.getDefault().get(loadName);
                CtMethod ctMethod = ctClass.getDeclaredMethod("printMsg");
                ctMethod.addLocalVariable("_startTime", CtClass.longType);
                ctMethod.insertBefore("_startTime = System.nanoTime();");
                ctMethod.insertAfter("System.out.println(\"cost: \" + (System.nanoTime() - _startTime) + \"ns\");");
                return ctClass.toBytecode();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return classfileBuffer;
    }
}
