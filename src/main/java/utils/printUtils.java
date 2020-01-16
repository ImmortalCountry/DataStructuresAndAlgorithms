package utils;

/**
 * @Date 2020/1/15
 * @Created by sundy
 */
public class printUtils<T> {
    public static void printArr(int[] arr) {
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
