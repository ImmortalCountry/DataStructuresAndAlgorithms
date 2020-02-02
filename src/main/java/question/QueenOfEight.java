package question;

/**
 * 八皇后问题
 */
public class QueenOfEight {
    // 全局或成员变量，下标表示行，值表示queen存储在哪一列
    private static int[] result = new int[8];

    /**
     * 调用方式 cal8queens(0)
     *
     * @param row
     */
    public static void cal8queens(int row) {
        // 8 个旗子都放好了
        if (row == 8) {
            printQueens(result);
            return;
        }
        for (int column = 0; column < 8; column++) {
            if (isOk(row, column)) {
                result[row] = column;
                cal8queens(row + 1);
            }
        }
    }

    private static boolean isOk(int row, int column) {
        int leftUp = column - 1;
        int rightUp = column + 1;
        for (int i = row - 1; i >= 0; i--) {
            // 第 i 行的 column 列有棋子吗
            if (result[i] == column) {
                return false;
            }
            if (leftUp >= 0 && result[i] == leftUp) {
                return false;
            }
            if (rightUp < 8 && result[i] == rightUp) {
                return false;
            }
            leftUp--;
            rightUp++;
        }
        return true;
    }

    private static void printQueens(int[] result) {
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (result[row] == column) {
                    System.out.print("Q ");
                } else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
