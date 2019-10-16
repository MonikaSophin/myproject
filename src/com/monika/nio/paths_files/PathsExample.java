package com.monika.nio.paths_files;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author XueYing.Cao
 * @date 2019/10/15
 */
public class PathsExample {

    public static void main(String[] args) {
        /**
         * {@link Paths#get()} : 创建一个Path实例
         */
        Path path1 = Paths.get("D:\\GithubRepository\\myproject\\src\\com\\monika\\nio\\paths_files");
        System.out.println(path1);

        Path path2 = Paths.get(".");
        System.out.println(path2.toAbsolutePath());

        /**
         * {@link Path#normalize()} : 返回一个路径，此路径已消除多余的名称元素。
         */
        Path path3 = Paths.get("D:\\GithubRepository\\myproject\\src\\com\\monika\\nio\\a-project\\..\\paths_files");
        System.out.println(path3.normalize());
    }
}
/** output:
 * D:\GithubRepository\myproject\src\com\monika\nio\paths_files
 * D:\GithubRepository\myproject\.
 * D:\GithubRepository\myproject\src\com\monika\nio\paths_files
 */