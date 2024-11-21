package org.example.stack;

import java.util.Stack;

/**
 * <p>文件名称:org.example.stack.MaxArea</p>
 * <p>文件描述: 最大子矩阵（0，,1）面积</p>
 * <p>内容摘要: </p>
 * <p>其他说明: </p>
 *
 * @version 1.0
 * @since 2024/11/15
 */
public class MaxArea {
    //构建直方图
    private static int buildMatrix(int[][] arr) {
        int result = 0;
        int length = arr[0].length;
        int[] rectangle = new int[length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < length; j++) {
                rectangle[j] = 0 == arr[i][j] ? 0 : rectangle[j] + arr[i][j];
            }
            result = Math.max(result, maxRectangle(rectangle));
        }
        return result;
    }

    private static int maxRectangle(int[] rectangle) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < rectangle.length; i++) {
            while (!stack.isEmpty() && rectangle[stack.peek()] > rectangle[i]) {
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                result = Math.max(result, (i - k - 1) * rectangle[j]);
            }
            stack.push(i);
        }
        //右边已不存在，更小值
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            result = Math.max(result, (rectangle.length - k - 1) * rectangle[j]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };
        System.out.println(buildMatrix(arr));
    }
}

