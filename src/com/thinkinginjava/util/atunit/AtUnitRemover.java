package com.thinkinginjava.util.atunit;

import com.thinkinginjava.util.BinaryFile;
import com.thinkinginjava.util.ProcessFiles;
import static com.thinkinginjava.util.Print.*;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.annotation.Annotation;

import java.io.*;

/**
 * 在已编译的类文件中显示@Unit注释。
 * 如果第一个参数是“-r”，@ Unit注释被删除。
 * {Args：..}
 * {Requires：javassist.bytecode.ClassFile;
 * 您必须安装Javassist库http://sourceforge.net/projects/jboss/}
 */
public class AtUnitRemover implements ProcessFiles.Strategy {
    private static boolean remove = false;

    public static void main(String[] args) throws Exception {
        if (args.length > 0 && args[0].equals("-r")) {
            remove = true;
            String[] nargs = new String[args.length - 1];
            System.arraycopy(args, 1, nargs, 0, nargs.length);
            args = nargs;
        }
        new ProcessFiles(new AtUnitRemover(), "class").start(args);
    }

    public void process(File cFile) {
        boolean modified = false;
        try {
            String cName = ClassNameFinder.thisClass(BinaryFile.read(cFile));
            if (!cName.contains("."))
                return; // 忽略未打包的类
            ClassPool cPool = ClassPool.getDefault();
            CtClass ctClass = cPool.get(cName);
            for (CtMethod method : ctClass.getDeclaredMethods()) {
                MethodInfo mi = method.getMethodInfo();
                AnnotationsAttribute attr = (AnnotationsAttribute) mi.getAttribute(AnnotationsAttribute.visibleTag);
                if (attr == null)
                    continue;
                for (Annotation ann : attr.getAnnotations()) {
                    if (ann.getTypeName()
                            .startsWith("com.thinkinginjava.util.atunit")) {
                        print(String.format("%s Method: %s %s", ctClass.getName(), mi.getName(), ann));
                        if (remove) {
                            ctClass.removeMethod(method);
                            modified = true;
                        }
                    }
                }
            }
            // 此版本中不删除字段（请参阅文本）.
            if (modified)
                ctClass.toBytecode(new DataOutputStream(new FileOutputStream(cFile)));
            ctClass.detach();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
} ///:~
