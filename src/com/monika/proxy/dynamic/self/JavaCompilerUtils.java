package com.monika.proxy.dynamic.self;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.util.Arrays;

/**
 * @author XueYing.Cao
 * @date 2020/5/22
 */
public class JavaCompilerUtils {
    private static JavaCompiler javaCompiler;

    private JavaCompilerUtils() {
    }

    private static JavaCompiler getJavaCompiler() {
        if (javaCompiler == null) {
            synchronized (JavaCompilerUtils.class) {
                if (javaCompiler == null) {
                    javaCompiler = ToolProvider.getSystemJavaCompiler();
                }
            }
        }
        return javaCompiler;
    }

    public static boolean CompilerJavaFile(String sourceFileInputPath,
                                           String classFileOutputPath) {
        // 设置编译选项，配置class文件输出路径
        Iterable<String> options = Arrays.asList("-d", classFileOutputPath);
        StandardJavaFileManager fileManager = getJavaCompiler()
                .getStandardFileManager(null, null, null);

        Iterable<? extends JavaFileObject> compilationUnits = fileManager
                .getJavaFileObjectsFromFiles(Arrays.asList(new File(
                        sourceFileInputPath)));

        return getJavaCompiler().getTask(null, fileManager, null, options,
                null, compilationUnits).call();
    }

}
