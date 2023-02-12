package medium;


public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        int expectedOutput = 2;
        assert expectedOutput == new FindTheIndexOfTheFirstOccurrenceInAString().bruteForce("hello", "ll");
        assert expectedOutput == new FindTheIndexOfTheFirstOccurrenceInAString().bruteForceV2("hello", "ll");
        assert expectedOutput == new FindTheIndexOfTheFirstOccurrenceInAString().bruteForceV3("hello", "ll");
    }

    public int bruteForceV3(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
                if (j == needle.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int bruteForceV2(String haystack, String needle) {
        for (int i = 0; i < haystack.length() - needle.length(); i++) {
            int size = 0;
            for (int j = i; j < haystack.length(); j++) {
                if (haystack.charAt(j) != needle.charAt(size)) {
                    break;
                }
                if (size == needle.length() - 1) {
                    return i;
                }
                size++;
            }
        }
        return -1;
    }

    public int bruteForce(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            StringBuilder subStringBuilder = new StringBuilder();
            int size = 0;
            for (int j = i; j < haystack.length(); j++) {
                subStringBuilder.append(haystack.charAt(j));
                size++;
                if (size == needle.length()) {
                    break;
                }
            }
            if (needle.matches(subStringBuilder.toString())) {
                return i;
            }
        }
        return -1;
    }
}
