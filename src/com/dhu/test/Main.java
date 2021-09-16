package com.dhu.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Point> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            Point p = new Point(x,y);
            list.add(p);
        }

        Collections.sort(list, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.x != o2.x)
                    return o1.x - o2.x;
                else
                    return o1.y - o2.y;
            }
        });


        int ans = getCnt(list,k);
        System.out.println(ans);


    }

    // 计算切比雪夫距离
    public static int getInstance(Point a , Point b){

        int absA = Math.abs(a.x - b.x);
        int absB = Math.abs(a.y - b.y);
        return Math.max(absA,absB);
    }

    public static int getCnt(ArrayList<Point> list , int k){
        if(list.size() == 0)
            return 0;

        int cnt = 0;
        for(int i=0;i<list.size();i++){
            Point temp = list.get(i);
            int temp_x = temp.x;
            int temp_y = temp.y;
            for(int j=i+1;j<list.size();j++){
                Point temp2 = list.get(j);
                if(temp2.x > temp_x+k && temp2.y > temp_y+k)
                    break;

                if(getInstance(temp,temp2) == k){
                    cnt++;
                }
            }
        }

        return cnt;
    }


}

class Point{
    int x;
    int y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}