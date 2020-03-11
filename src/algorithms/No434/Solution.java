package algorithms.No434;

/**
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * <p>
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello, my name is John"
 * 输出: 5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-segments-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static int countSegments(String s) {
        int cnt = 0, cursor = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                cursor++;
            } else {
                if (cursor > 0) {
                    cursor = 0;
                    cnt++;
                }
            }

        }
        if (cursor > 0) cnt++;

        return cnt;
    }


    /**
     * 官方算法
     * @param s
     * @return
     */
    public int countSegments2(String s) {
        int segmentCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i-1) == ' ') && s.charAt(i) != ' ') {//当前不等于空并且上一个等于空或者处于开头位置，则计数器加1
                segmentCount++;
            }
        }

        return segmentCount;
    }


    public static void main(String[] args) {
        System.out.println(countSegments("Hello, my name is John  "));
    }
}
