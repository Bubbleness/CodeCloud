package com.dhu.niuke;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NC75 {

    public int[] FindNumsAppearOnce (int[] array) {
        // write code here
        Map<Integer,Integer> map = new HashMap<>();
        if(array.length == 0)
            return new int[]{};
        for(int i=0;i<array.length;i++){
            if(!map.containsKey(array[i])){
                map.put(array[i],1);
            }else{
                map.put(array[i],map.get(array[i])+1);
            }
        }

        int[] res = new int[2];
        int index = 0;
        Set<Map.Entry<Integer,Integer>> set = map.entrySet();
        for(Map.Entry<Integer,Integer> entry : set){
            if(entry.getValue() == 1){
                res[index++] = entry.getKey();
            }
        }
        return res;
    }
}
