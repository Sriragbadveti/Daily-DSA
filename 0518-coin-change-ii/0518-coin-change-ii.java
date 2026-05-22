class Solution {
    int dp[][];

    public int change(int amount, int[] coins) {

        dp = new int[coins.length][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        //this is the memoized solution
        return traversal(coins, amount, 0);
    }

    public int traversal(int coins[], int target, int index) {

        if (target < 0)
            return 0;
        //base case 
        if (target == 0)
            return 1;
        if (index == coins.length)
            return 0;

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int take = traversal(coins, target - coins[index], index);
        int skip = traversal(coins, target, index + 1);
        dp[index][target] = take + skip;
        return dp[index][target];
    }
}