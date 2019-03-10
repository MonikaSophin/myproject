package com.thinkinginjava.io.exercise.chapter18_1;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @Author: monika
 * @Date: 2019/3/10 20:37
 * @Version: 1.0
 * @Description: page 528
 * 练习02：创建一个叫做SortedDirList的类，它具有一个可以接受文件路径信息，并能
 * 构建该路径下的排序目录列表的构造器。向这个类添加两个重载的list()方法：一个产生
 * 整个列表，另一个产生与其参数（一个正则表达式）相匹配的列表的子集。
 */
class SortedDirList {
    private String pathname;
    public SortedDirList(String pathname) {
        this.pathname = pathname;
    }
    public void list() {
        File file = new File(pathname);
        String[] list = file.list();
        System.out.println(Arrays.toString(list));
    }
    public void list(final String regex) {
        File file = new File(pathname);
        String[] matchlist = file.list(new FilenameFilter() {
            Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
        System.out.println(Arrays.toString(matchlist));
    }
}

public class Ex02 {
    public static void main(String[] args) {
        SortedDirList sortedDirList = new SortedDirList(
           "E:\\workspace\\idea\\myproject\\src\\com\\thinkinginjava\\io\\exercise\\chapter18_1"
        );
        sortedDirList.list();
        System.out.println();
        sortedDirList.list("\\w+\\.java");
    }
}
/**output:
 * [Ex01.java, Ex02.java, Ex03.java, package-info.java]
 *
 * [Ex01.java, Ex02.java, Ex03.java]
 */