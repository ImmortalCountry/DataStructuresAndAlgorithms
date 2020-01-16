package sort;

import org.junit.After;
import org.junit.Before;
import utils.printUtils;

/**
 * @Date 2020/1/16
 * @Created by sundy
 */
public class BaseSortTest {
    private int[] arr;
    int length;

    @org.junit.Test
    public void bubbleSort() {
        BaseSort.bubbleSort(arr, length);
    }

    @org.junit.Test
    public void insertionSort() {
        BaseSort.insertionSort(arr, length);
    }

    @org.junit.Test
    public void selectionSort() {
        BaseSort.selectionSort(arr, length);
    }

    @org.junit.Test
    public void quickSort() {
        BaseSort.quickSort(arr, length);
    }

    @org.junit.Test
    public void mergeSort() {
        BaseSort.mergeSort(arr, length);
    }

    @Before
    public void init() {
        arr = new int[]{1, 2, 2, 3, 1, 6, -2, -1, 0, 99, 100};
        length = arr.length;
    }

    @After
    public void print() {
        printUtils.printArr(arr);
    }

}