package medium;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int expectedOutput = 49;
        assert expectedOutput == new ContainerWithMostWater().maxArex(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
    }

    public int maxArex(int[] height) {
        int x;
        int y;
        int maxArea = 0;

        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            x = j - i;
            y = Math.min(height[j], height[i]);
            maxArea = Math.max(y * x, maxArea);
            if (height[j] > height[i]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}
