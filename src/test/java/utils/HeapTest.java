package utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Date 2020/1/19
 * @Created by sundy
 */
public class HeapTest {
    Heap heap;
    int[] arr = {0, 1, 5, 8, 2, 45, 6, 7};

    @Before
    public void init() {
        heap = new Heap(7);
        for (int item : arr) {
            heap.insert(item);
        }
    }

    @Test
    public void insert() {
        for (int item : arr) {
            heap.insert(item);
        }
    }

    @Test
    public void sort() {
        heap.sort(arr, 7);
    }

    @After
    public void print() {
        printUtils.printArr(heap.getArr());
    }
}