package com.thinkinginjava.error_handling_with_exceptions.example.chapter12_10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author: monika
 * @Date: 2018/12/30 15:49
 * @Version: 1.0
 * @Description:
 */
public class InputFile {
    private BufferedReader in;
    public InputFile(String fname) throws Exception {
        try {
            in = new BufferedReader(new FileReader(fname));
        }catch (FileNotFoundException e){
            System.out.println("Could not open " + fname);
            throw e;
        }catch (Exception e){
            try{
                in.close();
            }catch (IOException e2){
                System.out.println("in.close() unsuccessful");
            }
            throw e;
        }finally {
            // Don't close it here!!
        }
    }

    public String getLine(){
        String s;
        try{
            s = in.readLine();
        }catch (IOException e){
            throw new RuntimeException("readLine() failed");
        }
        return s;
    }

    public void dispose(){
        try{
            in.close();
            System.out.println("dispose() successful");
        }catch (IOException e){
            throw new RuntimeException("in.close() failed");
        }
    }
}
