package easy;

import java.util.Arrays;

@SuppressWarnings("all")
public class ReverseString {
    public static void main(String[] args) {
        char[] inputCharArray = new char[]{'h', 'e', 'l', 'l', 'o'};
        new ReverseString().reverseString(inputCharArray);
        char[] expectedOutput = new char[]{'o', 'l', 'l', 'e', 'h'};
        assert Arrays.equals(inputCharArray, expectedOutput);
    }

    public void reverseString(char[] a) {
        int i = 0;
        int j = a.length - 1;
        while (i < j) {
            swap(a, i++, j--);
        }
    }

    static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
