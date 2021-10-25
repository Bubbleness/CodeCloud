package com.dhu.ds;

// 平衡二叉树的实现

public class AVLTreeDemo {

    public static void main(String[] args) {
        int[] arr = {10,11,7,6,8,9};
        //创建一个 AVLTree对象
        AVLTree avlTree = new AVLTree();
        //添加结点
        for (int i = 0; i < arr.length; i++){
            avlTree.add(new AVLNode(arr[i]));
        }
        //中序遍历
        avlTree.infixOrder();

        System.out.println("在平衡处理~~");
        System.out.println("树的高度=" + avlTree.getRoot().height());
        System.out.println("树的左子树高度=" + avlTree.getRoot().leftHeight());
        System.out.println("树的右子树高度=" + avlTree.getRoot().rightHeight());
    }
}

/*创建AVLTree*/
class AVLTree {
    private AVLNode root;

    public AVLNode getRoot() {
        return root;
    }

    /*1.添加结点*/
    public void add(AVLNode node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    /*2.中序遍历*/
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("空树");
        }
    }

    /*3.查找结点*/
    public AVLNode search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    /*4.查找要删除结点的父结点*/
    public AVLNode searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    /*5.删除结点*/
    public void delete(int value) {
        if (root == null) {
            return;
        } else {
            //1.查找要删除的结点
            AVLNode targetNode = search(value);
            if (targetNode == null) {
                return;
            }
            //树只有一个根结点，同时这个根结点就是要删除的结点
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            //2.找到要删除结点的父结点
            AVLNode parent = searchParent(value);
            //3.根据不同情况，删除结点
            //（1）删除的是叶子结点
            if (targetNode.left == null && targetNode.right == null) {//无左右子树
                //判断targetNode是父结点的左孩子还是右孩子
                if (parent.left != null && parent.left.value == value) {
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value) {
                    parent.right = null;
                }
            }
            //（2）删除的结点同时拥有左右子树
            else if (targetNode.left != null && targetNode.right != null) {
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;
            }
            //（3）删除的结点只有左或右子树
            else if (targetNode.left != null || targetNode.right != null) {//有一棵子树
                if (parent != null) {
                    if (targetNode.left != null) {//待删除结点有左孩子
                        if (parent.left.value == value) {//如果targetNode是parent的左孩子
                            parent.left = targetNode.left;
                        } else {
                            parent.right = targetNode.left;//如果targetNode是parent的右孩子
                        }
                    } else {//待删除结点有右孩子
                        if (parent.left.value == value) {//如果targetNode是parent的左孩子
                            parent.left = targetNode.right;
                        } else {//如果targetNode是parent的右孩子
                            parent.right = targetNode.right;
                        }
                    }
                } else {
                    if (targetNode.left != null) {
                        root = targetNode.left;
                    } else {
                        root = targetNode.right;
                    }
                }
            }

        }
    }

    /*6.删除有左右子树的结点的方法*/
    public int delRightTreeMin(AVLNode avlNode) {
        AVLNode target = avlNode;
        //循环的查找左结点，就会找到最小值
        while (target.left != null) {
            target = target.left;
        }
        delete(target.value);
        return target.value;
    }

}

/*结点类*/
class AVLNode {
    int value;
    AVLNode left;
    AVLNode right;

    public AVLNode(int value) {
        this.value = value;
    }

    /*1.添加结点*/
    public void add(AVLNode node) {//递归添加
        if (node == null) {
            return;
        }
        //判断传入结点的值和当前结点的值的大小
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {//(node.value > this.value)
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }

        if(bF() < -1){//右子树高
            if(right.bF() > 0){
                right.rightRotate();
            }
            leftRotate();
        }else if (bF() > 1){//左子树高
            if (left.bF() < 0) {
                //先对根结点的左子树进行左旋转
                left.leftRotate();
            }
            //再对当前根结点进行右旋转
            rightRotate();
        }
    }

    /*2.中序遍历*/
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }

        System.out.println(this);

        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /*3.查找结点*/

    /**
     * @param value 希望找到的结点的值
     * @return 返回改结点，否则返回null
     */
    public AVLNode search(int value) {
        if (value == this.value) {//找到要查找的结点
            return this;
        }
        if (value < this.value) {//查找值 < 当前结点，向左子树递归查找
            //如果左子结点为空
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    /*4.查找要删除结点的父结点*/

    /**
     * @param value 要查找的值
     * @return 要查找的结点的父结点
     */
    public AVLNode searchParent(int value) {
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)) {//看看当前结点的左右子结点有没有要查找的结点
            return this;
        } else {
            //如果查找的值小于当前结点的值，并且当前结点的左子结点不为空
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null;//没有找到父结点
            }
        }
    }

    /*5.返回当前结点为根结点 的树的高度*/
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    /*6.返回左子树的高度*/
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    /*7.返回右子树的高度*/
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    /*8.平衡因子*/
    public int bF() {
        return leftHeight() - rightHeight();
    }

    /*9.左旋转,逆时针旋转*/
    private void leftRotate(){
        //1.创建新的结点，以当前根结点的值 作为 新结点的值
        AVLNode newNode = new AVLNode(value);
        //2.把新的结点的左子树 设为 当前根结点的左子树
        newNode.left = left;
        //3.把新的结点的右子树 设置成 当前根结点的右子树的左子树
        newNode.right = right.left;
        //4.把当前根结点的值 替换为 右子结点的值
        value = right.value;
        //5.把当前根结点的右子树 设置成 右结点的右子树
        right = right.right;
        //6.把当前根结点的左子树 设置为 新的结点
        left = newNode;
    }

    /*10.右旋转*/
    private void rightRotate(){
        //1.创建新的结点，以当前根结点的值 作为 新结点的值
        AVLNode newNode = new AVLNode(value);
        //2.把新的结点的右子树 设为 当前根结点的右子树
        newNode.right = right;
        //3.把新的结点的左子树 设置成 当前根结点的左子树的右子树
        newNode.left = left.right;
        //4.把当前根结点的值 替换为 左子结点的值
        value = left.value;
        //5.把当前根结点的左子树 设置成 左结点的左子树
        left = left.left;
        //6.把当前根结点的右子树 设置为 新的结点
        right = newNode;
    }

    @Override
    public String toString() {
        return "AVLNode{" +
                "value=" + value +
                '}';
    }
}

