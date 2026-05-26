class Solution {

    Boolean dp[][];

    public boolean isMatch(String s, String p) {

        dp = new Boolean[s.length()][p.length()];

        for (Boolean num[] : dp) {
            Arrays.fill(num, null);
        }

        return traversal(s, p, 0, 0);

    }

    public boolean traversal(String s, String p, int i, int j) {

        //base case
        int n = s.length();
        int m = p.length();
        if (i == n && j == m)
            return true;
        if (j == m)
            return false;
        if (i == n) {

            for (int k = j; k < m; k++) {

                if (p.charAt(k) != '*') {
                    return false;
                }
            }

            return true;
        }
        //check cache
        if (dp[i][j] != null)
            return dp[i][j];

        if (s.charAt(i) == p.charAt(j)) {
            dp[i][j] = traversal(s, p, i + 1, j + 1);
            return dp[i][j];
        } else if ( p.charAt(j) == '?') {
            dp[i][j] = traversal(s, p, i + 1, j + 1);
            return dp[i][j];
        } else if ( p.charAt(j) == '*') {
            dp[i][j] = traversal(s, p, i + 1, j) || traversal(s, p, i, j + 1);
            return dp[i][j];
        } else {
            return false;
        }

    }
}