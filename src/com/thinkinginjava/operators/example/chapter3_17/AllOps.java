package com.thinkinginjava.operators.example.chapter3_17;

/**
 * @Author: monika
 * @Date: 2018/11/4 18:19
 * @Version: 1.0
 * @Description: 操作符总结：
 *
 *  赋值操作符：=
 *  算术操作符：+ - * / % += -= *= /= %= ++ --
 *        注意：-作为一元操作符就是用来标识负数的、 -作为二元操作符就是算术操作符
 *             ++和-- 就是一元操作符
 *  关系操作符：> >= < <= == !=
 *  逻辑操作符：&& || !(非)
 *        注意：&和|虽然也能作为逻辑‘与’和逻辑‘或’，但是不推荐使用，更多的还是用作按位‘与’和按位‘或’
 *  按位操作符：& | ~(非) ^ &= |= ^=
 *        注意：~(取反操作符)是一个一元操作符，不能与=联用。
 *            布尔类型不能执行按位'非'（大概是为了避免与逻辑NOT混淆）
 *            在移位表达式中,不能使用布尔运算。
 *  移位操作符：<< <<= >> >>= >>> >>>=
 *  直接常量： L(l) D(d) F(f) 0x(0X) e(E) 0(后面接0~7)
 *         注意： 0x表示十六进制数，后面接0~9和a~f(A~F)
 *               八进制数由前缀0和后续的0~7的数字来表示
 *               e(E)表示底数为10的指数。例如:3e22 -->3*10²²
 *  三元操作符： (true/false)？true:false;
 *  类型转换操作符：()
 *
 */
public class AllOps {
    void f(boolean b) {}
    void boolTest(boolean x, boolean y) {
        // Arithmetic operators:
        //! x = x * y;
        //! x = x / y;
        //! x = x % y;
        //! x = x + y;
        //! x = x - y;
        //! x++;
        //! x--;
        //! x = +y;
        //! x = -y;
        // Relational and logical:
        //! f(x > y);
        //! f(x >= y);
        //! f(x < y);
        //! f(x <= y);
        f(x == y);
        f(x != y);
        f(!y);
        x = x && y;
        x = x || y;
        // Bitwise operators:
        //! x = ~y;
        x = x & y;
        x = x | y;
        x = x ^ y;
        //! x = x << 1;
        //! x = x >> 1;
        //! x = x >>> 1;
        // Compound assignment:
        //! x += y;
        //! x -= y;
        //! x *= y;
        //! x /= y;
        //! x %= y;
        //! x <<= 1;
        //! x >>= 1;
        //! x >>>= 1;
        x &= y;
        x ^= y;
        x |= y;
        // Casting:
        //! char c = (char)x;
        //! byte b = (byte)x;
        //! short s = (short)x;
        //! int i = (int)x;
        //! long l = (long)x;
        //! float f = (float)x;
        //! double d = (double)x;
    }

    void charTest(char x, char y) {
        // Arithmetic operators:
        x = (char) (x * y);
        x = (char) (x / y);
        x = (char) (x % y);
        x = (char) (x + y);
        x = (char) (x - y);
        x++;
        x--;
        x = (char) +y;
        x = (char) -y;
        // Relational and logical:
        f(x > y);
        f(x >= y);
        f(x < y);
        f(x <= y);
        f(x == y);
        f(x != y);
        //! f(!x);
        //! f(x && y);
        //! f(x || y);
        // Bitwise operators:
        x = (char) ~y;
        x = (char) (x & y);
        x = (char) (x | y);
        x = (char) (x ^ y);
        x = (char) (x << 1);
        x = (char) (x >> 1);
        x = (char) (x >>> 1);
        // Compound assignment:
        x += y;
        x -= y;
        x *= y;
        x /= y;
        x %= y;
        x <<= 1;
        x >>= 1;
        x >>>= 1;
        x &= y;
        x ^= y;
        x |= y;
        // Casting:
        //! boolean bl = (boolean)x;
        byte b = (byte) x;
        short s = (short) x;
        int i = (int) x;
        long l = (long) x;
        float f = (float) x;
        double d = (double) x;
    }

    void byteTest(byte x, byte y) {
        // Arithmetic operators:
        x = (byte) (x * y);
        x = (byte) (x / y);
        x = (byte) (x % y);
        x = (byte) (x + y);
        x = (byte) (x - y);
        x++;
        x--;
        x = (byte) +y;
        x = (byte) -y;
        // Relational and logical:
        f(x > y);
        f(x >= y);
        f(x < y);
        f(x <= y);
        f(x == y);
        f(x != y);
        //! f(!x);
        //! f(x && y);
        //! f(x || y);
        // Bitwise operators:
        x = (byte) ~y;
        x = (byte) (x & y);
        x = (byte) (x | y);
        x = (byte) (x ^ y);
        x = (byte) (x << 1);
        x = (byte) (x >> 1);
        x = (byte) (x >>> 1);
        // Compound assignment:
        x += y;
        x -= y;
        x *= y;
        x /= y;
        x %= y;
        x <<= 1;
        x >>= 1;
        x >>>= 1;
        x &= y;
        x ^= y;
        x |= y;
        // Casting:
        //! boolean bl = (boolean)x;
        char c = (char) x;
        short s = (short) x;
        int i = (int) x;
        long l = (long) x;
        float f = (float) x;
        double d = (double) x;
    }

