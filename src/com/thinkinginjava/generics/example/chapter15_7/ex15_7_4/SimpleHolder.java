package com.thinkinginjava.generics.example.chapter15_7.ex15_7_4;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/12
 * @description:
 */
public class SimpleHolder {
    private Object obj;
    public void setObj(Object obj) { this.obj = obj; }
    public Object getObj() { return obj; }

    public static void main(String[] args) {
        SimpleHolder holder = new SimpleHolder();
        holder.setObj("Item");
        String s = (String)holder.getObj();
    }
}
/** javap -c 反编译之后的这个类
 *
 * public class com.thinkinginjava.generics.example.chapter15_7.ex15_7_4.SimpleHolder {
 *   public com.thinkinginjava.generics.example.chapter15_7.ex15_7_4.SimpleHolder();
 *     Code:
 *        0: aload_0
 *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *        4: return
 *
 *   public void setObj(java.lang.Object);
 *     Code:
 *        0: aload_0
 *        1: aload_1
 *        2: putfield      #2                  // Field obj:Ljava/lang/Object;
 *        5: return
 *
 *   public java.lang.Object getObj();
 *     Code:
 *        0: aload_0
 *        1: getfield      #2                  // Field obj:Ljava/lang/Object;
 *        4: areturn
 *
 *   public static void main(java.lang.String[]);
 *     Code:
 *        0: new           #3                  // class com/thinkinginjava/generics/example/chapter15_7/ex15_7_4/SimpleHolder
 *        3: dup
 *        4: invokespecial #4                  // Method "<init>":()V
 *        7: astore_1
 *        8: aload_1
 *        9: ldc           #5                  // String Item
 *       11: invokevirtual #6                  // Method setObj:(Ljava/lang/Object;)V
 *       14: aload_1
 *       15: invokevirtual #7                  // Method getObj:()Ljava/lang/Object;
 *       18: checkcast     #8                  // class java/lang/String
 *       21: astore_2
 *       22: return
 * }
 *
 *
 *  setObj()和getObj()方法是直接存储和产生值，而转型是在调用getObject()的时候接受检查的。
 */