package cn.dubidubi.model;

import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * @Auther: 16224
 * @Date: 2018/5/23 0023 15:51
 * @Description:
 */
public class Ip implements Serializable {
    private String ip;
    private String name;
    private String sex;
    private String age;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public static void main(String[] args) throws IllegalAccessException {
        Ip Ip = new Ip();
        Ip.setIp("123");
        Ip.setName("lzzz");
        Ip.setAge("sss");
        Ip.setSex("man");
        Class<? extends cn.dubidubi.model.Ip> aClass = Ip.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field declaredField = declaredFields[i];
            System.out.println(declaredField.getName());
            System.out.println(declaredField.get(Ip));
        }
    }
}
