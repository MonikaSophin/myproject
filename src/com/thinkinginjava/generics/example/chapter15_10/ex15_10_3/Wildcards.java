package com.thinkinginjava.generics.example.chapter15_10.ex15_10_3;

import com.thinkinginjava.generics.example.chapter15_10.ex15_10_1.Holder;

/**
 * 通配符能做什么 不能做什么
 */
public class Wildcards {
    // 原始论点:
    static void rawArgs(Holder holder, Object arg) {
        // 警告:未选中调用set(T)作为原始类型Holder的成员
        holder.setValue(arg);
        // 相同的警告
        holder.setValue(new Wildcards());

        // 不能这样做;没有泛型'T':
        // T t = holder.getValue();

        // OK, 但类型信息已丢失:
        Object obj = holder.getValue();
    }

    // 与rawArgs（）类似，但错误而不是警告:
    static void unboundedArg(Holder<?> holder, Object arg) {
        // 错误: set(capture of ?) 在 Holder<capture of ?> 无法应用于(Object)
        // holder.setValue(arg);
        // 相同的错误
        // holder.setValue(new Wildcards());

        // 不能这样做;没有泛型'T':
        // T t = holder.getValue();

        // OK, 但类型信息已丢失:
        Object obj = holder.getValue();
    }

    static <T> T exact1(Holder<T> holder) {
        T t = holder.getValue();
        return t;
    }

    static <T> T exact2(Holder<T> holder, T arg) {
        holder.setValue(arg);
        T t = holder.getValue();
        return t;
    }

    static <T> T wildSubtype(Holder<? extends T> holder, T arg) {
        // 错误: set(capture of ? extends T) 在 Holder<capture of ? extends T>无法应用于 (T)
        // holder.setValue(arg);
        T t = holder.getValue();
        return t;
    }

    static <T> void wildSupertype(Holder<? super T> holder, T arg) {
        holder.setValue(arg);

        // 错误:不兼容的类型：找到 对象，必需 T
        // T t = holder.getValue();
        // OK, 但类型信息已丢失:
        Object obj = holder.getValue();
    }

    public static void main(String[] args) {
        Holder raw = new Holder<Long>();
        // Or:
        raw = new Holder();
        Holder<Long> qualified = new Holder<>();
        Holder<?> unbounded = new Holder<Long>();
        Holder<? extends Long> bounded = new Holder<>();
        Long lng = 1L;

        rawArgs(raw, lng);
        rawArgs(qualified, lng);
        rawArgs(unbounded, lng);
        rawArgs(bounded, lng);

        unboundedArg(raw, lng);
        unboundedArg(qualified, lng);
        unboundedArg(unbounded, lng);
        unboundedArg(bounded, lng);

       // 警告：未经检查的转换:从Holder到Holder<T> 未经检查的方法调用：exact1（Holder<T>）应用于（Holder）
        Object r1 = exact1(raw);

        Long r2 = exact1(qualified);
        Object r3 = exact1(unbounded); // 必须返回Object
        Long r4 = exact1(bounded);

        //警告：未经检查的转换：从Holder到Holder<Long> 未经检查的方法调用：exact2（Holder<T>，T）应用于（Holder，Long）
        Long r5 = exact2(raw, lng);
        Long r6 = exact2(qualified, lng);

        //错误：exact2（Holder <T>，T）无法应用于（Holder <capture of？>，Long）
        // Long r7 = exact2(unbounded, lng);
        //错误：exact2（Holder <T>，T）无法应用于（Holder <capture of？extends Long>，Long）
        // Long r8 = exact2(bounded, lng);

        //警告：未经检查的转换: Holder到Holder<？ extends Long>  未经检查方法调用： wildSubtype（Holder <？extends T>，T）应用于（Holder，Long）
        // Long r9 = wildSubtype(raw, lng);
        Long r10 = wildSubtype(qualified, lng);
        // OK, 但只能返回Object:
        Object r11 = wildSubtype(unbounded, lng);
        Long r12 = wildSubtype(bounded, lng);

        //警告：未经检查的转换：从Holder到Holder<？ super Long> 未经检查的方法调用：wildSupertype（Holder <？super T>，T）应用于（Holder，Long）
        // wildSupertype(raw, lng);
        wildSupertype(qualified, lng);
        // 错误：wildSupertype（Holder <？super T>，T）不能应用于（Holder <capture of？>，Long）
        // wildSupertype（bounded，lng）;
        // 错误：wildSupertype（Holder <？super T>，T）不能应用于（Holder <capture of？ extends Long>，Long）
        // wildSupertype(unbounded, lng);
    }
} ///:~
