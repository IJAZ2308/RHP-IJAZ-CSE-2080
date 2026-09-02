class Solution {
public:
const int d[5]={0,1,0,-1,0};
    int nearestExit(vector<vector<char>>& g, vector<int>& ent) {
        int r=g.size(),c=g[0].size();
        queue<tuple<int,int,int>> q;
        q.push(make_tuple(ent[0],ent[1],0));
        g[ent[0]][ent[1]]='!';
        while(!q.empty()){
            auto[row,col,steps] = q.front();q.pop(); 
            if(row == 0 || row == r-1 || col == 0|| col == c-1){
                if(g[row][col]!='!'){
                    return steps;
                }
            }
            for(int i=0;i<4;i++){
                int ar=row+d[i],ac=col+d[i+1];
                if(ar>=0 && ar<r && ac>=0 && ac<c && g[ar][ac]=='.'){
                    q.push(make_tuple(ar,ac,steps+1));
                    g[ar][ac]='?';
                }
            }
        }
        return -1;

    }
};