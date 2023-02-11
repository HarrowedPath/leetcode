package easy;

public class ValidPalindrome {
    public static void main(String[] args) {
        boolean expectedOutput = true;
        assert expectedOutput == new ValidPalindrome().isValidPalindrome("A man, a plan, a canal: Panama");
    }

    public boolean isValidPalindrome(String s) {
        s = s.toLowerCase().replaceAll("\\s", "");
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char iChar = s.charAt(i);
            char jChar = s.charAt(j);
            if (!Character.isLetter(iChar) && !Character.isDigit(iChar)) {
                i++;
                continue;
            }
            if (!Character.isLetter(jChar) && !Character.isDigit(jChar)) {
                j--;
                continue;
            }
            iChar = iChar;
            jChar = jChar;
            if (iChar != jChar) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
