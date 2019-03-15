package com.thinkinginjava.io.example.chapter18_11.ex18_11_3;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/15
 * @description:
 */
public class TestJarCommand {
    public static void main(String[] args) {
        System.out.println("jar command:");
        /**
         *  参数c:创建一个新的或空的压缩文档
         *  参数f:指定压缩文档名
         *  创建一个名为myJarFile的JAR文件，自动产生MF清单文件
         */
        System.out.println("jar cf myJarFile.jar *.java");

        /**
         *  参数m:表示第一个参数将是用户自建的清单文件的名字
         *  给名为myJarFile的JAR文件，添加一个名为myManifestFile.mf的清单文件
         */
        System.out.println("jar cmf myJarFile.jar myManifestFile.MF *.java");

        /**
         * 参数t:产生目录表
         * 会产生一个myJarFile.jar内所有文件的一个目录表
         */
        System.out.println("jar tf myJarFile.jar");

        /**
         * 参数v:更加详细的jar内文件的信息
         */
        System.out.println("jar tvf myJarFile.jar");
    }
}
/**output:
 * 略~
 */