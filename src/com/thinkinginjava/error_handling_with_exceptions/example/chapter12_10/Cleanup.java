package com.thinkinginjava.error_handling_with_exceptions.example.chapter12_10;

/**
 * @Author: monika
 * @Date: 2018/12/30 16:00
 * @Version: 1.0
 * @Description:
 */
public class Cleanup {
    public static void main(String[] args) {
        try {
            InputFile in = new InputFile("src\\com\\thinkinginjava\\error_handling_with_exceptions\\example\\chapter12_10\\Cleanup.java");
            try {
                String s;
                int i = 1;
                while ((s = in.getLine()) != null)
                    ;
                    //System.out.println(s);
            }catch (Exception e){
                System.out.println("Caught Exception in main");
                e.printStackTrace(System.out);
            }finally {
                in.dispose();
            }
        } catch (Exception e) {
            System.out.println("InputFile construction fialed");
        }
    }
}
/**output:
 * dispose() successful
 */