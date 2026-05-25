class Solution {
    int dp[][];
    public int findTargetSumWays(int[] nums, int target) {
        
        // entirely this problem comes down to subset dp 
        int totalSum = 0;
        for(int i = 0 ; i<nums.length ; i++){
            totalSum+=nums[i];
        }

        // impossible cases
        if(Math.abs(target) > totalSum)
            return 0;

        if((totalSum + target) % 2 != 0)
            return 0;
        

        int p = (totalSum+target)/2;
        dp = new int[nums.length][p+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return traversal(p , nums , 0 , 0);
    }

    public int traversal(int target , int nums[] , int index , int runningSum){

        //base case
         if(index == nums.length){

            if(runningSum == target)
                return 1;

            return 0;
        }
        if(dp[index][runningSum] != -1) return dp[index][runningSum];

        int take = 0;
        if(nums[index]+runningSum <= target){

            take = traversal(target , nums , index+1 , runningSum+nums[index]);
        }

        int nottake = traversal(target , nums , index+1 , runningSum);

        dp[index][runningSum] = take+nottake;
        return dp[index][runningSum];
    }
}