package utils;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Date 2020/1/17
 * @Created by sundy
 */
public class BinarySearchTreeTest {
    private BinarySearchTree binarySearchTree = new BinarySearchTree();

    @Before
    public void init() {
        int[] arr = {10, 5, 20, 1, 8, 15, 25};
        for (int item : arr){
            binarySearchTree.insert(item);
        }
    }

    @Test
    public void insert() {

    }

    @Test
    public void preOrderR() {
        binarySearchTree.preOrderR(binarySearchTree.getTree());
        System.out.println();
        binarySearchTree.preOrder(binarySearchTree.getTree());
    }

    @Test
    public void inOrder(){
        binarySearchTree.inOrderR(binarySearchTree.getTree());
        System.out.println();
        binarySearchTree.inOrder(binarySearchTree.getTree());
    }

    @Test
    public void postOrder(){
        binarySearchTree.postOrderR(binarySearchTree.getTree());
        System.out.println();
        binarySearchTree.postOrder(binarySearchTree.getTree());
    }
}