package com.dhu.leetcode;

import java.util.Stack;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }

    // 建树代码
    public TreeNode createTree(int[] nums, int i) {

        if (nums.length == 0)
            return null;
        if (i >= nums.length)
            return null;
        TreeNode root = new TreeNode(nums[i]);
        root.left = createTree(nums, 2 * i + 1);
        root.right = createTree(nums, 2 * i + 2);
        return root;
    }


    //先序递归遍历
    public void preOrderRecursion(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        preOrderRecursion(root.left);
        preOrderRecursion(root.right);
    }

    // 中序递归遍历
    public void inOrderRecursion(TreeNode root) {
        if (root == null)
            return;
        inOrderRecursion(root.left);
        System.out.print(root.val + " ");
        inOrderRecursion(root.right);
    }

    // 后序递归遍历
    public void postOrderRecursion(TreeNode root) {
        if (root == null)
            return;
        postOrderRecursion(root.left);
        postOrderRecursion(root.right);
        System.out.print(root.val + " ");
    }

    // 先序遍历 非递归
    public void preOrderNonRecursion(TreeNode root) {

        // 1. 树空直接返回
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        // 2. 根节点入栈
        stack.push(root);
        // 3. 栈不空时循环
        while (!stack.isEmpty()) {
            // 4. 出栈栈顶节点并访问
            TreeNode node = stack.pop();
            System.out.println(node.val + " ");
            // 5. 按先右后左进行入栈
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
    }

    // 中序遍历 非递归
    public void inOrderNonRecursion(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        // 1. p指向根节点（不能直接用root）
        TreeNode p = root;
        // 2. 栈不空 或者 p不空 时循环
        while (!stack.isEmpty() || p != null) {
            // 3. p不空就入栈 p沿着左子树往下走
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            // 4. 走到左子树为空 取栈顶元素访问 沿右子树走
            if (!stack.empty()) {
                p = stack.pop();
                System.out.println(p.val + " ");
                p = p.right;
            }
        }
    }

    // 后序遍历 非递归
    public void postOrderNonRecursion(TreeNode root) {
        if (root == null)
            return;
        else {
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            // 1. 根节点入栈1
            stack1.push(root);
            // 2. 栈1不空时循环
            while (!stack1.isEmpty()) {
                // 3. 出栈 栈1 的栈顶节点并入栈2
                TreeNode node = stack1.pop();
                stack2.push(node);
                // 4. 若有左孩子 入栈左孩子到栈1
                if (node.left != null)
                    stack1.push(node.left);
                // 5. 若有右孩子 入栈右孩子到栈1
                if (node.right != null)
                    stack1.push(node.right);
            }
            // 6. 栈2不空时循环 出栈栈顶并访问
            while (!stack2.isEmpty()) {
                TreeNode temp = stack2.pop();
                System.out.println(temp.val + " ");
            }
        }


    }
}
