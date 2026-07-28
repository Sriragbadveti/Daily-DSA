class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long dp[][] = new long[n+1][2];
        for(long row[] : dp){
            Arrays.fill(row , -1);
        }

        return solve(nums , 0 , true , dp);

    }

    private long solve(int nums[] , int index , boolean isEven , long dp[][]){
        if(index==nums.length)return 0L;
        if(dp[index][isEven?0:1] != -1)return dp[index][isEven?0:1];

        long skip = solve(nums , index+1 , isEven , dp);

        int val = nums[index];
        if(isEven == false){
            val = -val;
        }

        long take = solve(nums , index+1 , !isEven ,dp)+val;

        return dp[index][isEven ? 0 : 1] = Math.max(skip, take);
    }
}