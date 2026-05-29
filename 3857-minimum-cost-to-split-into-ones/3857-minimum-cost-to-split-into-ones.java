class Solution {
    int dp[];
    public int minCost(int n) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n);
    }

    public int solve(int n ){

        //base case
        if(n == 1) return 0;

        //check cache
        if(dp[n]!=-1)return dp[n];

        int ans = Integer.MAX_VALUE;
        for(int a = 1; a<=n/2; a++){

            int b = n-a;

           int curr = a*b + solve(a) + solve(b);
            ans = Math.min(ans , curr);
        }

        dp[n] = ans;
        return dp[n];

    }
}