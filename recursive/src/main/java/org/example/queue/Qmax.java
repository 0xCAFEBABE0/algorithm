package org.example.queue;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * <p>文件名称:org.example.queue.Qmax</p>
 * <p>文件描述: 双端队列，实现滑动窗口解决区间最大值</p>
 * <p>版权所有: Copyright(C)2019-2022</p>
 * <p>公司: 趣店集团 </p>
 * <p>内容摘要: </p>
 * <p>其他说明: </p>
 *
 * @author <a> href="mailto:chenrong@qudian.com">chen</a>
 * @version 1.0
 * @since 2024/11/12
 */
public class Qmax {

    public static int[] maxWindow(int[] arr, int w) {
        LinkedList<Integer> qmax = new LinkedList<>();
        int N = arr.length;
        int[] res = new int[N - w + 1];
        int index = 0;

        // R 从左到右遍历数组，不回退
        for (int R = 0; R < N; R++) {
            // 双端队列中有值，并且 队尾的数 比当前的 小 就弹出
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[R]) {
                qmax.pollLast();
            }
            // 双端队列为空，或者弹出完比自己小的数了
            // 从末尾插入队列中
            qmax.addLast(R);
            // R-w 是过期的下标，即 L 的位置
            // 队头的下标 过期了就弹出
            if (qmax.peekFirst() == R - w) {
                qmax.pollFirst();
            }
            if (R >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int[] res = maxWindow(arr, 3);
        System.out.println(Arrays.toString(res));
    }
}
