class Solution {
    public long minCost(int[] nums) {
        int n = nums.length;
        int j = 0;
        long ans = Long.MAX_VALUE;
        
        for(int i  = 0 ; i<n ; i++){
            if(nums[i] != nums[j]) j = i;

            if (i >= 1 && j < n - 1) {
                long prefix = 1L * j * nums[j];
                long suffix = 1L * (n - i - 1) * nums[i];

                ans = Math.min(ans, prefix + suffix);
            }
        }
        return ans;
    }
}