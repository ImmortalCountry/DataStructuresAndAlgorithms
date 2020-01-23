package utils;

/**
 * @Date 2020/1/19
 * @Created by sundy
 */
public class Heap {
    // 堆数组，下标从 1 开始
    private int[] arr;
    // 最大堆数
    private int n;

    public int[] getArr() {
        return arr;
    }

    // 堆中已经存储的数据个数
    private int count;

    public Heap(int capacity) {
        arr = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    /**
     * 大顶堆 自下往上堆化
     *
     * @param data
     */
    public void insert(int data) {
        if (count >= n) return;
        ++count;
        arr[count] = data;
        int i = count;
        while (i / 2 > 0 && arr[i] > arr[i / 2]) {
            // 自下往上堆化
            swap(arr, i, i / 2);
            i = i / 2;
        }
    }

    public void removeMax() {
        if (count == 0) return;
        arr[1] = arr[count];
        --count;
        heapify(arr, count, 1);
    }

    private void buildHeap(int[] arr, int n) {
        for (int i = n / 2; i >= 1; --i) {
            heapify(arr, n, i);
        }
    }

    private void heapify(int[] arr, int n, int i) {
        while (true) {
            int maxPos = i;
            // 尽量把大的放上边
            if (i * 2 <= n && arr[i] < arr[i * 2]) maxPos = i * 2;
            if (i * 2 + 1 <= n && arr[maxPos] < arr[i * 2 + 1]) maxPos = i * 2 + 1;
            if (maxPos == i) break;
            swap(arr, i, maxPos);
            i = maxPos;
        }
    }

    public void sort() {
        buildHeap(arr, n);
        int k = n;
        while (k > 1) {
            swap(arr, 1, k);
            --k;
            heapify(arr, k, 1);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
