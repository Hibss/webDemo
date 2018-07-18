package com.jfz.thymeleaf;

import java.io.*;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/6/20 17:02
 */


class UserInfo implements Serializable {
    private static final long serialVersionUID = 996890129747019948L;
    private String name;
//    private transient String psw;
    private String psw;

    public UserInfo(String name, String psw) {
        this.name = name;
        this.psw = psw;
    }

    public String toString() {
        return "name=" + name + ", psw=" + psw;
    }
}
public class TestTransient {
    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo("张三", "123456");
        System.out.println(userInfo);
        try {
            // 序列化，被设置为transient的属性没有被序列化
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("UserInfo.txt"));
            o.writeObject(userInfo);
            o.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        try {
            // 重新读取内容
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("UserInfo.txt"));
            UserInfo readUserInfo = (UserInfo) in.readObject();
            //读取后psw的内容为null
            System.out.println(readUserInfo.toString());
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
