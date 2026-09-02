class Solution {
    public int orangesRotting(int[][] grid) {
       int r = grid.length, c= grid[0].length;
    int orgs = 0,mins = 0;
    Queue<int[]> q = new LinkedList<>();
    for(int i = 0;i<r;i++){
        for(int j = 0;j<c;j++){
            if(grid[i][j] == 2){
                q.add(new int[]{i,j,0});
            } 
            if(grid[i][j] != 0){
                orgs++;
            }
        }
    }
    if(orgs == 0) return 0;
    int d[] = {0,1,0,-1,0};
    while(!q.isEmpty()){
        int cell[] =q.poll();
        orgs--;
        int row = cell[0],col = cell[1],dy = cell[2];
        mins = dy;
        for(int i  =0;i<4;i++){
            int ar = row+d[i],ac = col + d[i+1];
            if(ar>=0 && ar<r && ac>= 0 && ac<c && grid[ar][ac] == 1){
                q.add(new int[]{ar,ac,dy+1});
                grid[ar][ac]= 2;
            }
        }
    }
    return orgs == 0 ? mins : -1;
    
    }
}