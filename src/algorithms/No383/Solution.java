package algorithms.No383;


import java.util.HashMap;

/**
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * <p>
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
 * <p>
 * 注意：
 * <p>
 * 你可以假设两个字符串均只含有小写字母。
 * <p>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ransom-note
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static boolean canConstruct(String ransomNote, String magazine) {
        int len1 = ransomNote.length(), len2 = magazine.length();

        if (len1 > len2) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len2; i++) {
            char key = magazine.charAt(i);
            map.put(key, map.getOrDefault(key, 1) + 1);
        }

        for (int i = 0; i < len1; i++) {
            char key = ransomNote.charAt(i);
            if (!map.containsKey(key) || map.get(key) == 0) return false;
            map.put(key, map.get(key) - 1);
        }
        return true;
    }


    /**
     * 官方题解，相比于上面的算法，显然时间空间上更加简洁
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct2(String ransomNote, String magazine) {
        int[] nums = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            nums[magazine.charAt(i) - 'a']++;//利用数组下标计算进行计数
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (nums[ransomNote.charAt(i) - 'a'] == 0) return false;
            nums[ransomNote.charAt(i) - 'a']--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "aab"));
    }
}
