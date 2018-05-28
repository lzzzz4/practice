package cn.dubidubi.model;

import org.apache.commons.io.IOUtils;


import java.io.*;

/**
 * @Auther: 16224
 * @Date: 2018/5/15 0015 17:42
 * @Description:
 */
public class MyMessage implements Serializable {

    private String username;
    private String name;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //序列化
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ByteArrayOutputStream ByteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream ObjectOutputStream = new ObjectOutputStream(ByteArrayOutputStream);
        MyMessage input = new MyMessage();
        input.setName("lzj");
        ObjectOutputStream.writeObject(input);
        byte[] bytes = ByteArrayOutputStream.toByteArray();
        System.out.println(new String(bytes,"utf-8"));
        ByteArrayInputStream ByteArrayInputStream = new ByteArrayInputStream(bytes);
        ObjectInputStream ObjectInputStream = new ObjectInputStream(ByteArrayInputStream);
        MyMessage MyMessage = (cn.dubidubi.model.MyMessage) ObjectInputStream.readObject();
        System.out.println(MyMessage.getName());
        IOUtils.closeQuietly(ObjectOutputStream);
        IOUtils.closeQuietly(ByteArrayOutputStream);
    }
}
