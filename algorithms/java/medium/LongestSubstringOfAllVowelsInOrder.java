package medium;

public class LongestSubstringOfAllVowelsInOrder {
    public static void main(String[] args) {
        int expectedOutput = 13;
        assert expectedOutput == new LongestSubstringOfAllVowelsInOrder().longestSubstringOfAllVowelsInOrder("aeiaaioaaaaeiiiiouuuooaauuaeiu");
    }

    public int longestSubstringOfAllVowelsInOrder(String word) {
        int count = 1;
        int maxSize = 0;
        int len = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                len++;
            } else if (word.charAt(i - 1) < word.charAt(i)) {
                count++;
                len++;
            } else {
                len = 1;
                count = 1;
            }
            if (count == 5) {
                maxSize = Math.max(maxSize, len);
            }
        }
        return maxSize;
    }
}
