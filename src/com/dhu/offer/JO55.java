package com.dhu.offer;


public class JO55 {

    public int maxDepth(TreeNode root) {

        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return leftHeight>rightHeight ? leftHeight+1:rightHeight+1;
    }

    public int TreeDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;

        int leftHeight = TreeDepth(root.left);
        int rightHeight = TreeDepth(root.right);
        return leftHeight>rightHeight ? leftHeight+1:rightHeight+1;
    }
}
