package cn.dubidubi.demo;

/**
 * @Auther: 16224
 * @Date: 2018/5/8 0008 11:42
 * @Description:
 */
public class AllDemo {

    public static void main(String[] args){
        TestClass TestClass =new TestClass();
        TestClass testClass2 =new TestClass();
        System.out.println(TestClass.getClass() == testClass2.getClass());
        System.out.println(TestClass.getClass() == testClass2.getClass());
    }
}
