package search;

/**
 * 二分查找
 *
 * @Date 2020/1/15
 * @Created by sundy
 */
public class BinarySearch {

    /****************有序数组中不存在重复元素**********************/

    /**
     * 非递归实现
     *
     * @param arr   有序数组
     * @param n     数组长度
     * @param value 查找值
     * @return
     */
    public static int bSearch(int[] arr, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                high = high - 1;
            }
        }
        return -1;
    }

    /**
     * 递归实现
     *
     * @param arr
     * @param n
     * @param value
     * @return
     */
    public static int bSearchRecursive(int[] arr, int n, int value) {
        return bSearchInternally(arr, 0, n - 1, value);
    }

    private static int bSearchInternally(int[] arr, int low, int high, int value) {
        if (low > high) return -1;
        int mid = low + ((high - low) >> 1);
        if (arr[mid] == value) {
            return mid;
        } else if (arr[mid] < value) {
            return bSearchInternally(arr, mid + 1, high, value);
        } else {
            return bSearchInternally(arr, low, mid - 1, value);
        }
    }

    /****************有序数组中存在重复元素**********************/

    /**
     * 查找第一个值等于给定值
     *
     * @param arr
     * @param n
     * @param value
     */
    public static int bSearchFirst(int[] arr, int n, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > value) {
                high = mid - 1;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == 0 || arr[mid - 1] != value)
                    return mid;
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个等于给定值的元素
     *
     * @param arr
     * @param n
     * @param value
     * @return
     */
    public static int bSearchLast(int[] arr, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > value) {
                high = mid - 1;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == n - 1 || arr[mid + 1] != value)
                    return mid;
                low = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 查找第一个大于等于给定值的元素
     *
     * @param arr
     * @param n
     * @param value
     * @return
     */
    public static int bSearchFirstGE(int[] arr, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] >= value) {
                if (mid == 0 || arr[mid - 1] < value) return mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     *
     * @param arr
     * @param n
     * @param value
     * @return
     */
    public static int bSearchLastLE(int[] arr, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > value) {
                high = mid - 1;
            } else {
                if ((mid == n - 1) || (arr[mid + 1] > value))
                    return mid;
                else
                    low = mid + 1;
            }
        }
        return -1;
    }
}
