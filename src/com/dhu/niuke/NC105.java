package com.dhu.niuke;

public class NC105 {

    /** 
    * @Description: 含重复数字的二分 
    * @Param:  
    * @return:  
    * @Author: Yushui
    * @Date: 2021/8/13 15:35
    */
    public int search (int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int index = -1;
        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                // 如果相等 记录下标
                // 移动右指针接着在左区间查找
                index = mid;
                right = mid - 1;
            }else if(target > nums[mid]){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return index;
    }
}
