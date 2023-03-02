package medium;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "bab";
        assert s.equals(new LongestPalindromicSubstring().longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            String oddCenter = extend(s, i, i);
            String evenCenter = extend(s, i, i + 1);
            if (oddCenter.length() > max.length()) {
                max = oddCenter;
            }
            if (evenCenter.length() > max.length()) {
                max = evenCenter;
            }
        }
        return max;
    }

    private String extend(String s, int i, int j) {
        while (0 <= i && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }
}
