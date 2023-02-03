package easy;

public class IsSubsequence {
    public static void main(String[] args) {
        boolean output = new IsSubsequence().isSubsequence("abc", "ahbgdc");
        boolean output1 = new IsSubsequence().isSubsequence( "bbaaaa", "aaaaaa");
        assert output && !output1;
    }

    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        char ch1;
        char ch2;
        while (i < s.length() && j < t.length()) {
            ch1 = s.charAt(i);
            ch2 = t.charAt(j);
            if (ch1 == ch2) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
