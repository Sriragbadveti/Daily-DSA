class Solution {

    int dp[][];

    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        dp = new int[n][m];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return solve(word1, word2, 0, 0);
    }

    public int solve(String s1,
                     String s2,
                     int i,
                     int j){

        // word1 finished
        if(i == s1.length()){

            return s2.length() - j;
        }

        // word2 finished
        if(j == s2.length()){

            return s1.length() - i;
        }

        // memoization
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        // chars match
        if(s1.charAt(i) == s2.charAt(j)){

            return dp[i][j] =
                solve(s1, s2, i+1, j+1);
        }

        // insert
        int insert =
            1 + solve(s1, s2, i, j+1);

        // delete
        int delete =
            1 + solve(s1, s2, i+1, j);

        // replace
        int replace =
            1 + solve(s1, s2, i+1, j+1);

        dp[i][j] =
            Math.min(insert,
            Math.min(delete, replace));

        return dp[i][j];
    }
}