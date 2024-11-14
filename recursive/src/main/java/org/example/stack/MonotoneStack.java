package org.example.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * <p>文件名称:org.example.stack.MonotoneStack</p>
 * <p>文件描述: 单调栈,严格递减</p>
 * <p>版权所有: Copyright(C)2019-2022</p>
 * <p>公司: 趣店集团 </p>
 * <p>内容摘要: </p>
 * <p>其他说明: </p>
 *
 * @author <a> href="mailto:chenrong@qudian.com">chen</a>
 * @version 1.0
 * @since 2024/11/14
 */
public class MonotoneStack {

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 6, 9, 3 , 5};
        int length = arr.length;
        int[][] res = new int[length][2];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                Integer n = stack.pop();
                res[n][0] = stack.isEmpty() ? -1 : stack.peek();
                res[n][1] = i;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            Integer n = stack.pop();
            res[n][0] = stack.isEmpty() ? -1 : stack.peek();
            res[n][1] = -1;
        }
        System.out.println(Arrays.deepToString(res));
    }
}
