package utils;

import java.util.HashMap;
import java.util.Map;
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

    public Node find(int data) {
        Node p = tree;
        while (p != null) {
            if (p.data > data) {
                p = p.left;
            } else if (p.data < data) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    public void delete(int data) {
        // p 指向要删除的节点， 初始化指向根节点。
        Node p = tree;
        // pp 记录的是 p 的父节点
        Node pp = null;
        while (p != null && p.data != data) {
            pp = p;
            if (p.data < data) {
                p = p.right;
            } else if (p.data > data) {
                p = p.left;
            } else break;
        }
        if (p == null) {
            // 没有找到
            return;
        }

        // 要删除的节点有两个字节点
        if (p.left != null && p.right != null) {
            // 查找右子树中的最小节点
            Node minP = p.right;
            // minPP表示minP的父节点
            Node minPP = minP;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data;
            p = minP; // 下面就变成了删除minP了
            pp = minPP;

        }
        // 删除的节点是叶子节点或者仅有一个节点
        Node child; // p 的子节点

        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else child = null;
        if (pp == null) {
            tree = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }

    public Node findMin(){
        if (tree == null){
            return null;
        }
        Node p = tree;
        while (p.left != null){
            p = p.left;
        }
        return p;
    }
    public Node findMax(){
        if (tree == null){
            return null;
        }
        Node p = tree;
        while (p.right != null){
            p = p.right;
        }
        return p;
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
     * 非递归实现前序遍历
     *
     * @param tree
     */
    public void preOrder(Node tree) {
        Stack<Node> stack = new Stack<>();
        stack.push(tree);
        while (!stack.empty()) {
            Node cur = stack.pop();
            System.out.print(cur.data + " ");
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * 非递归实现中序遍历
     *
     * @param tree
     */
    public void inOrder(Node tree) {
        Stack<Node> stack = new Stack<>();
        Node cur = tree;
        while (!stack.empty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                System.out.print(cur.data + " ");
                cur = cur.right;
            }
        }
    }

    /**
     * 非递归实现后序遍历
     *
     * @param Tree
     */
    public void postOrder(Node Tree) {
        Stack<Node> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        Node cur = tree;
        while (!stack.empty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                map.put(cur.data, 1);
                cur = cur.left;
            } else {
                cur = stack.peek();
                if (map.get(cur.data) == 2) {
                    stack.pop();
                    System.out.print(cur.data + " ");
                    cur = null;
                } else {
                    map.put(cur.data, 2);
                    cur = cur.right;
                }
            }
        }
    }

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public int getData() {
            return data;
        }

        public Node(int data) {
            this.data = data;
        }
    }
}
