package com.commons.io.utility_classes;

import org.apache.commons.io.FilenameUtils;

/**
 * @author XueYing.Cao
 * @date 2019/9/9
 * commons-io常用工具类
 *  FilenameUtils的示例
 */
public class FilenameUtilsExample {

    public static void main(String[] args) {

        String fileOutName3 = "D:/GithubRepository/myproject/src/com/commons/io/utility_classes/dest/fileOut3.txt";

        /**
         * 1. getBaseName()  获取文件的基本名称
         *    getExtension() 获取文件的扩展名
         *    getName()      获取文件名
         *
         *    getPrefix()    获取文件路径前缀
         *    getPath()      获取文件路径
         *    getFullPath()  获取文件完整路径
         */
        String baseName = FilenameUtils.getBaseName(fileOutName3);
        String extension = FilenameUtils.getExtension(fileOutName3);
        String name = FilenameUtils.getName(fileOutName3);
        String prefix = FilenameUtils.getPrefix(fileOutName3);
        String path = FilenameUtils.getPath(fileOutName3);
        String fullPath = FilenameUtils.getFullPath(fileOutName3);

        System.out.println("baseName: " + baseName);
        System.out.println("extension: " + extension);
        System.out.println("name: " + name);
        System.out.println();
        System.out.println("prefix: " + prefix);
        System.out.println("path: " + path);
        System.out.println("fullPath: " + fullPath);
    }
}
/**output:
 * baseName: fileOut3
 * extension: txt
 * name: fileOut3.txt
 *
 * prefix: D:/
 * path: GithubRepository/myproject/src/com/commons/io/utility_classes/dest/
 * fullPath: D:/GithubRepository/myproject/src/com/commons/io/utility_classes/dest/
 */