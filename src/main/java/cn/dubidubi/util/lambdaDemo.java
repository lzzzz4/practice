package cn.dubidubi.util;

/**
 * @Auther: 16224
 * @Date: 2018/5/8 0008 15:12
 * @Description:
 */
public class lambdaDemo {
    public static void test(Demo1 demo1) {
        System.out.println("hello");
        System.out.println("hello world2");
        demo1.sb();
    }

    public static void main(String[] args) {
        int a = 20;
        int b = a > 10 ? 20 : 30;
        System.out.println("b = " + b);
    }
}
