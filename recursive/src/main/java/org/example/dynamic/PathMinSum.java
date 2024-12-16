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

    public static void main(String[] args) {
         int[][] m = {
             {1, 0, 2, 6},
             {3, 9, 0, 3},
             {4, 8, 5, 1},
             {7, 6, 2, 3},
         };
        int res = pathMinSum1(m);
        System.out.println(res);
    }

}
