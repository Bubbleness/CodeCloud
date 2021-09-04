package com.dhu.niuke;

import java.util.*;

public class NC102 {

    /**
    * @Description: 求二叉树两个节点的公共祖先
    * @Param:
    * @return:
    * @Author: Yushui
    * @Date: 2021/8/13 14:18
    */

    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        TreeNode res = DFS(root,o1,o2);
        return res.val;
    }

    public TreeNode DFS(TreeNode root, int o1, int o2){

        if(root == null)
            return root;
        // o1 或者 o2 有一个为root 则root就是公共祖先
        if(root.val == o1 || root.val == o2)
            return root;
        TreeNode left = DFS(root.left,o1,o2);
        TreeNode right = DFS(root.right,o1,o2);
        // 左子树没有找到公共祖先 则在右子树中
        if(left == null)
            return right;
        if(right == null)
            return left;
        return root;
    }

    /**
    * @Description: 非递归写法，通过层次遍历，利用map记录每个节点的父节点，对比两个节点的父节点路径 第一个相同的就是最近公共祖先
    * @Param:
    * @return:
    * @Author: Yushui
    * @Date: 2021/8/13 14:20
    */
    public int lowestCommonAncestor_method2(TreeNode root, int o1, int o2) {
        //记录遍历到的每个节点的父节点。
        Map<Integer, Integer> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        parent.put(root.val, Integer.MIN_VALUE);//根节点没有父节点，给他默认一个值
        queue.add(root);
        //直到两个节点都找到为止。
        while (!parent.containsKey(o1) || !parent.containsKey(o2)) {
            //队列是一边进一边出，这里poll方法是出队，
            TreeNode node = queue.poll();
            if (node.left != null) {
                //左子节点不为空，记录下他的父节点
                parent.put(node.left.val, node.val);
                //左子节点不为空，把它加入到队列中
                queue.add(node.left);
            }
            //右节点同上
            if (node.right != null) {
                parent.put(node.right.val, node.val);
                queue.add(node.right);
            }
        }
        Set<Integer> ancestors = new HashSet<>();
        //记录下o1和他的祖先节点，从o1节点开始一直到根节点。
        while (parent.containsKey(o1)) {
            ancestors.add(o1);
            o1 = parent.get(o1);
        }
        //查看o1和他的祖先节点是否包含o2节点，如果不包含再看是否包含o2的父节点……
        while (!ancestors.contains(o2))
            o2 = parent.get(o2);
        return o2;
    }
}
