package com.thinkinginjava.holding_objects.example.chapter11_13;

import java.util.Map;

/**
 * @Author: monika
 * @Date: 2018/12/22 14:53
 * @Version: 1.0
 * @Description:
 */
public class EnvironmentVariables {
    public static void main(String[] args) {
        for (Map.Entry<String, String> entry : System.getenv().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
/**output:
 * USERDOMAIN_ROAMINGPROFILE: LAPTOP-2RBD7KUT
 * LOCALAPPDATA: C:\Users\User_Monika\AppData\Local
 * PROCESSOR_LEVEL: 6
 * USERDOMAIN: LAPTOP-2RBD7KUT
 * FPS_BROWSER_APP_PROFILE_STRING: Internet Explorer
 * LOGONSERVER: \\LAPTOP-2RBD7KUT
 * JAVA_HOME: E:\Java\JDK1.8
 * SESSIONNAME: Console
 * ALLUSERSPROFILE: C:\ProgramData
 * PROCESSOR_ARCHITECTURE: AMD64
 * NVIDIAWHITELISTED: 0x01
 * PSModulePath: C:\Program Files\WindowsPowerShell\Modules;C:\WINDOWS\system32\WindowsPowerShell\v1.0\Modules
 * SystemDrive: C:
 * MAVEN_HOME: E:\Apace\Maven\apache-maven-3.5.3
 * OneDrive: C:\Users\浮生\OneDrive
 * APPDATA: C:\Users\User_Monika\AppData\Roaming
 * USERNAME: User_Monika
 * ProgramFiles(x86): C:\Program Files (x86)
 * CommonProgramFiles: C:\Program Files\Common Files
 * Path: C:\Program Files (x86)\Intel\Intel(R) Management Engine Components\iCLS\;C:\Program Files\Intel\Intel(R) Management Engine Components\iCLS\;C:\Windows\system32;C:\Windows;C:\Windows\System32\Wbem;C:\Windows\System32\WindowsPowerShell\v1.0\;C:\Program Files (x86)\Intel\Intel(R) Management Engine Components\DAL;C:\Program Files\Intel\Intel(R) Management Engine Components\DAL;C:\Program Files (x86)\Intel\Intel(R) Management Engine Components\IPT;C:\Program Files\Intel\Intel(R) Management Engine Components\IPT;C:\Program Files (x86)\NVIDIA Corporation\PhysX\Common;C:\Program Files\MySQL\MySQL Server 5.5\bin;C:\WINDOWS\system32;C:\WINDOWS;C:\WINDOWS\System32\Wbem;C:\WINDOWS\System32\WindowsPowerShell\v1.0\;C:\WINDOWS\System32\OpenSSH\;E:\Git\Git\cmd;E:\Java\JDK1.8\bin;E:\Java\JDK1.8\jre\bin;E:\Apace\Maven\apache-maven-3.5.3\bin;C:\Users\User_Monika\AppData\Local\Microsoft\WindowsApps;C:\Users\User_Monika\AppData\Local\GitHubDesktop\bin
 * FPS_BROWSER_USER_PROFILE_STRING: Default
 * PATHEXT: .COM;.EXE;.BAT;.CMD;.VBS;.VBE;.JS;.JSE;.WSF;.WSH;.MSC
 * DriverData: C:\Windows\System32\Drivers\DriverData
 * OS: Windows_NT
 * COMPUTERNAME: LAPTOP-2RBD7KUT
 * PROCESSOR_REVISION: 9e0a
 * SHIM_MCCOMPAT: 0x810000001
 * CommonProgramW6432: C:\Program Files\Common Files
 * ComSpec: C:\WINDOWS\system32\cmd.exe
 * ProgramData: C:\ProgramData
 * ProgramW6432: C:\Program Files
 * HOMEPATH: \Users\User_Monika
 * SystemRoot: C:\WINDOWS
 * TEMP: C:\Users\USER_M~1\AppData\Local\Temp
 * HOMEDRIVE: C:
 * PROCESSOR_IDENTIFIER: Intel64 Family 6 Model 158 Stepping 10, GenuineIntel
 * USERPROFILE: C:\Users\User_Monika
 * TMP: C:\Users\USER_M~1\AppData\Local\Temp
 * CommonProgramFiles(x86): C:\Program Files (x86)\Common Files
 * ProgramFiles: C:\Program Files
 * PUBLIC: C:\Users\Public
 * NUMBER_OF_PROCESSORS: 12
 * windir: C:\WINDOWS
 * =::: ::\
 */