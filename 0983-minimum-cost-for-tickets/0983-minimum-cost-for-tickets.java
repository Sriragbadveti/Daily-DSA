class Solution {
    int dp[];
    int n;

    public int mincostTickets(int[] days, int[] costs) {
        n = days.length;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(days, costs, 0);
    }

    private int solve(int days[], int costs[], int index) {

        //base case
        if (index >= n)
            return 0;

        //check cache
        if (dp[index] != -1)
            return dp[index];

        //now take the minimum of 3 passes
         int j = index;

        while(j < n && days[j] < days[index] + 1){
            j++;
        }

        int oneDay = costs[0] + solve(days , costs , j);

        j=index;

       
        while (j < days.length && days[j] < days[index] + 7) {
            j++;
        }
        int twoDay = costs[1] + solve(days , costs , j);
        j=index;

        while(j < n && days[j] < days[index] + 30){
            j++;
        }

        int threeDay = costs[2] + solve(days , costs , j);

        dp[index] = Math.min(oneDay , Math.min(twoDay , threeDay));
        return dp[index];

    }
}