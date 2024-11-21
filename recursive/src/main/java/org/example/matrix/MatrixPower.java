package org.example.matrix;

/**
 * <p>文件名称:org.example.matrix.MatrixPower</p>
 * <p>文件描述: 矩阵快速幂</p>
 * <p>内容摘要: </p>
 * <p>其他说明: </p>
 *
 * @version 1.0
 * @since 2024/11/14
 */
public class MatrixPower {

    private static long fastPower(long base, long p) {
        long res = 1;
        for (; p != 0; p >>=1) {
            if ((p & 1) != 0) {
                res *= base;
            }
            base *= base;
        }
        return res;
    }

    private static int[][] matrixPower(int[][] m, int p) {
        int[][] res = new int[m.length][m[0].length];
        // 构造单位矩阵 E
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }
        int[][] t = m;
        for (; p != 0; p >>= 1) {
            if ((p & 1) != 0) {
                res = produce(res, t);
            }
            t = produce(t, t);
        }
        return res;
    }

    private static int[][] produce(int[][] a, int[][] b) {
        int n = a.length;
        int m = b[0].length;
        int k = a[0].length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int c = 0; c < k; c++) {
                    ans[i][j] += a[i][c] * b[c][j];
                }
            }
        }
        return ans;
    }

    public static int f(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[][] base = { { 1, 1 }, { 1, 0 } };
        int[][] res = matrixPower(base, n - 2);
        return res[0][0] + res[0][1];
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        long l = f(46);
        System.out.println(l);
        System.out.println(System.nanoTime() - start);
    }
}
