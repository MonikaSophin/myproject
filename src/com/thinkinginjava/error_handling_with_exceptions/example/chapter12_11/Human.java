package com.thinkinginjava.error_handling_with_exceptions.example.chapter12_11;

/**
 * @Author: monika
 * @Date: 2018/12/30 17:31
 * @Version: 1.0
 * @Description:
 */
class Annoyance extends Exception {}
class Sneeze extends Annoyance {}

public class Human {
    public static void main(String[] args) {
        try{
            throw new Sneeze();
        }catch (Sneeze e){
            System.out.println("Caught Sneeze");
        }catch (Annoyance e){
            System.out.println("Caught Annoyance");
        }

        try{
            throw new Annoyance();
        }catch (Annoyance e){
            System.out.println("Caught Annoyance");
        }
    }
}
/**output:
 * Caught Sneeze
 * Caught Annoyance
 */