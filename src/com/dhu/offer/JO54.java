package com.dhu.offer;

public class JO54 {

    public static int ans = 0;
    public static int k;

    public int kthLargest(TreeNode root, int k) {

        this.k = k;
        if(root == null || k == 0)
            return 0;
        inOrder(root);
        return ans;

    }

    public static void inOrder(TreeNode root){

        if(root == null || k == 0)
            return;
        inOrder(root.right);
        k--;
        if(k == 0)
            ans = root.val;
        inOrder(root.left);
    }
}
