import java.util.*;
public class DManyRepunitSum{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n= sc.nextInt();
    int []a=new int[n];
    for(int i=0;i<n;i++){
      a[i]=sc.nextInt();
    }
    Arrays.sort(a);
    long cfwd=0;
    StringBuilder ans= new StringBuilder("");
    for(int i=1;i<=a[n-1];i++){
      int lb=lowerBound(a,i);
      int ct=n-lb;
      cfwd+=ct;
      ans.append(cfwd%10);
      cfwd/=10;
    }
    while(cfwd!=0){
      ans.append(cfwd%10);
      cfwd/=10;
    }
    System.out.println(ans.reverse().toString());
  }public static int lowerBound(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    int ans = arr.length; 

    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (arr[mid] >= target) {
            ans = mid;        
            high = mid - 1;   
        } else {
            low = mid + 1;    
        }
    }
    return ans;
}

}