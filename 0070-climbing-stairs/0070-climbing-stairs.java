class Solution {
    public int climbStairs(int n) {
        // this is a memoization solution 

        int dp[] = new int[n+1];
        Arrays.fill(dp , -1);

        return helper(n , dp);

    }

    public int helper(int n , int dp[]){

        //base case

        if(n < 0) return 0;
        if(n==0) return 1;

        //check for cache
        if(dp[n] != -1){
            return dp[n];
        }

        int one = helper(n-1 , dp);
        int two = helper(n-2 , dp);
        dp[n] = one+two;

        return dp[n];
    }
}