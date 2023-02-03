package easy;

public class LengthOfLastWord {
    public static void main(String[] args) {
        int output = new LengthOfLastWord().lengthOfLastWord("   fly me   to   the moon  ");
        assert 4 == output;
    }

    public int lengthOfLastWord(String s) {
        var split = s.trim().split(" ");
        int lastIndex = split.length - 1;
        return split[lastIndex].length();
    }
}
