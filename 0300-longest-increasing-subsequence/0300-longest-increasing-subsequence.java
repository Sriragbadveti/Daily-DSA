class Solution {
    int dp[][];
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n][n];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }

        return traversal(nums , 0 , -1);
    }

    public int traversal(int nums[] , int index , int prev){

        int n = nums.length;
        //base case

        if(index==n)return 0;

        //check cache
        if(dp[index][prev+1] != -1)return dp[index][prev+1];

        int skip = traversal(nums , index+1 , prev);

        int take = 0;
        if(prev == -1 || nums[index] > nums[prev]){
            take = 1+traversal(nums , index+1 , index);         
        }    

        return dp[index][prev+1] = Math.max(take , skip);
        
        
    }
}