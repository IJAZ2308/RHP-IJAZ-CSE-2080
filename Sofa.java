import java.util.*;

public class Main {

    static int n, m;
    static char[][] grid;

    static class State {
        int r, c, dir, dist;

        State(int r, int c, int dir, int dist) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.dist = dist;
        }
    }

    static boolean free(int r, int c) {
        return r >= 0 && r < n &&
               c >= 0 && c < m &&
               grid[r][c] != '1';
    }

    static boolean canPlace(int r, int c, int dir) {

        if (dir == 0) { // horizontal
            return free(r, c) && free(r, c + 1);
        }

        // vertical
        return free(r, c) && free(r + 1, c);
    }

    static boolean canRotate(int r, int c) {

        return free(r, c) &&
               free(r + 1, c) &&
               free(r, c + 1) &&
               free(r + 1, c + 1);
    }

    static int bfs(int sr, int sc, int sd,
                   int er, int ec, int ed) {

        boolean[][][] visited =
                new boolean[n][m][2];

        Queue<State> q = new LinkedList<>();

        visited[sr][sc][sd] = true;
        q.add(new State(sr, sc, sd, 0));

        while (!q.isEmpty()) {

            State cur = q.poll();

            if (cur.r == er &&
                cur.c == ec &&
                cur.dir == ed) {

                return cur.dist;
            }

            int r = cur.r;
            int c = cur.c;
            int d = cur.dir;

            // UP
            if (canPlace(r - 1, c, d)
                    && !visited[r - 1][c][d]) {

                visited[r - 1][c][d] = true;

                q.add(new State(
                        r - 1, c, d,
                        cur.dist + 1));
            }

            // DOWN
            if (canPlace(r + 1, c, d)
                    && !visited[r + 1][c][d]) {

                visited[r + 1][c][d] = true;

                q.add(new State(
                        r + 1, c, d,
                        cur.dist + 1));
            }

            // LEFT
            if (canPlace(r, c - 1, d)
                    && !visited[r][c - 1][d]) {

                visited[r][c - 1][d] = true;

                q.add(new State(
                        r, c - 1, d,
                        cur.dist + 1));
            }

            // RIGHT
            if (canPlace(r, c + 1, d)
                    && !visited[r][c + 1][d]) {

                visited[r][c + 1][d] = true;

                q.add(new State(
                        r, c + 1, d,
                        cur.dist + 1));
            }

            // ROTATE
            if (canRotate(r, c)) {

                int nd = 1 - d;

                if (!visited[r][c][nd]) {

                    visited[r][c][nd] = true;

                    q.add(new State(
                            r, c, nd,
                            cur.dist + 1));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        grid = new char[n][m];

        int sr = -1, sminc = -1;
        int er = -1, emin = -1;

        int sCount = 0;
        int eCount = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                grid[i][j] = sc.next().charAt(0);

                if (grid[i][j] == 'S') {
                    if (sr == -1) {
                        sr = i;
                        sminc = j;
                    }
                    sCount++;
                    grid[i][j] = '0';
                }

                if (grid[i][j] == 'E') {
                    if (er == -1) {
                        er = i;
                        emin = j;
                    }
                    eCount++;
                    grid[i][j] = '0';
                }
            }
        }

        int startDir;
        int endDir;

        if (sCount == 2) {

            // Determine orientation
            // This assumes adjacent S cells.

            startDir = 0; // horizontal by default

            if (sminc + 1 < m &&
                grid[sr][sminc + 1] == '0') {
                startDir = 0;
            }

        } else {
            startDir = 0;
        }

        // In the actual problem,
        // determine orientation using positions
        // of the two S cells and E cells.

        int answer = bfs(
                sr, sminc, startDir,
                er, emin, endDir = 0
        );

        if (answer == -1)
            System.out.println("Impossible");
        else
            System.out.println(answer);
    }
}
