public class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] f = new int[m][n];
        f[0][0] = grid[0][0] == 1 ? 0 : 1;

        for (int i = 1; i < n; ++i) {
            if (grid[0][i] != 1) f[0][i] = f[0][i - 1];
            else f[0][i] = 0;
        }
        for (int i = 1; i < m; ++i) {
            if (grid[i][0] != 1) f[i][0] = f[i - 1][0];
            else f[i][0] = 0;
        }

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (grid[i][j] != 1) f[i][j] = f[i - 1][j] + f[i][j - 1];
                else f[i][j] = 0;
            }
        }

        return f[m - 1][n - 1];
    }
}
