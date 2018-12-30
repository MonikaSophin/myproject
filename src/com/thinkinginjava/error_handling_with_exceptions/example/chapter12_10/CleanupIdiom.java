package com.thinkinginjava.error_handling_with_exceptions.example.chapter12_10;

/**
 * @Author: monika
 * @Date: 2018/12/30 16:13
 * @Version: 1.0
 * @Description:
 */
class NeedsCleanup {
    private static long counter = 1;
    private final long id = counter++;
    public void dispose() {
        System.out.println("NeedsCleanup " + id + " disposed");
    }
}

class ConstructionException extends Exception {}

class NeedsCleanup2 extends NeedsCleanup {
    public NeedsCleanup2() throws ConstructionException {}
}

public class CleanupIdiom {
    public static void main(String[] args) {
        //第一种情况：构造器中没有出现异常。
        NeedsCleanup nc1 = new NeedsCleanup();
        try {
            // ...
        } finally {
            nc1.dispose();
        }

        NeedsCleanup nc2 = new NeedsCleanup();
        NeedsCleanup nc3 = new NeedsCleanup();
        try {
            // ...
        } finally {
            nc2.dispose();
            nc3.dispose();
        }

        //第二种情况：构造器中抛出异常
        try {
            NeedsCleanup2 nc4 = new NeedsCleanup2();
            try {
                NeedsCleanup2 nc5 = new NeedsCleanup2();
                try {
                    //...
                } finally {
                    nc5.dispose();
                }
            } catch (ConstructionException e) {// nc5 constructor
                System.out.println(e);
            } finally {
                nc4.dispose();
            }
        } catch (ConstructionException e) {// nc4 constructor
            System.out.println(e);
        }
    }
}
/**output:
 * NeedsCleanup 1 disposed
 * NeedsCleanup 2 disposed
 * NeedsCleanup 3 disposed
 * NeedsCleanup 5 disposed
 * NeedsCleanup 4 disposed
 */