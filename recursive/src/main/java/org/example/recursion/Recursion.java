package org.example.recursion;

/**
 * <p>文件名称:org.example.recursion.Recursion</p>
 * <p>文件描述: 基础递归</p>
 * <p>版权所有: Copyright(C)2019-2022</p>
 * <p>公司: 趣店集团 </p>
 * <p>内容摘要: </p>
 * <p>其他说明:
 * 原问题与子问题除数据规模不同，求解思路完全相同
 * 需要弄清该如何缩小范围
 * </p>
 *
 * @author <a> href="mailto:chenrong@qudian.com">chen</a>
 * @version 1.0
 * @since 2024/11/18
 */
public class Recursion {

    private static int tip01_sum(int n) {
        if (1 == n) {
            return 1;
        }
        return tip01_sum(n - 1) + n;
    }

    private static int tip02_between_sum(int m, int n) {
        if (m == n) {
            return m;
        }
        return tip02_between_sum(m, n - 1) + n;
    }

    private static int tip03_fibonacci(int n) {
        if (1 == n || 2 == n) {
            return 1;
        }
        return tip03_fibonacci(n - 2) + tip03_fibonacci(n - 1);
    }

    private static int tip04_printMaxNum(int n) {
        if (n > 10) {
            return tip04_printMaxNum(n / 10);
        }
        return n;
    }

    private static int tip04_towerOfHanoi(int n) {
        if (1 == n) {
            return 1;
        }
        return tip04_towerOfHanoi(n - 1) * 2 + 1;
    }

    private static int tip05_frogJumpSteps(int n) {
        if (1 == n || 2 == n) {
            return n;
        }
        return tip05_frogJumpSteps(n - 1) + tip05_frogJumpSteps(n - 2);
    }

    private static String tip06_reverse(String src, int end) {
        if (end == 0) {
            return src.toCharArray()[end] + "";
        }
        return src.toCharArray()[end] + tip06_reverse(src, end - 1);
    }

    public static void main(String[] args) {
        System.out.println(tip01_sum(5));
        System.out.println(tip02_between_sum(2, 5));
        System.out.println(tip03_fibonacci( 6));
        System.out.println(tip04_printMaxNum( 68083));
        System.out.println(tip04_towerOfHanoi( 3));
        System.out.println(tip05_frogJumpSteps( 3));
        System.out.println(tip06_reverse( "abc", 2));
    }
}
