package easy;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    public static void main(String[] args) {

        int output = new LongestPalindrome().mapSolution("abccccdd");
        int output1 = new LongestPalindrome().arraySolution("abccccdd");
        assert 7 == output;
        assert 7 == output1;
    }

    public int mapSolution(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.compute(s.charAt(i), (k, v) -> (v == null) ? 1 : ++v);
        }
        int count = 0;
        for (int val : map.values()) {
            count += val / 2 * 2;
            if (count % 2 == 0 && val % 2 == 1) count++;
        }
        return count;
    }

    public int arraySolution(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray())
            count[c]++;
        int ans = 0;
        for (int v : count) {
            ans += v / 2 * 2;
            if (ans % 2 == 0 && v % 2 == 1)
                ans++;
        }
        return ans;
    }
}
