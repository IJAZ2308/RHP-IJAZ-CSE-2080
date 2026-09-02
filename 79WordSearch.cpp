class Solution {
public:
const int d[5] = {0,1,0,-1,0};
bool dfs(int R, int C, int row, int col, vector<vector<char>>& board, string word, int idx){
    if(idx == word.length()){
        return true;
    }
    char bkup = board[row][col];
    board[row][col] = '.';
    for(int i = 0;i<4;i++){
        int ar = row + d[i], ac = col+d[i+1];
        if(ar>=0 && ar<R && ac>=0 && ac<C && board[ar][ac] == word[idx]){
            bool found = dfs(R,C,ar,ac,board,word,idx+1);
            if(found) return true;
        }
    }
    board[row][col] = bkup;
    return false;
}
    bool exist(vector<vector<char>>& board, string word) {
       int R = board.size(), C = board[0].size();
       for(int row=0;row<R; row++){
        for(int col = 0;col<C;col++){
            if(board[row][col] == word[0]){
                bool found = dfs(R,C,row, col , board, word , 1);
                if(found) return true;
            }
        }
       }
  return false;
    }
  
};