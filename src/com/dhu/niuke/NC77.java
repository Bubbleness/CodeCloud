package com.dhu.niuke;

import java.util.ArrayList;

public class NC77 {


    public int[] reOrderArray (int[] array) {

        if(array.length == 0)
            return new int[]{};

        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        for(int i=0;i<array.length;i++){
            if(array[i] % 2 == 0)
                even.add(array[i]);
            else
                odd.add(array[i]);
        }

        odd.addAll(even);
        return odd.stream().mapToInt(Integer::valueOf).toArray();
    }
}
