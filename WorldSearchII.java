class Trie {
    String word;
    Trie[] chars = new Trie[26];
}

class Solution {
    private void buildTrie(Trie root, String word) {
        Trie curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.chars[idx] == null) {
                curr.chars[idx] = new Trie();
            }
            curr = curr.chars[idx];
        }
        curr.word = word;
    }

    private int[] d = {0, 1, 0, -1, 0};
    private void dfs(int R, int C, int row, int col, 
                     char[][] board, boolean[][] vis, 
                     Trie node, List<String> ans) {
        int chIdx = board[row][col] - 'a';
        if (chIdx < 0 || chIdx >= 26 || node.chars[chIdx] == null) {
            return;
        }
        Trie curr = node.chars[chIdx];
        if (curr.word != null) {
            ans.add(curr.word);
            curr.word = null; 
        }
        vis[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int ar = row + d[i];
            int ac = col + d[i+1];
            
            if (ar >= 0 && ar < R && ac >= 0 && ac < C && !vis[ar][ac]) {
                dfs(R, C, ar, ac, board, vis, curr, ans);
            }
        }

        vis[row][col] = false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for (String w : words) {
            buildTrie(root, w);
        }
        int R = board.length;
        int C = board[0].length;
        List<String> ans = new ArrayList<>();
        boolean[][] vis = new boolean[R][C];
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                dfs(R, C, row, col, board, vis, root, ans);
            }
        }
        return ans; 
    }
}