package com.dhu.niuke;

import java.util.HashMap;
import java.util.Map;

public class NC28 {

    public String minWindow (String S, String T) {

        if(S.length() == 0 || T.length() == 0)
            return "";
        Map<Character,Integer> map = new HashMap<>();
        for (int k=0;k<T.length();k++){
            if(map.containsKey(T.charAt(k)))
                map.put(T.charAt(k),map.get(T.charAt(k))+1);
            else
                map.put(T.charAt(k),1);
        }
        int cnt = 0;
        int minLen = 0;
        int i = 0 , j = 0;
        while(i < S.length() && j < S.length()){

        }
        return "";
    }



}
