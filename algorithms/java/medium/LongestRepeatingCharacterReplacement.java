package medium;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();
        int output = 4;


        assert output == longestRepeatingCharacterReplacement.characterReplacement("ABAB", 2);
        assert output == longestRepeatingCharacterReplacement.characterReplacement("AABABBA", 1);
    }

    public int characterReplacement(String s, int k) {
        Map<Character, Integer> substringMap = new HashMap<>();
        char[] arr = s.toCharArray();
        int left = 0;
        int right = 0;

        int maxLen = 0;
        int mostFreq = 0;
        while (right < s.length()) {
            substringMap.compute(arr[right], (key, value) -> (value == null) ? 1 : ++value);
            mostFreq = Math.max(mostFreq, substringMap.get(arr[right]));

            int canBeReplaced = (right - left + 1) - mostFreq;

            if (canBeReplaced > k) {
                substringMap.computeIfPresent(arr[left], (key, value) -> --value);
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}
