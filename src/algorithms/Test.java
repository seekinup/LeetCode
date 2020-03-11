package algorithms;

public class Test {


    public static String max(String a, String b) {
        String[] q = ("#" + a + "#").split("\\D+");
        String[] p = ("#" + b + "#").split("\\D+");
        int i = 1, j = 1, len1 = q.length, len2 = p.length;
        int x = 0, y = 0;
        while (i < len1 || j < len2) {
            x = i < len1 ? Integer.parseInt(q[i]) : 0;
            y = j < len2 ? Integer.parseInt(p[j]) : 0;
            if (x != y) break;
            i++; j++;
        }
        return x > y ? a : b;
    }


    public static void main(String[] args) {
        System.out.println(max("v12.2.3.34.test", "12.2..3.59"));
    }
}
