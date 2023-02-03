package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings("all")
public class FindAllAnagramsInString {

    public static void main(String[] args) {
        FindAllAnagramsInString findAllAnagramsInString = new FindAllAnagramsInString();

        var output1 = Arrays.asList(0, 6);
        var output2 = Arrays.asList(0, 1, 2);

        assert output1.equals(findAllAnagramsInString.findAnagrams("cbaebabacd", "abc"));
        assert output2.equals(findAllAnagramsInString.findAnagrams("abab", "ab"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return new ArrayList<>();
        }

        var sMap = new HashMap<Character, Integer>();
        var pMap = new HashMap<Character, Integer>();

        for (int i = 0; i < p.length(); i++) {
            pMap.compute(p.charAt(i), (k, v) -> (v == null) ? 1 : ++v);
            sMap.compute(s.charAt(i), (k, v) -> (v == null) ? 1 : ++v);
        }

        List<Integer> ans = new ArrayList<>();
        int left = 0, right = p.length();

        while (right < s.length()) {
            if (sMap.equals(pMap)) ans.add(left);

            // acquire the next char from the right
            char acquire = s.charAt(right);
            sMap.compute(acquire, (k, v) -> (v == null) ? 1 : ++v);

            // get rid the first from extreme left of window
            char discard = s.charAt(left);
            if (sMap.get(discard) == 1) {
                sMap.remove(discard);
            } else {
                sMap.put(discard, sMap.get(discard) - 1);
            }

            // slide the window
            left++;
            right++;
        }

        if (sMap.equals(pMap)) ans.add(left);

        return ans;
    }
}
