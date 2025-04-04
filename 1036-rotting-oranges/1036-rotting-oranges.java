import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        HashSet<String> li = new HashSet<>();
        int empty = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2)
                    li.add(i + "," + j); // storing as a string to avoid object identity issues
                if (grid[i][j] == 0)
                    empty++;
            }
        }

        int[][] vis = new int[n][m];
        int ans = 0;

        while (li.size() + empty < (n * m)) {
            ans++;
            HashSet<String> newSet = new HashSet<>();

            for (String pos : li) {
                String[] parts = pos.split(",");
                int i = Integer.parseInt(parts[0]);
                int j = Integer.parseInt(parts[1]);

                for (int[] dir : directions) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x < n && x >= 0 && y < m && y >= 0 && vis[x][y] == 0 && grid[x][y] == 1) {
                        vis[x][y] = 1;
                        grid[x][y] = 2;
                        newSet.add(x + "," + y);
                    }
                }
            }

            if (newSet.isEmpty()) {
                return -1; 
            }

            li.addAll(newSet); 
        }

        return ans;
    }
}
