package com.commons.io.file_monitor;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;

/**
 * @author XueYing.Cao
 * @date 2019/9/11
 */
public class FileMonitorExample {

    public static void main(String[] args) {

        //待监听的文件夹
        String dirPath = "D:/GithubRepository/myproject/src/com/commons/io/file_monitor/src/";
        File dirFile = FileUtils.getFile(dirPath);

        //待新建的文件、文件夹
        String newFilePath = "D:/GithubRepository/myproject/src/com/commons/io/file_monitor/src/new_file.txt";
        String newDirPath = "D:/GithubRepository/myproject/src/com/commons/io/file_monitor/src/new_dir";

        /**
         * FileAlterationObserver : 可以观察指定File对象。
         */
        FileAlterationObserver observer = new FileAlterationObserver(dirFile);
        observer.addListener(new FileAlterationListenerAdaptor() {
            @Override
            public void onFileCreate(File file) {
                System.out.println("File created: " + file.getName());
            }

            @Override
            public void onFileDelete(File file) {
                System.out.println("File deleted: " + file.getName());
            }

            @Override
            public void onDirectoryCreate(File dir) {
                System.out.println("Directory created: " + dir.getName());
            }

            @Override
            public void onDirectoryDelete(File dir) {
                System.out.println("Directory deleted: " + dir.getName());
            }
        });

        /**
         * FileAlterationMonitor : 是一个Runable任务，可以指定间隔多少ms去观察。
         */
        FileAlterationMonitor monitor = new FileAlterationMonitor(1, observer);

        try {
            // 开始监听任务
            monitor.start();

            // 开始创建文件、文件夹
            File newFile = FileUtils.getFile(newFilePath);
            File newDir = FileUtils.getFile(newDirPath);
            newFile.createNewFile();
            newDir.mkdirs();

            Thread.sleep(1000);

            // 开始删除文件、文件夹
            newFile.delete();
            newDir.delete();

            Thread.sleep(1000);

            //停止监听任务
            monitor.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
/**output:
 * Directory created: new_dir
 * File created: new_file.txt
 * Directory deleted: new_dir
 * File deleted: new_file.txt
 */