package utils;

public class Strings {
    private static final int SIZE = 256;
    private static boolean found = false;

    public static int bf(char[] tagArray, char[] pthArray) {
        int tagL = tagArray.length;
        int pthL = pthArray.length;
        if (tagArray.length < pthArray.length) {
            return -1;
        }
        for (int i = 0; i < tagL - pthL + 1; i++) {
            found = true;
            for (int j = 0; j < pthL; j++) {
                if (tagArray[i + j] != pthArray[j]) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }
        return -1;
    }

    public static int bm(char[] tagArray, char[] pthArray) {
        int tagL = tagArray.length;
        int pthL = pthArray.length;
        int[] bc = new int[SIZE]; // 记录模式串中每个字符最后出现的位置
        generateBC(pthArray, pthL, bc);
        int[] suffix = new int[pthL];
        boolean[] prefix = new boolean[pthL];
        int i = 0;// i表示主串与模式串对其的第一个字符
        while (i < tagL - pthL) {
            int j;
            for (j = pthL - 1; j >= 0; j--) {
                if (tagArray[i + j] != pthArray[j]) {
                    break; // 坏字符对应的下表是j
                }
            }
            if (j < 0) {
                return i;
            }

            int ascii = (int) tagArray[i + j];
            int x = j - bc[ascii];
            int y = 0;
            if (j < pthL - 1) {// 如果有好后缀的话
                y = moveByGS(j, pthL, suffix, prefix);
            }
            i = i + Math.max(x, y);
        }
        return -1;
    }

    private static int moveByGS(int j, int pthL, int[] suffix, boolean[] prefix) {
        int k = pthL - 1 - j; // 好后缀长度
        if (suffix[k] != -1)
            return j - suffix[k] + 1;
        for (int r = j + 2; r <= pthL - 1; r++) {
            if (prefix[pthL - r]) {
                return r;
            }
        }
        return pthL;
    }

    public static void generateBC(char[] b, int m, int[] bc) {
        for (int i = 0; i < SIZE; i++) {
            bc[i] = -1;
        }
        for (int i = 0; i < m; i++) {
            int ascii = (int) b[i];
            bc[ascii] = i;
        }
    }

    public static void generateGS(char[] b, int m, int[] suffix, boolean[] prefix) {
        for (int i = 0; i < m; i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }
        for (int i = 0; i < m - 1; i++) {
            int j = i;
            int k = 0; // 公共后缀字串长度
            while (j >= 0 && b[j] == b[m - 1 - k]) {
                j--;
                k++;
                suffix[k] = j + 1; // j + 1 表示公共后缀字串在b[0， i]中的起始下标
            }
            if (j == -1) {
                prefix[k] = true; // 如果公共后缀字串也是模式串的前缀子串
            }
        }
    }

    public static int kmp(char[] tag, char[] pth) {
        int tagL = tag.length;
        int pthL = pth.length;
        int[] next = getNexts(pth, pthL);
        int j = 0;
        for (int i = 0; i < tagL; i++) {
            while (j > 0 && tag[i] != pth[j]) {
                j = next[j - 1] + 1;
            }
            if (tag[i] == pth[j]){
                j++;
            }
            if (j == pthL){
                return i - pthL + 1;            }
        }
        return -1;
    }

    private static int[] getNexts(char[] pth, int pthL) {
        int[] next = new int[pthL];
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < pthL; i++){
            while (k != -1 && pth[k + 1] != pth[i]){
                k = next[k];
            }
            if (pth[k+1] == pth[i]){
                k++;
            }
            next[i] = k;
        }
        return next;
    }
}
