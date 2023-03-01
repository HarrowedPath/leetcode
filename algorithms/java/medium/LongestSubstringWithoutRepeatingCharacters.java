package medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        int expectedOutput = 3;
        assert expectedOutput == new LongestSubstringWithoutRepeatingCharacters().bruteForce("abcabcbb");
    }

    public int bruteForce(String s) {
        Map<Character, Integer> mapForS = new HashMap<>();
        int length = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (mapForS.containsKey(s.charAt(j))) {
                    break;
                } else {
                    mapForS.compute(s.charAt(j), (k, v) -> (v == null) ? 1 : ++v);
                    length++;
                }
            }
            maxLength = Math.max(length, maxLength);
            mapForS.clear();
            length = 0;
        }
        return maxLength;
    }
}
