package com.commons.io.utility_classes;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

/**
 * @author XueYing.Cao
 * @date 2019/9/9
 * commons-io常用工具类
 * FileUtils的示例
 */
public class FileUtilsExample {

    public static void main(String[] args) throws IOException {

        String fileInName1 = "D:/GithubRepository/myproject/src/com/commons/io/utility_classes/src/fileIn1";
        String fileOutName1 = "D:/GithubRepository/myproject/src/com/commons/io/utility_classes/dest/fileOut1";
        String fileOutName3 = "D:/GithubRepository/myproject/src/com/commons/io/utility_classes/dest/fileOut3.txt";

        /**
         * 1. getFile()              根据file_name获取File对象
         *    getTempDirectory()     获取系统临时目录的File对象
         *    getTempDirectoryPath() 获取系统临时目录的路径
         *    getUserDirectory()     获取系统用户目录的File对象
         *    getUserDirectoryPath() 获取系统用户目录的路径
         */
        File file = FileUtils.getFile(fileInName1);
        File tempDirectory = FileUtils.getTempDirectory();
        String tempDirectoryPath = FileUtils.getTempDirectoryPath();
        File userDirectory = FileUtils.getUserDirectory();
        String userDirectoryPath = FileUtils.getUserDirectoryPath();

        /**
         * 2.copyXxx()            File--copy-->File
         *   copyXxxToFile()      Xxx--copy-->File
         *   copyXxxToDirectory() Xxx--copy-->File
         */
        FileUtils.copyFile(new File(fileInName1), new File(fileOutName1));
        FileUtils.copyInputStreamToFile(new FileInputStream(fileInName1), new File(fileOutName1));
        FileUtils.copyURLToFile(new URL("http://www.baidu.com"), new File(fileOutName3));

    }
}
