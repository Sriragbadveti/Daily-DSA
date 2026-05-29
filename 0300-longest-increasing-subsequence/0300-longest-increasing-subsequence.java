class Solution {
    public int lengthOfLIS(int[] nums) {
        //this is the tabulation solution
        int n = nums.length;
        int dp[][] = new int[n+1][n+1];

        //we have to start filling from the backward because recurrence depends on index+1

        for(int index = n-1 ; index>=0 ; index--){
            for(int prev = index-1 ; prev>=-1 ; prev--){

                int skip = dp[index+1][prev+1];

                int take  = 0 ;
                if( prev==-1  || nums[index] > nums[prev] ){
                    take = 1+dp[index+1][index+1];
                }
                dp[index][prev+1] = Math.max(skip , take);
            }
        }
        return dp[0][0];

    }
}