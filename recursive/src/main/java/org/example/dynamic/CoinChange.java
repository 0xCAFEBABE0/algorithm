package org.example.dynamic;

/**
 * <p>文件名称:org.example.dynamic.CoinChange</p>
 * <p>文件描述: 换钱数量问题</p>
 * <p>内容摘要: </p>
 * <p>其他说明: </p>
 *
 * @version 1.0
 * @since 2025/1/2
 */
public class CoinChange {

    //暴力递归
    private static int process01(int[] arr, int i, int aim) {
        int res = 0;
        if (i == arr.length) {
            res = 0 == aim ? 1 : 0;
        } else {
            for (int j = 0; arr[i] * j <= aim; ++j) {
                res += process01(arr, i + 1, aim - arr[i] * j);
            }
        }
        return res;
    }

    //记忆化搜索
    private static int p2(int[] arr, int aim) {
        int[][] cache = new int[arr.length + 1][aim + 1];
        return process02(arr, 0, aim, cache);
    }

    private static int process02(int[] arr, int i, int aim, int[][] cache) {
        int res = 0;
        if (i == arr.length) {
            res = 0 == aim ? 1 : 0;
        } else {
            int cacheV = 0;
            for (int j = 0; arr[i] * j <= aim; ++j) {
                cacheV = cache[i + 1][aim - arr[i] * j];
                if (0 != cacheV) {
                    res += -1 == cacheV ? 0 : cacheV;
                } else {
                    res += process02(arr, i + 1, aim - arr[i] * j, cache);
                }
            }
        }
        cache[i][aim] = 0 == res ? -1 : res;
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {5, 10, 25, 1};
        int aim = 15;
        int res = p2(arr, aim);
        System.out.println(res);
    }
}
