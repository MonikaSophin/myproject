package com.monika.test;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;
import java.util.Map;

/**
 * @author: XueYing.Cao
 * @date: 2018/11/14
 * @description:
 */
public class ManagementFactoryTest {
    public static void main(String[] args) {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        String bootClassPath = runtimeMXBean.getBootClassPath();
        String classPath = runtimeMXBean.getClassPath();
        Class<? extends RuntimeMXBean> aClass = runtimeMXBean.getClass();
        List<String> inputArguments = runtimeMXBean.getInputArguments();
        String libraryPath = runtimeMXBean.getLibraryPath();
        String managementSpecVersion = runtimeMXBean.getManagementSpecVersion();
        String name = runtimeMXBean.getName();
        String specName = runtimeMXBean.getSpecName();
        String specVendor = runtimeMXBean.getSpecVendor();
        String specVersion = runtimeMXBean.getSpecVersion();
        String vmName = runtimeMXBean.getVmName();
        String vmVendor = runtimeMXBean.getVmVendor();
        String vmVersion = runtimeMXBean.getVmVersion();
        Map<String, String> systemProperties = runtimeMXBean.getSystemProperties();
        long startTime = runtimeMXBean.getStartTime();
        long uptime = runtimeMXBean.getUptime();

        System.out.println("bootClassPath : " + bootClassPath);
        System.out.println("classPath : " + classPath);
        System.out.println("aClass : " + aClass);
        System.out.println("inputArguments : " + inputArguments);
        System.out.println("libraryPath : " + libraryPath);
        System.out.println("managementSpecVersion : " + managementSpecVersion);
        System.out.println("name : " + name);
        System.out.println("specName : " + specName);
        System.out.println("specVendor : " + specVendor);
        System.out.println("specVersion : " + specVersion);
        System.out.println("vmName : " + vmName);
        System.out.println("vmVendor : " + vmVendor);
        System.out.println("vmVersion : " + vmVersion);
        System.out.println("systemProperties : " + systemProperties);
        System.out.println("startTime : " + startTime);
        System.out.println("uptime : " + uptime);
    }
}
/**输出:
 * bootClassPath : D:\Java\jdk1.8.0_181\jre\lib\resources.jar;D:\Java\jdk1.8.0_181\jre\lib\rt.jar;D:\Java\jdk1.8.0_181\jre\lib\sunrsasign.jar;D:\Java\jdk1.8.0_181\jre\lib\jsse.jar;D:\Java\jdk1.8.0_181\jre\lib\jce.jar;D:\Java\jdk1.8.0_181\jre\lib\charsets.jar;D:\Java\jdk1.8.0_181\jre\lib\jfr.jar;D:\Java\jdk1.8.0_181\jre\classes
 * classPath : D:\Java\jdk1.8.0_181\jre\lib\charsets.jar;D:\Java\jdk1.8.0_181\jre\lib\deploy.jar;D:\Java\jdk1.8.0_181\jre\lib\ext\access-bridge-64.jar;D:\Java\jdk1.8.0_181\jre\lib\ext\cldrdata.jar;D:\Java\jdk1.8.0_181\jre\lib\ext\dnsns.jar;D:\Java\jdk1.8.0_181\jre\lib\ext\jaccess.jar;D:\Java\jdk1.8.0_181\jre\lib\ext\jfxrt.jar;D:\Java\jdk1.8.0_181\jre\lib\ext\localedata.jar;D:\Java\jdk1.8.0_181\jre\lib\ext\nashorn.jar;D:\Java\jdk1.8.0_181\jre\lib\ext\sunec.jar;D:\Java\jdk1.8.0_181\jre\lib\ext\sunjce_provider.jar;D:\Java\jdk1.8.0_181\jre\lib\ext\sunmscapi.jar;D:\Java\jdk1.8.0_181\jre\lib\ext\sunpkcs11.jar;D:\Java\jdk1.8.0_181\jre\lib\ext\zipfs.jar;D:\Java\jdk1.8.0_181\jre\lib\javaws.jar;D:\Java\jdk1.8.0_181\jre\lib\jce.jar;D:\Java\jdk1.8.0_181\jre\lib\jfr.jar;D:\Java\jdk1.8.0_181\jre\lib\jfxswt.jar;D:\Java\jdk1.8.0_181\jre\lib\jsse.jar;D:\Java\jdk1.8.0_181\jre\lib\management-agent.jar;D:\Java\jdk1.8.0_181\jre\lib\plugin.jar;D:\Java\jdk1.8.0_181\jre\lib\resources.jar;D:\Java\jdk1.8.0_181\jre\lib\rt.jar;D:\GithubRepository\myproject\out\production\myproject;C:\software\JetBrains\IntelliJ IDEA 2018.2\lib\idea_rt.jar
 * aClass : class sun.management.RuntimeImpl
 * inputArguments : [-Dvisualvm.id=13845994951238, -javaagent:C:\software\JetBrains\IntelliJ IDEA 2018.2\lib\idea_rt.jar=49904:C:\software\JetBrains\IntelliJ IDEA 2018.2\bin, -Dfile.encoding=UTF-8]
 * libraryPath : D:\Java\jdk1.8.0_181\bin;C:\Windows\Sun\Java\bin;C:\Windows\system32;C:\Windows;C:\Windows\system32;C:\Windows;C:\Windows\System32\Wbem;C:\Windows\System32\WindowsPowerShell\v1.0\;D:\Java\jdk1.8.0_181\bin;D:\Java\jdk1.8.0_181\jre\bin;D:\Apache\apache-maven-3.5.4\bin;C:\software\Git\cmd;D:\Oracle\mysql-5.7.23-winx64\bin;D:\Gradle\gradle-3.1\bin;D:\Scala\scala-2.11.11\bin;D:\Apache\apache-maven-3.5.4\bin;C:\Users\Administrator\AppData\Local\GitHubDesktop\bin;D:\Apache\apache-jmeter-5.0\bin;.
 * managementSpecVersion : 1.2
 * name : 1104@USER-20180809SJ
 * specName : Java Virtual Machine Specification
 * specVendor : Oracle Corporation
 * specVersion : 1.8
 * vmName : Java HotSpot(TM) 64-Bit Server VM
 * vmVendor : Oracle Corporation
 * vmVersion : 25.181-b13
 * systemProperties : {sun.desktop=windows, awt.toolkit=sun.awt.windows.WToolkit, file.encoding.pkg=sun.io, java.specification.version=1.8, sun.cpu.isalist=amd64, sun.jnu.encoding=GBK, java.class.path=D:\Java\jdk1.8.0_181\jre\lib\charsets.jar;D:\Java\jdk1.8.0_181\jre\lib\deploy.jar;D:\Java\jdk1.8.0_181\jre\lib\ext\access-bridge-64.jar;D:\Java\jdk1.8.0_181\jre\lib\ext\cldrdata.jar;D:\Java\jdk1.8.0_181\jre\lib\ext\dnsns.jar;D:\Java\jdk1.8.0_181\jre\lib\ext\jaccess.jar;D:\Java\jdk1.8.0_181\jre\lib\ext\jfxrt.jar;D:\Java\jdk1.8.0_181\jre\lib\ext\localedata.jar;D:\Java\jdk1.8.0_181\jre\lib\ext\nashorn.jar;D:\Java\jdk1.8.0_181\jre\lib\ext\sunec.jar;D:\Java\jdk1.8.0_181\jre\lib\ext\sunjce_provider.jar;D:\Java\jdk1.8.0_181\jre\lib\ext\sunmscapi.jar;D:\Java\jdk1.8.0_181\jre\lib\ext\sunpkcs11.jar;D:\Java\jdk1.8.0_181\jre\lib\ext\zipfs.jar;D:\Java\jdk1.8.0_181\jre\lib\javaws.jar;D:\Java\jdk1.8.0_181\jre\lib\jce.jar;D:\Java\jdk1.8.0_181\jre\lib\jfr.jar;D:\Java\jdk1.8.0_181\jre\lib\jfxswt.jar;D:\Java\jdk1.8.0_181\jre\lib\jsse.jar;D:\Java\jdk1.8.0_181\jre\lib\management-agent.jar;D:\Java\jdk1.8.0_181\jre\lib\plugin.jar;D:\Java\jdk1.8.0_181\jre\lib\resources.jar;D:\Java\jdk1.8.0_181\jre\lib\rt.jar;D:\GithubRepository\myproject\out\production\myproject;C:\software\JetBrains\IntelliJ IDEA 2018.2\lib\idea_rt.jar, java.vm.vendor=Oracle Corporation, sun.arch.data.model=64, user.variant=, java.vendor.url=http://java.oracle.com/, user.timezone=, visualvm.id=13845994951238, os.name=Windows 7, java.vm.specification.version=1.8, user.country=CN, sun.java.launcher=SUN_STANDARD, sun.boot.library.path=D:\Java\jdk1.8.0_181\jre\bin, sun.java.command=com.monika.test.ManagementFactoryTest, sun.cpu.endian=little, user.home=C:\Users\Administrator, user.language=zh, java.specification.vendor=Oracle Corporation, java.home=D:\Java\jdk1.8.0_181\jre, file.separator=\, line.separator=
 * , java.vm.specification.vendor=Oracle Corporation, java.specification.name=Java Platform API Specification, java.awt.graphicsenv=sun.awt.Win32GraphicsEnvironment, sun.boot.class.path=D:\Java\jdk1.8.0_181\jre\lib\resources.jar;D:\Java\jdk1.8.0_181\jre\lib\rt.jar;D:\Java\jdk1.8.0_181\jre\lib\sunrsasign.jar;D:\Java\jdk1.8.0_181\jre\lib\jsse.jar;D:\Java\jdk1.8.0_181\jre\lib\jce.jar;D:\Java\jdk1.8.0_181\jre\lib\charsets.jar;D:\Java\jdk1.8.0_181\jre\lib\jfr.jar;D:\Java\jdk1.8.0_181\jre\classes, user.script=, sun.management.compiler=HotSpot 64-Bit Tiered Compilers, java.runtime.version=1.8.0_181-b13, user.name=Administrator, path.separator=;, os.version=6.1, java.endorsed.dirs=D:\Java\jdk1.8.0_181\jre\lib\endorsed, java.runtime.name=Java(TM) SE Runtime Environment, file.encoding=UTF-8, java.vm.name=Java HotSpot(TM) 64-Bit Server VM, java.vendor.url.bug=http://bugreport.sun.com/bugreport/, java.io.tmpdir=C:\Users\ADMINI~1\AppData\Local\Temp\, java.version=1.8.0_181, user.dir=D:\GithubRepository\myproject, os.arch=amd64, java.vm.specification.name=Java Virtual Machine Specification, java.awt.printerjob=sun.awt.windows.WPrinterJob, sun.os.patch.level=Service Pack 1, java.library.path=D:\Java\jdk1.8.0_181\bin;C:\Windows\Sun\Java\bin;C:\Windows\system32;C:\Windows;C:\Windows\system32;C:\Windows;C:\Windows\System32\Wbem;C:\Windows\System32\WindowsPowerShell\v1.0\;D:\Java\jdk1.8.0_181\bin;D:\Java\jdk1.8.0_181\jre\bin;D:\Apache\apache-maven-3.5.4\bin;C:\software\Git\cmd;D:\Oracle\mysql-5.7.23-winx64\bin;D:\Gradle\gradle-3.1\bin;D:\Scala\scala-2.11.11\bin;D:\Apache\apache-maven-3.5.4\bin;C:\Users\Administrator\AppData\Local\GitHubDesktop\bin;D:\Apache\apache-jmeter-5.0\bin;., java.vm.info=mixed mode, java.vendor=Oracle Corporation, java.vm.version=25.181-b13, java.ext.dirs=D:\Java\jdk1.8.0_181\jre\lib\ext;C:\Windows\Sun\Java\lib\ext, sun.io.unicode.encoding=UnicodeLittle, java.class.version=52.0}
 * startTime : 1542176892473
 * uptime : 115
 */
