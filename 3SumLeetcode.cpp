class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int N = nums.size();
        vector<vector<int>> res;

        for(int i = 0; i <= N - 3; i++){
            if(nums[i] > 0) break;
            if(i != 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1, r = N - 1;

            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];

                if(sum == 0){
                    vector<int> ans = {nums[i], nums[l], nums[r]};
                    res.push_back(ans);

                    while(l + 1 < N && nums[l + 1] == nums[l]) l++;
                    while(r - 1 >= 0 && nums[r - 1] == nums[r]) r--;

                    l++;
                    r--;
                }
                else if(sum < 0){
                    l++;
                }
                else{
                    r--;
                }
            }
        }

        return res;
    }
};
