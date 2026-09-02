class Solution {
    int[] d = {-1, 0, 1, 0, -1};
    int islctr = 1;
    private void dfs(int R, int C, int row, int col,
                     int[][] grid, boolean[][] vis, int islid) {
        grid[row][col] = islid;
        vis[row][col] = true;
        
        for (int i = 0; i < 4; i++) {
            int ar = row + d[i];
            int ac = col + d[i + 1];
            if (ar >= 0 && ar < R &&
                ac >= 0 && ac < C &&
                grid[ar][ac] == 1 &&
                !vis[ar][ac]) {
                dfs(R, C, ar, ac, grid, vis, islid);
            }
        }
    }
    public int largestIsland(int[][] grid) {

        int R = grid.length;
        int C = grid[0].length;

        boolean[][] vis = new boolean[R][C];
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {

                if (grid[row][col] == 1 && !vis[row][col]) {
                    dfs(R, C, row, col, grid, vis, ++islctr);
                }
            }
        }
        int[] cellcnt = new int[islctr + 1];
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {

                int id = grid[row][col];

                if (id != 0)
                    cellcnt[id]++;
            }
        }
        int maxsize = 0;
        for (int id = 2; id <= islctr; id++) {
            maxsize = Math.max(maxsize, cellcnt[id]);
        }
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (grid[row][col] == 0) {
                    HashSet<Integer> set = new HashSet<>();
                    for (int i = 0; i < 4; i++) {
                        int ar = row + d[i];
                        int ac = col + d[i + 1];
                        if (ar >= 0 &&
                            ar < R &&
                            ac >= 0 &&
                            ac < C &&
                            grid[ar][ac] != 0) {
                            set.add(grid[ar][ac]);
                        }
                    }
                    int curr = 1;
                    for (int id : set)
                        curr += cellcnt[id];
                    maxsize = Math.max(maxsize, curr);
                }
            }
        }
        return maxsize;
    }
}
