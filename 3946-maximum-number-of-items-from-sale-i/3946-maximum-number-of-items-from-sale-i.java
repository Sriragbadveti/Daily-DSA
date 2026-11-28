class Solution {
    int cheapestItem = Integer.MAX_VALUE;

    public int maximumSaleItems(int[][] items, int budget) {
        cheapestItem = Integer.MAX_VALUE;
        int n = items.length;
        int m = items[0].length;
        int copies[] = new int[n];

        //pre-compute all the free items that we get at a particular index
        for (int i = 0; i < n; i++) {
            cheapestItem = Math.min(cheapestItem, items[i][1]);
            //now explore all the items that we get free exluding the current index
            int number = 0;
            for (int j = 0; j < n; j++) {

                if (i == j)
                    continue;
                if (items[j][0] % items[i][0] == 0) {
                    number++;
                }
            }

            copies[i] = number;
        }
        int dp[][] = new int[n + 1][budget + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1); // Replace -1 with your desired initial value
        }
        return solve(items, budget, dp, copies, 0);
    }

    public int solve(int items[][], int budget, int dp[][], int copies[], int index) {
        //base cases

        int n = items.length;
        if (index == n)
            return budget / cheapestItem;
        if (dp[index][budget] != -1)
            return dp[index][budget];
        int take = 0;
        int skip = 0;
        int price = items[index][1];
        if (price <= budget) {
            take = 1 + copies[index] +
                    solve(items, budget - price, dp, copies, index + 1);
        }

        skip = solve(items, budget, dp, copies, index + 1);

        return dp[index][budget] = Math.max(take, skip);

    }
}