package com.thinkinginjava.concurrency.example.chapter21_2.ex21_2_11;

public class Joining {
    public static void main(String[] args){
        Sleeper target1 = new Sleeper("target1",1500);
        Sleeper target2 = new Sleeper("target2",1500);

        //Joiner
        new Joiner("joiner1",target1);
        new Joiner("joiner2",target2);
        target2.interrupt();
    }
}
/**输出：
 * target2 isInterrupted() = false //线程target2中断了
 * joiner2 isAlive() = true        //线程joiner2活了
 * joiner2 join completed          //线程joiner2加入完成
 * target1 has awakened            //线程target1正常休眠时间结束
 * joiner1 isAlive() = true        //线程joiner1活了
 * joiner1 join completed          //线程joiner1加入完成
 *
 * 结论：一个线程a和另一目标线程b。在线程a中调用b.join();此线程a会被挂起，直到目标线程b结束才恢复。
 *  --> 等目标线程b结束，线程a加入完成。
 *  --> 或者b.interrupt();中断目标线程b运行,线程a加入完成。
 *  无论目标线程b被中断或是正常结束，线程a将和目标线程b一起结束。
 *
 *  第一句输出的疑问：为什么目标线程target2.interrupt();输出返回还是isInterrupted()=false?
 *  page 671
 *     当另一个线程在该线程上调用interrupt()时，将给该线程设定一个标志，表明该线程已经被中断。
 *  然而，异常被捕获时将清理这个标志，所以在catch子句中，在异常被捕获时这个表示总是为false。除
 *  异常之外，这个标志还可用于其他情况，比如线程可能会检查它的中断状态。
 */
