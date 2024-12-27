package org.example.dynamic;

/**
 * <p>文件名称:org.example.dynamic.PathSum</p>
 * <p>文件描述: 矩阵路径最小和</p>
 * <p>内容摘要: </p>
 * <p>其他说明: </p>
 *
 * @version 1.0
 * @since 2024/12/16
 */
public class PathMinSum {

    //空间复杂度O(n*m)
    private static int pathMinSum1(int[][] m) {
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];

        dp[0][0] = m[0][0];
        for (int i = 1; i < row; ++i) {
            dp[i][0] = m[i][0] + dp[i-1][0];
        }
        for (int j = 1; j < col; ++j) {
            dp[0][j] = m[0][j] + dp[0][j-1];
        }

        for (int i = 1; i < row; ++i) {
            for (int j = 1; j < col; ++j) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    //滑动数组
    private static int pathMinSum2(int[][] m) {
        int row = m.length;
        int col = m[0].length;

        int len = Math.max(row, col);
        boolean toCol = row == len;

        int[] dp = new int[len];
        dp[0] = m[0][0];

        if (toCol) {
            for (int i = 1; i < row; ++i) {
                dp[i] = m[i][0] + dp[i-1];
            }

            for (int j = 1; j < col; ++j) {
                dp[0] = m[0][j] + dp[0];
                for (int i = 1; i < row; ++i) {
                    dp[i] = Math.min(dp[i], dp[i - 1]) + m[i][j];
                }
            }
        } else {
            for (int i = 1; i < col; ++i) {
                dp[i] = m[0][i] + dp[i-1];
            }

            for (int j = 1; j < row; ++j) {
                dp[0] = m[j][0] + dp[0];
                for (int i = 1; i < col; ++i) {
                    dp[i] = Math.min(dp[i], dp[i - 1]) + m[j][i];
                }
            }
        }
        return dp[len - 1];
    }

    //滑动数组
    private static int pathMinSum3(int[][] m) {
        int row = m.length;
        int col = m[0].length;

        int len = Math.max(row, col);
        boolean toCol = row == len;

        int[] dp = new int[len];
        dp[0] = m[0][0];

        int dpLen = toCol ? row : col;
        for (int i = 1; i < dpLen; ++i) {
            dp[i] = (toCol ? m[i][0] : m[0][i]) + dp[i-1];
        }

        for (int j = 1; j < (toCol ? col : row); ++j) {
            dp[0] = (toCol ? m[0][j] : m[j][0]) + dp[0];
            for (int i = 1; i < (toCol ? row : col); ++i) {
                dp[i] = Math.min(dp[i], dp[i - 1]) +  (toCol ? m[i][j] : m[j][i]);
            }
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
         int[][] m = {
             {1, 0, 2, 6},
             {3, 9, 0, 3},
             {4, 8, 5, 1},
             {7, 6, 2, 3},
         };
        int res = pathMinSum3(m);
        System.out.println(res);
    }

}
