package algorithms.No205;


import java.util.HashMap;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: s = "paper", t = "title"
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (!map.containsKey(a)) {
                if(map.containsValue(b)) return false;//还要判断存入的值是不是还对应着别的键
                map.put(a, b);

            };
            if (map.get(a) != b) return false;

        }
        return true;
    }


    /**
     *
     * 字符串中，同一个位置的字符在本串中第一次出现的位置相同。我简单解释一下，本题判定为false有这些个情况，我们假设拿s串和t串作对比
     * 1.s串中相同的字符，对应的t串中的字符并不相等
     * 2.s串中不同的字符，对应的t串中的字符却是相等的
     * 所以判断的关键点就是相同的字符要对应相同的字符，那么相同字符处于后位置的字符的第一次出现的位置就应该相同。
     * 所以我们在判断时，只需要判断两个字符串同位置的字符是否相同即可。
     *
     * 作者：hao-fei-hao
     * 链接：https://leetcode-cn.com/problems/isomorphic-strings/solution/javake-neng-bi-jiao-jian-dan-de-xie-fa-by-hao-fei-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic2(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if(s.indexOf(ch1[i]) != t.indexOf(ch2[i])){
                return false;
            }
        }
        return true;
    }


}
