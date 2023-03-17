package easy;

public class SqrtX {
    public static void main(String[] args) {
        int expectedOutput = 2;
        assert expectedOutput == new SqrtX().newtonMethod(8);
        assert expectedOutput == new SqrtX().binarySearch(8);
    }

    public int newtonMethod(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }

    public int binarySearch(int x) {
        if (x == 0) return 0;
        int start = 1, end = x;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1))
                return mid;
            else if (mid > x / mid)
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }
}
