package com.thinkinginjava.inner_classes.example.chapter10_5;

/**
 * @Author: monika
 * @Date: 2018/12/5 17:28
 * @Version: 1.0
 * @Description:  TrackingShip类被嵌套在if语句的作用域内，这并不是说该类的创建时有条件的，
 *             它其实与别的类一起编译过了。然而，在定义TrackingSlip的作用域之外，它是不可用的；
 *             除此之外，它与普通的类一样。
 */
public class Parcel6 {
    private void internalTracking(boolean b){
        if (b){
            class TrackingSlip{
                private String id;
                TrackingSlip(String s){id = s;}
                String getSlip(){return id;}
            }
            TrackingSlip ts = new TrackingSlip("slip");
            String s = ts.getSlip();
            System.out.println(s);
        }
        //不能在内部类所在的作用域以外 使用该作用域的内部类
        //! TrackingSlip ts = new TrackingSlip();
    }

    public void track(){internalTracking(true);}
    public static void main(String[] args) {
        Parcel6 p = new Parcel6();
        p.track();
    }
}
/**输出；
 * slip
 */