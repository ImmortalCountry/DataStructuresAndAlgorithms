package sort;

public class BaseSort {
    public static void bubbleSort(int[] arr, int length) {
        if (length < 1) return;
        boolean flag = false;
        for (int i = 0; i < length; i++) {
            flag = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    public static void insertionSort(int[] arr, int length) {
        if (length < 1) return;

        for (int i = 1; i < length; i++) {
            int value = arr[i];
            int j = i - 1;
            // 查找要插入的位置并移动数据
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                } else break;
            }
            arr[j + 1] = value;
        }
    }

    public static void selectionSort(int[] arr, int length) {
        if (length < 1) return;

        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void quickSort(int[] arr, int length) {
        quickSortInternally(arr, 0, length - 1);
    }

    private static void quickSortInternally(int[] arr, int left, int right) {
        if (left > right)
            return;
        int p = partition(arr, left, right);
        quickSortInternally(arr, left, p - 1);
        quickSortInternally(arr, p + 1, right);
    }

    /**
     * 分区函数
     * @param arr
     * @param left
     * @param right
     */
    private static int partition(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        int pivot = arr[i];
        while (i < j) {
            while (arr[j] >= pivot && i < j) j--;
            while (arr[i] <= pivot && i < j) i++;
            if (i < j) {
                swap(arr, i, j);
            }
        }
        arr[left] = arr[i];
        arr[i] = pivot;
        return i;
    }

    public static void mergeSort(int[] arr, int length) {
        mergeSortInternally(arr, 0, length - 1);
    }

    private static void mergeSortInternally(int[] arr, int p, int r) {
        if (p >= r) return;
        // 取p到r之间的中间位置q, 防止（p+r）的和超过int类型最大值
        int q = p + (r - p) / 2;
        // 分治递归
        mergeSortInternally(arr, p, q);
        mergeSortInternally(arr, q + 1, r);
        merge(arr, p, q, r);
    }

    private static void merge(int[] arr, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0;
        int[] tmp = new int[r - p + 1]; // 申请一个大小跟a[p...r]一样的临时数组
        while (i <= q && j <= r) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }

        }
        // 判断哪个子数组有剩余数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        while (start <= end) {
            tmp[k++] = arr[start++];
        }
        // 将tmp中的数组拷贝回a[p...r]
        for (i = 0; i <= r - p; ++i) {
            arr[p + i] = tmp[i];
        }
    }

}
