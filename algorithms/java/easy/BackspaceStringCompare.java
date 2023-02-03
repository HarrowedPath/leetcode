package easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class BackspaceStringCompare {
    public static void main(String[] args) {
        boolean output = new BackspaceStringCompare().twoPointer("ab#c", "ad#c");
        boolean output1 = new BackspaceStringCompare().buildStrings("ab#c", "ad#c");
        assert output && output1;
    }

    public boolean buildStrings(String S, String T) {
        return build(S).equals(build(T));
    }

    private String build(String S) {
        Deque<Character> ans = new ArrayDeque<>();
        for (char c: S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.isEmpty())
                ans.pop();
        }
        return String.valueOf(ans);
    }

    @SuppressWarnings({"Duplicates","java:S3776"})
    public boolean twoPointer(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int skipS = 0;
        int skipT = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
                return false;
            }
            if ((i >= 0) != (j >= 0)) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}

