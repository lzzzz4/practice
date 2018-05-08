package cn.dubidubi.demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @Auther: 16224
 * @Date: 2018/5/8 0008 11:17
 * @Description:
 */
@Test
public class TestClass {
    @Test("a")
    private String username;
    public static void main(String[] args) throws IllegalAccessException {
        TestClass TestClass =new TestClass();
        TestClass.username="lzj";
        Class<? extends cn.dubidubi.demo.TestClass> myClass = TestClass.getClass();
        Annotation[] annotations = myClass.getAnnotations();
        System.out.println("得到所有的注解");
        for (int i = 0; i < annotations.length; i++) {
            Annotation annotation = annotations[i];
            System.out.println(annotation.annotationType());
        }
        Field[] fields =myClass.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println("hello");
            Field field = fields[i];
            field.isAnnotationPresent(Test.class);
            System.out.println(field.getAnnotation(Test.class).value());
            field.set(TestClass,"a");
            System.out.println(field.get(TestClass));
        }
    }
}
