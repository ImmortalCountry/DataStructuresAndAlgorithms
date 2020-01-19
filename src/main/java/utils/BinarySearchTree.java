package utils;

import java.util.Stack;

/**
 * 二叉树
 * 节点的高度：节点到叶子节点的最长路径（边数）
 * 节点深度：根节点到这个节点所经历的边的个数
 * 节点的层数：节点深度加一
 * 树的高度：根节点的高度
 *
 * @Date 2020/1/16
 * @Created by sundy
 */
public class BinarySearchTree {
    private Node tree;

    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }
        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else {
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    public Node getTree() {
        return tree;
    }

    /**
     * 前序遍历：对于树中的任意节点来说，先打印这个节点，然后再打印它的左子树，最后打印它的右子树。
     * 递归
     *
     * @param tree
     */
    public void preOrderR(Node tree) {
        if (tree == null) return;
        System.out.print(tree.data + " ");
        preOrderR(tree.left);
        preOrderR(tree.right);
    }

    /**
     * 中序遍历: 对于树中的任意节点来说，先打印它的左子树，然后再打印它本身，最后打印它的右子树。
     * 递归
     *
     * @param tree
     */
    public void inOrderR(Node tree) {
        if (tree == null) return;
        inOrderR(tree.left);
        System.out.print(tree.data + " ");
        inOrderR(tree.right);
    }

    /**
     * 后序遍历：对于树中的任意节点来说，先打印它的左子树，然后再打印它的右子树，最后打印这个节点本身。
     * 递归
     *
     * @param tree
     */
    public void postOrderR(Node tree) {
        if (tree == null) return;
        postOrderR(tree.left);
        postOrderR(tree.right);
        System.out.print(tree.data + " ");
    }


    /**
     * 非递归实现
     * @param tree
     */
    public void preOrder(Node tree){
        Stack<Node> stack = new Stack<>();
        stack.push(tree);
        while(!stack.empty()){
            Node cur = stack.pop();
            System.out.print(cur.data + " ");
            if (cur.right != null){
                stack.push(cur.right);
            }
            if (cur.left != null){
                stack.push(cur.left);
            }
        }
    }

    public void inOrder(Node tree){
        Stack<Node> stack = new Stack<>();
        stack.push(tree);
        while(!stack.empty()){

        }
    }

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