    void shortTest(short x, short y) {
        // Arithmetic operators:
        x = (short) (x * y);
        x = (short) (x / y);
        x = (short) (x % y);
        x = (short) (x + y);
        x = (short) (x - y);
        x++;
        x--;
        x = (short) +y;
        x = (short) -y;
        // Relational and logical:
        f(x > y);
        f(x >= y);
        f(x < y);
        f(x <= y);
        f(x == y);
        f(x != y);
        //! f(!x);
        //! f(x && y);
        //! f(x || y);
        // Bitwise operators:
        x = (short) ~y;
        x = (short) (x & y);
        x = (short) (x | y);
        x = (short) (x ^ y);
        x = (short) (x << 1);
        x = (short) (x >> 1);
        x = (short) (x >>> 1);
        // Compound assignment:
        x += y;
        x -= y;
        x *= y;
        x /= y;
        x %= y;
        x <<= 1;
        x >>= 1;
        x >>>= 1;
        x &= y;
        x ^= y;
        x |= y;
        // Casting:
        //! boolean bl = (boolean)x;
        char c = (char) x;
        byte b = (byte) x;
        int i = (int) x;
        long l = (long) x;
        float f = (float) x;
        double d = (double) x;
    }

    void intTest(int x, int y) {
        // Arithmetic operators:
        x = x * y;
        x = x / y;
        x = x % y;
        x = x + y;
        x = x - y;
        x++;
        x--;
        x = +y;
        x = -y;
        // Relational and logical:
        f(x > y);
        f(x >= y);
        f(x < y);
        f(x <= y);
        f(x == y);
        f(x != y);
        //! f(!x);
        //! f(x && y);
        //! f(x || y);
        // Bitwise operators:
        x = ~y;
        x = x & y;
        x = x | y;
        x = x ^ y;
        x = x << 1;
        x = x >> 1;
        x = x >>> 1;
        // Compound assignment:
        x += y;
        x -= y;
        x *= y;
        x /= y;
        x %= y;
        x <<= 1;
        x >>= 1;
        x >>>= 1;
        x &= y;
        x ^= y;
        x |= y;
        // Casting:
        //! boolean bl = (boolean)x;
        char c = (char) x;
        byte b = (byte) x;
        short s = (short) x;
        long l = (long) x;
        float f = (float) x;
        double d = (double) x;
    }

    void longTest(long x, long y) {
        // Arithmetic operators:
        x = x * y;
        x = x / y;
        x = x % y;
        x = x + y;
        x = x - y;
        x++;
        x--;
        x = +y;
        x = -y;
        // Relational and logical:
        f(x > y);
        f(x >= y);
        f(x < y);
        f(x <= y);
        f(x == y);
        f(x != y);
        //! f(!x);
        //! f(x && y);
        //! f(x || y);
        // Bitwise operators:
        x = ~y;
        x = x & y;
        x = x | y;
        x = x ^ y;
        x = x << 1;
        x = x >> 1;
        x = x >>> 1;
        // Compound assignment:
        x += y;
        x -= y;
        x *= y;
        x /= y;
        x %= y;
        x <<= 1;
        x >>= 1;
        x >>>= 1;
        x &= y;
        x ^= y;
        x |= y;
        // Casting:
        //! boolean bl = (boolean)x;
        char c = (char) x;
        byte b = (byte) x;
        short s = (short) x;
        int i = (int) x;
        float f = (float) x;
        double d = (double) x;
    }

    void floatTest(float x, float y) {
        // Arithmetic operators:
        x = x * y;
        x = x / y;
        x = x % y;
        x = x + y;
        x = x - y;
        x++;
        x--;
        x = +y;
        x = -y;
        // Relational and logical:
        f(x > y);
        f(x >= y);
        f(x < y);
        f(x <= y);
        f(x == y);
        f(x != y);
        //! f(!x);
        //! f(x && y);
        //! f(x || y);
        // Bitwise operators:
        //! x = ~y;
        //! x = x & y;
        //! x = x | y;
        //! x = x ^ y;
        //! x = x << 1;
        //! x = x >> 1;
        //! x = x >>> 1;
        // Compound assignment:
        x += y;
        x -= y;
        x *= y;
        x /= y;
        x %= y;
        //! x <<= 1;
        //! x >>= 1;
        //! x >>>= 1;
        //! x &= y;
        //! x ^= y;
        //! x |= y;
        // Casting:
        //! boolean bl = (boolean)x;
        char c = (char) x;
        byte b = (byte) x;
        short s = (short) x;
        int i = (int) x;
        long l = (long) x;
        double d = (double) x;
    }

    void doubleTest(double x, double y) {
        // Arithmetic operators:
        x = x * y;
        x = x / y;
        x = x % y;
        x = x + y;
        x = x - y;
        x++;
        x--;
        x = +y;
        x = -y;
        // Relational and logical:
        f(x > y);
        f(x >= y);
        f(x < y);
        f(x <= y);
        f(x == y);
        f(x != y);
        //! f(!x);
        //! f(x && y);
        //! f(x || y);
        // Bitwise operators:
        //! x = ~y;
        //! x = x & y;
        //! x = x | y;
        //! x = x ^ y;
        //! x = x << 1;
        //! x = x >> 1;
        //! x = x >>> 1;
        // Compound assignment:
        x += y;
        x -= y;
        x *= y;
        x /= y;
        x %= y;
        //! x <<= 1;
        //! x >>= 1;
        //! x >>>= 1;
        //! x &= y;
        //! x ^= y;
        //! x |= y;
        // Casting:
        //! boolean bl = (boolean)x;
        char c = (char) x;
        byte b = (byte) x;
        short s = (short) x;
        int i = (int) x;
        long l = (long) x;
        float f = (float) x;
    }
}
