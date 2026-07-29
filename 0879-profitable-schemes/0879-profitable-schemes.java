class Solution {
    int dp[][][];
    int N;
    int mod  = 1_000_000_007;;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        N = n;
        dp = new int[group.length + 1][minProfit + 1][n + 1];

        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }

        return solve(0 , 0 , 0  , minProfit , group , profit);
    }

    private int solve(int index , int p , int people , int minProfit , int group[] , int profit[]){

        //base cases

        if(people>N)return 0;
        if(index == group.length){
            if(p>=minProfit){
                return 1;
            }else{
                return   0;
            }
        }
        if(dp[index][p][people]!=-1)return dp[index][p][people];

        int notTaken = solve(index+1 , p , people , minProfit , group , profit);
        int taken = solve(index+1 , Math.min(minProfit , p+profit[index]) , people+group[index] , minProfit , group , profit);

        return dp[index][p][people] = (notTaken % mod + taken %mod)%mod;

    }
}