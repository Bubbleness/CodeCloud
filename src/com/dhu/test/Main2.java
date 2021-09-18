package com.dhu.test;

import java.math.BigInteger;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        Deque<Integer> dq = new LinkedList<>();
        dq.offer(1);
        dq.offer(2);
        dq.offer(3);
        dq.offer(4);
        dq.offer(5);
        System.out.println(dq.toString());

        System.out.println("peekLast() = "+dq.peekLast());
        System.out.println("peekFirst() = "+dq.peekFirst());

    }


}
