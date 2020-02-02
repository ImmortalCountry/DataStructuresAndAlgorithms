package question;

/**
 * 基础0-1背包问题
 * 背包总的承载重量w；
 * 有n个物品，物品重量不等，不可分割。
 * 现期望选择几个物品，在不超w下装最大重量。
 */
public class BaseBug {
    private static int maxW = Integer.MIN_VALUE;// 存储背包中物品总重量的最大值
    // cw：表示已经装进的物品总重量，i 表示考察到哪个物品了
    // w 背包重量；items 表示每个物品的重量；n 表示物品个数
    // 假设背包w：100，物品n：10，物品重量存储在a中
    // f(0, 0, a, 10, 100)

    public static void f(int i, int cw, int[] items, int n, int w) {
        if (cw == w || i == n) {
            if (cw > maxW) maxW = cw;
            return;
        }
        f(i + 1, cw, items, n, w);
        if (cw + items[i] <= w) {
            f(i + 1, cw + items[i], items, n, w);
        }
    }
}
