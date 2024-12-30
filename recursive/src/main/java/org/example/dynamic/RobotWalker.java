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


    public static void main(String[] args) {
        int walk = walk(5, 2, 3, 3);
        System.out.println(walk);
    }
}
