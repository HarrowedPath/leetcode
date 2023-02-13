package medium;

public class StringToIntegerAtoi {
    public static void main(String[] args) {
        int expectedOutput = -428;
        assert expectedOutput == new StringToIntegerAtoi().myAtoi("     -428");
    }

    public int myAtoi(String s) {
        int num = 0;
        int prevNum;
        int sign = 1;
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        if (!Character.isDigit(s.charAt(0)) && s.charAt(0) != '+' && s.charAt(0) != '-') {
            return 0;
        }
        int startIndex = 0;
        if (!Character.isDigit(s.charAt(0))) {
            startIndex++;
        }

        if (s.charAt(0) == '-') {
            sign = -1;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                prevNum = num;
                num = num * 10 + Character.getNumericValue(s.charAt(i));
                if ((num - Character.getNumericValue(s.charAt(i))) / 10 != prevNum || num < 0) {
                    return sign < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
            } else {
                break;
            }
        }
        return num * sign;
    }
}

