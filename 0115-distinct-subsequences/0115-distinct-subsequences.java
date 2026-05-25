class Solution {

    int dp[][];

    public int numDistinct(String s, String t) {

        int n = s.length();
        int m = t.length();

        dp = new int[n][m];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return solve(s, t, 0, 0);
    }

    public int solve(String s,
                     String t,
                     int i,
                     int j){

        // target completed
        if(j == t.length()){
            return 1;
        }

        // source finished
        if(i == s.length()){
            return 0;
        }

        // memoization
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int take = 0;

        // chars match
        if(s.charAt(i) == t.charAt(j)){

            take = solve(s, t, i+1, j+1);
        }

        // skip current char in s
        int skip = solve(s, t, i+1, j);

        dp[i][j] = take + skip;

        return dp[i][j];
    }
}