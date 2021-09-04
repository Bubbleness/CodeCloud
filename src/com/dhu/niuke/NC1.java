package com.dhu.niuke;

import java.util.Scanner;

public class NC1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();

        NC1 nc1 = new NC1();
        String res = nc1.solve(s,t);
        System.out.println(res);
    }

    public String solve (String s, String t) {
        // write code here

        String rs = new StringBuilder(s).reverse().toString();
        //System.out.println("rs  "+rs);
        String rt = new StringBuilder(t).reverse().toString();
        //System.out.println("rt  "+rt);
        StringBuilder res = new StringBuilder();
        int index = 0;
        int e = 0;
        while(index < rs.length() && index < rt.length()){

            int a = rs.charAt(index)-'0';
            int b = rt.charAt(index) - '0';
            int temp = a+b+e;
            res.append((char) ((temp%10)+'0'));
            e = temp / 10;
            index++;
        }

        while(index < rs.length()){
            int temprs = (rs.charAt(index)-'0') + e;
            res.append((char)((temprs%10)+'0'));
            e = temprs / 10;
            index++;
        }

        while(index < rt.length()){
            int temprt = (rt.charAt(index)-'0') + e;
            res.append((char)((temprt%10)+'0'));
            e = temprt / 10;
            index++;
        }

        if(e != 0){
            res.append((char)(e+'0'));
        }

        return res.reverse().toString();
    }
}
