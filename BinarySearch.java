class Solution {
    public int search(int[] nums, int target) {
        int l = 0,r = nums.length-1;
        int mid;
        while(l+1 < r){
            mid = l + (r - l)/2;
            if(nums[mid] < target){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        return nums[l] == target ? l : nums[r] == target ? r : -1;
    }
}