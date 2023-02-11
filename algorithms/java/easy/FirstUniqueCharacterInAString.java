package easy;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("all")
public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        int expectedOutput = 0;
        assert expectedOutput == new FirstUniqueCharacterInAString().firstUniqChar("leetcode");
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            characterIntegerMap.compute(c, (k, v) -> (v == null) ? 1 : ++v);
        }
        for (int i = 0; i < s.length(); i++) {
            if (characterIntegerMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
