package com.dhu.niuke;

import java.util.*;

public class NC41 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }

        int maxLen = maxLength(arr);
        System.out.println(maxLen);
    }

    /**
     * @Description: 最长无重复子数组
     * @Param:
     * @return:
     * @Author: Yushui
     * @Date: 2021/8/13 9:26
     */
    public static int maxLength(int[] arr) {
        // write code here
        if (arr.length == 0)
            return 0;
        if (arr.length == 1)
            return 1;
        int left = 0;
        int right;
        int maxLen = 0;
        Set<Integer> set = new HashSet<>();
        while (left < arr.length) {
            if (arr.length - left < maxLen)
                break;
            set.add(arr[left]);
            for (int i = left + 1; i < arr.length; ++i) {
                if (set.contains(arr[i])) {
                    maxLen = Math.max(maxLen, (i - left));
                    left++;
                    set.clear();
                    break;
                } else {
                    set.add(arr[i]);
                }
            }
            if (!set.isEmpty()) {
                maxLen = Math.max(maxLen, set.size());
                break;
            }
        }

        return maxLen;
    }

    /**
    * @Description: 解法2 ： 利用队列，遇到重复的就出队队头，直到不重复为止
    * @Param:
    * @return:
    * @Author: Yushui
    * @Date: 2021/8/13 9:59
    */
    public static int maxLength_method2(int[] arr) {
        // write code here
        if (arr.length == 0)
            return 0;
        if (arr.length == 1)
            return 1;
        int maxLen = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int num : arr){

            while (queue.contains(num)){
                queue.poll();
            }
            queue.add(num);
            // 队列里面保存的都是不重复的数字
            maxLen = Math.max(maxLen,queue.size());
        }
        return maxLen;
    }


    /**
     * 滑动窗口算法
     * @param arr
     * @return
     */
    public static int maxLength_method3(int[] arr){

        if(arr.length < 2)
            return arr.length;

        int left = -1;
        int right = 0;
        int maxLen = 0;
        // 存储right指向的数字以及数组下标
        HashMap<Integer,Integer> window = new HashMap<>();
        while(right < arr.length){
            if(window.containsKey(arr[right])){
                // 缩小窗口
                left = Math.max(left,window.get(arr[right]));
            }
            maxLen = Math.max(maxLen,right-left);
            window.put(arr[right],right);
            right++;
        }
        return maxLen;
    }
}
