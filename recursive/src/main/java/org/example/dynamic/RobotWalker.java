package org.example.dynamic;

/**
 * <p>文件名称:org.example.dynamic.RobotWalker</p>
 * <p>文件描述: 机器人一维移动，到达指定位置方法数</p>
 * <p>内容摘要: </p>
 * <p>其他说明: </p>
 *
 * @version 1.0
 * @since 2024/12/30
 */
public class RobotWalker {

    //递归暴力解法
    private static int walk(int n, int cur, int rest, int p) {
        if (0 == rest) {
            return cur == p ? 1: 0;
        }

        if (1 == cur) {
            return walk(n, 2, rest - 1, p);
        }
        if (n == cur) {
            return walk(n, n - 1, rest - 1, p);
        }
        return walk(n, cur + 1, rest - 1, p) + walk(n, cur - 1, rest - 1, p);
    }

    //无后效性，使用动态规划表
    private static int walk_dp01(int n, int cur, int rest, int p) {
        int[][] dp = new int[rest + 1][n + 1];
        dp[0][p] = 1; //base case

        for (int i = 1; i <= rest; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (1 == j) {
                    dp[i][j] =dp[i - 1][j + 1];
                } else if (n == j) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][ j - 1] + dp[i - 1][j + 1];
                }
            }
        }
        for (int i = 0; i <= rest; ++i) {
            for (int j = 0; j <= n; ++j) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
        return dp[rest][cur];
    }

    //采用空间压缩
    private static int walk_dp02(int n, int cur, int rest, int p) {
        int[] dp = new int[n + 1];
        dp[p] = 1;

        int leftUp = dp[1];
        for (int i = 1; i <= rest; ++i) {
            for (int j = 1; j <= n; ++j) {
                int t = dp[j];
                if (1 == j) {
                    dp[j] = dp[j + 1];
                } else if (n == j) {
                    dp[j] = leftUp;
                } else {
                    dp[j] = leftUp + dp[j + 1];
                }
                leftUp = t;
                System.out.print(dp[j]);
            }
            System.out.println();
        }
        return dp[cur];
    }

    public static void main(String[] args) {
        int walk = walk_dp02(5, 2, 3, 3);
        System.out.println(walk);
    }
}
