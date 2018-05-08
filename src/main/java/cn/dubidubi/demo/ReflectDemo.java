package cn.dubidubi.demo;

import cn.dubidubi.model.User;

import javax.activation.MailcapCommandMap;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Ref;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: 16224
 * @Date: 2018/5/7 0007 21:18
 * @Description:
 */
public class ReflectDemo {
    public String username;
    public int password;
    public Map<Integer,String> myMap;
    public User user;
    public ReflectDemo() {

    }

    public void sb(){

    }

    public void sb2(int a){
        System.out.println("lzj");
    }
    /**@description:  反射获取对象内容
     * @param:
     * @return:
     * @auther: 16224
     * @date: 2018/5/7 0007 21:21
     */
    public static void main(String[] args) throws IllegalAccessException {
        // 反射获取成员变量
//        ReflectDemo reflectDemo =new ReflectDemo();
//        reflectDemo.username ="lzj";
//        reflectDemo.password =123456;
//        Map<Integer,String> map =new HashMap<>();
//        map.put(1,"lzj");
//        map.put(2,"lzj2");
//        User user =new User();
//        user.setUsername("lzj222");
//        reflectDemo.user =user;
//        reflectDemo.myMap =map;
//        Field[] fields = reflectDemo.getClass().getFields();
//        for (Field field : fields) {
//            System.out.println("field = " + field.getName()+"value" +field.get(reflectDemo));
//            System.out.println(field.getType().getName());
//        }
        ReflectDemo ReflectDemo =new ReflectDemo();
        Class Class = ReflectDemo.getClass();
        Method[] methods = Class.getMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println("method"+methods[i].getName());
        }
    }
}
