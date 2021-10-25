package com.dhu.niuke;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NC28 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        String T = sc.next();
        NC28 nc = new NC28();
        String ans = nc.minWindow(S,T);
        System.out.println(ans);
    }

    public String minWindow (String S, String T) {

        Map<Character,Integer> target , windows;
        target = new HashMap<>();
        windows = new HashMap<>();
        for(int i=0;i<T.length();i++){
            if(target.containsKey(T.charAt(i)))
                target.put(T.charAt(i),target.get(T.charAt(i))+1);
            else
                target.put(T.charAt(i),1);
        }

        for(int i=0;i<S.length();i++){
            windows.put(S.charAt(i),0);
        }

        int left = 0 , right = 0;
        int start = 0 , minLen = Integer.MAX_VALUE;
        int count = 0;
        while(right < S.length()){
            char c = S.charAt(right);
            ++right;
            if(target.containsKey(c)){
                windows.put(c,windows.get(c)+1);
                // 字符c已经完成匹配
                if(windows.get(c) == target.get(c))
                    ++count;
            }
            // 所有字符都已经匹配上 开始缩小窗口
            while(count == target.size()){
                if(right - left < minLen){
                    start = left;
                    minLen = right - left;
                }
                c = S.charAt(left);
                ++left;
                // 左边开始的字符如果匹配  缩小窗口后该字符就不匹配了
                // count--
                // 窗口中该字符数也减一
                if(target.containsKey(c)){
                    if(windows.get(c) == target.get(c))
                        --count;
                    windows.put(c,windows.get(c)-1);
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : S.substring(start,start+minLen);
    }



}
