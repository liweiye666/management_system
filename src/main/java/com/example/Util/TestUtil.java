package com.example.Util;

/**
 * @Project: management_system
 * @Package: com.example.Util
 * @Author: 周博义
 * @Date: Created in 2020/6/1 16:27
 */
public class TestUtil {

    public static void main(String[] args) {
        String str = "a1b556asdds8";
        String s = "";

        char c = str.charAt(4);
        System.out.println("c="+c);

        char c1 = str.charAt(5);

        if (c>'0'&&c<'9') {
            System.out.println("true1111");
        }
        else {
            System.out.println("false1111111111");
        }

        char c2 = str.charAt(0);
        if (c2>'0'&&c2<'9') {
            System.out.println("true22222222");
        }
        else {
            System.out.println("false22222222");
        }

        s = s + c ;
        System.out.println("s="+s);
        s=s+c1;
        System.out.println("s="+ s);

        int a = Integer.parseInt(s);
        System.out.println("a="+a);


        String s1 = "";
        if (s1!="") {
            System.out.println("yes");
        }
        else
            System.out.println("no");
    }
}
