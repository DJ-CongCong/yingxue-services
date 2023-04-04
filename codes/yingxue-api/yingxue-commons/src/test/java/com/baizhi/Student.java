package com.baizhi;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

interface UserDao {
    public default void test() {

    }
}

class People {
    static {
        System.out.println("======> 5");//1
    }

    {
        System.out.println("======> 6");//3
    }

    public People() {
        System.out.println("======> 7");//4
    }
}

public class Student extends People {
    private String name;

    static {
        System.out.println("======> 1");//2
    }

    public Student() {
        System.out.println("======> 3");//6
    }

    {
        System.out.println("======> 2");//5
    }

    public void play() {
        System.out.println("======> 4");//7
    }
}

class TestStudent {
    public static void main(String[] args) {
//        Student student = new Student(); //类加载 //  1.分配空间  2.初始化类中属性  3.调用构造方法创建对象
//        student.play();//控制台输出    // 1 2 3 4
        //byte -128---127 常量池

        Collection Collection;
        List List;

        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put(null, null);


        Hashtable<Object, Object> objectObjectHashtable = new Hashtable<>();
        objectObjectHashtable.put(null, null);

        ConcurrentHashMap ConcurrentHashMap = new ConcurrentHashMap();

        ConcurrentHashMap.put("", "");

    }
}
