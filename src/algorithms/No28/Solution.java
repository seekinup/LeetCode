package algorithms.No28;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {


    /**
     * 暴力算法
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {

        if (needle.length() == 0) return 0;
        int n = haystack.length();
        int m = needle.length();

        // 如文本长度为7，模式长度为3，匹配到剩下两位还没匹配到就终止循环
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {//每一层文本值如果匹配，使用嵌套循环匹配后续的文本值
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }

            if (j == m) return i;
        }

        return -1;
    }


    /**
     * KMP算法
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStrByKMP(String haystack, String needle) {


        return -1;
    }


    public static void main(String[] args) {
        int i = strStr("111000", "11000");
        System.out.println(i);
    }
}
