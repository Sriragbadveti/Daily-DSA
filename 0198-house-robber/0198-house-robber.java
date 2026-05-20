class Solution {
    public int rob(int[] nums) {
        
        int dp [] = new int[nums.length+1];
        Arrays.fill(dp , -1);
        return helper(nums , dp , 0);

    }

    public int helper(int nums[] , int dp[] , int index){

        //base case
        if(index>=nums.length){
            return 0;
        }

        //check for cache
        if(dp[index] != -1){
            return dp[index];
        }

         //compute the choices now

         int take = nums[index] + helper(nums , dp , index+2);
         int skip = helper(nums , dp , index+1);
         dp[index] = Math.max(take , skip);

         return dp[index];

    }
}