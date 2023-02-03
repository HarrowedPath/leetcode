package medium;

import java.util.ArrayList;

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int output = new MaxAreaOfIsland().maxAreaOfIsland(new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        });
        int output1 = new MaxAreaOfIsland().maxAreaOfIsland(new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        });
        assert 6 == output;
        assert 0 == output1;
    }

    public int maxAreaOfIsland(int[][] grid) {
        ArrayList<Integer> myList = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    myList.add(dfs(grid, i, j, 0));
            }
        }
        return myList.stream()
                .max(Integer::compare)
                .orElse(0);
    }

    public int dfs(int[][] grid, int i, int j, int count) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0)
            return 0;

        grid[i][j] = 0;

        int up = dfs(grid, i + 1, j, count);
        int down = dfs(grid, i - 1, j, count);
        int left = dfs(grid, i, j - 1, count);
        int right = dfs(grid, i, j + 1, count);

        count += up + down + left + right + 1;

        return count;
    }
}