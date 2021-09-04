package com.dhu.niuke;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.out.println("牛客刷题笔记");

        Set<String> set = new HashSet<>();

        ArrayList<Integer> res1 = new ArrayList<>();
        res1.add(1);
        res1.add(2);
        res1.add(3);
        System.out.println(res1.toString());

        set.add(res1.toString());

        ArrayList<Integer> res2 = new ArrayList<>();
        res2.add(1);
        res2.add(2);
        res2.add(3);
        System.out.println(res2.toString());

        if(set.contains(res2.toString()))
            System.out.println("包含 " + res2.toString());
        else
            System.out.println("不包含");
    }
}
