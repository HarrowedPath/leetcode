package easy;

import java.util.HashMap;

@SuppressWarnings("Duplicates")
public class ValidAnagram {
    public static void main(String[] args) {
        boolean expectedOutput = true;
        assert expectedOutput == new ValidAnagram().arraySmartForce("anagram", "nagaram");
        assert expectedOutput == new ValidAnagram().bruteForce("anagram", "nagaram");
        assert expectedOutput == new ValidAnagram().sameProductivityOneMapForce("anagram", "nagaram");
    }

    public boolean arraySmartForce(String s, String t) {
        int[] a = new int[26];
        for (char c : s.toCharArray()) {
            a[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            a[c - 'a']--;
        }
        for (int n : a) {
            if (n != 0) return false;
        }
        return true;
    }

    public boolean sameProductivityOneMapForce(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.compute(s.charAt(i), (k, v) -> (v == null) ? 1 : ++v);
        }
        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) {
                return false;
            }
            if (map.get(t.charAt(i)) == 1) {
                map.remove(t.charAt(i));
            } else {
                map.compute(t.charAt(i), (k, v) -> (v == null) ? 0 : --v);
            }
        }
        return map.size() == 0;
    }

    public boolean bruteForce(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sMap.compute(s.charAt(i), (k, v) -> (v == null) ? 1 : ++v);
            tMap.compute(t.charAt(i), (k, v) -> (v == null) ? 1 : ++v);
        }
        return sMap.equals(tMap);
    }
}
