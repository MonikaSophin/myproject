package com.thinkinginjava.generics.example.chapter15_7.ex15_7_4;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/12
 * @description:
 */
public class GenericHolder<T> {
    private T obj;
    public void setObj(T obj) { this.obj = obj; }
    public T getObj() { return obj; }

    public static void main(String[] args) {
        GenericHolder<String> holder = new GenericHolder<>();
        holder.setObj("Item");
        String s = holder.getObj();
    }
}
/** javap -c 反编译之后的这个类
 *
 * public class com.thinkinginjava.generics.example.chapter15_7.ex15_7_4.GenericHolder<T> {
 *   public com.thinkinginjava.generics.example.chapter15_7.ex15_7_4.GenericHolder();
 *     Code:
 *        0: aload_0
 *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *        4: return
 *
 *   public void setObj(T);
 *     Code:
 *        0: aload_0
 *        1: aload_1
 *        2: putfield      #2                  // Field obj:Ljava/lang/Object;
 *        5: return
 *
 *   public T getObj();
 *     Code:
 *        0: aload_0
 *        1: getfield      #2                  // Field obj:Ljava/lang/Object;
 *        4: areturn
 *
 *   public static void main(java.lang.String[]);
 *     Code:
 *        0: new           #3                  // class com/thinkinginjava/generics/example/chapter15_7/ex15_7_4/GenericHolder
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
 * 该类所产生的字节码与SimpleHolder类是相同的。这个转型动作由编译器完成。
 *
 * 由于setObj()和getObj()的字节码相同，所以在泛型中的所有工作都发生在边界处。
 * --- 对传递进来的值进行额外的编译期检查，并对插入对传递出去的转型。
 */