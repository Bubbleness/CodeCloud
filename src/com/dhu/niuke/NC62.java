package com.dhu.niuke;

public class NC62 {

    boolean isBananceTree = true;

    public boolean IsBalanced_Solution(TreeNode root) {

        TreeDepth(root);
        return isBananceTree;

    }

    public int TreeDepth(TreeNode root) {
        if(root == null)
            return 0;

        int leftHeight = TreeDepth(root.left);
        if(leftHeight == -1)
            return -1;
        int rightHeight = TreeDepth(root.right);
        if(rightHeight == -1)
            return -1;
        if(Math.abs(leftHeight - rightHeight) > 1){
            isBananceTree = false;
            return -1;
        }
        return leftHeight>rightHeight ? leftHeight+1:rightHeight+1;
    }
}
