package easy;

public class FirstBadVersion {
    private static final int BAD = 4;

    public static void main(String[] args) {
        int output = new FirstBadVersion().firstBadVersion(5);
        assert BAD == output;
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int min = 0;
        int mid = 0;
        while (left <= n) {
            mid = left + (n - left) / 2;
            if (isBadVersion(mid)) {
                min = mid;
                n = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return min;
    }

    private boolean isBadVersion(int index) {
        return BAD == index;
    }
}
