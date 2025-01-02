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

    public static void main(String[] args) {
        int[] arr = {5, 10, 25, 1};
        int aim = 15;
        int res = process01(arr, 0, aim);
        System.out.println(res);
    }
}
