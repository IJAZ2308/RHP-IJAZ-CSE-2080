class Solution {
     private int find(int ldr[],int node){
        if(ldr[node] != node){
            ldr[node] = find(ldr,ldr[node]);

        }
        return ldr[node];
    }
    private void join(int ldr[],int lt,int rt){
        ldr[find(ldr,rt)] = find(ldr,lt);
    }
    public int findCircleNum(int[][] G) {
        int N= G.length;
        int ldr[] = new int[N+1];
        for(int c=1;c<= N ; c++) ldr[c] =  c;
        for(int ci = 0;ci < N; ci++){
            for(int oc = 0;oc<N; oc++){
               if(ci == oc) continue;
               if(G[ci][oc] == 1){
                join(ldr,ci + 1, oc+1);
               }
            }
        }
        Set<Integer> st = new HashSet<>();
        for(int c = 1;c<=N;c++){
            st.add(find(ldr,c));

        }return st.size();
    }

}