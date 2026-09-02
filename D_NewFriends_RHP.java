import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int []ldr=new int[n+1];
        int []gcnt=new int[n+1];
        int []ecnt=new int[n+1];
        List<int[]> elist=new ArrayList<>();
        for(int i=1;i<=n;i++){
            ldr[i]=i;
        }
        for(int e=0;e<m;e++){
            int lt=sc.nextInt();
            int rt=sc.nextInt();
            elist.add(new int[]{lt,rt});
            join(ldr,lt,rt);
        }
        for(int i=1;i<=n;i++){
            gcnt[find(ldr,i)]++;
        }for(int i=0;i<m;i++){
            int ld=find(ldr,elist.get(i)[1]);
            ecnt[ld]++;
        }
       long sum=0;
       for(int i=1;i<=n;i++){
        if(gcnt[i]>0){
            long a=gcnt[i];
            sum+=(a*(a-1))/2 - ecnt[i];
        }
       }
       System.out.println(sum);
        sc.close();
    }
    private static void join(int [] ldr,int lt,int rt){
        int ldlt=find(ldr,lt);
        int ldrt=find(ldr,rt);
        ldr[ldrt]=ldr[ldlt];
        
    }
    private static int find (int []ldr,int node){
        if(ldr[node]!=node){
            ldr[node]=find(ldr,ldr[node]);
        }
        return ldr[node];
    }
}
