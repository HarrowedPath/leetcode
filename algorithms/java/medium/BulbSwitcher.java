package medium;

public class BulbSwitcher {
    public static void main(String[] args) {
        int expectedOutput = 1;
        assert expectedOutput == new BulbSwitcher().bulbSwitcher(3);
    }

    public int bulbSwitcher(int n) {
        return (int) Math.sqrt(n);
    }
}
