package easy;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String expectedOutput = "fl";
        assert expectedOutput.equals(new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        assert expectedOutput.equals(new LongestCommonPrefix().longestCommonPrefixBruteForce(new String[]{"flower", "flow", "flight"}));
    }

    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public String longestCommonPrefixBruteForce(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
