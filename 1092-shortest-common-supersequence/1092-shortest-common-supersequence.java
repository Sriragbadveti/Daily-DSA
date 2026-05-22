class Solution {
    int dp[][];
    String ans = "";

    public String shortestCommonSupersequence(String str1, String str2) {
        //this is going to be the memoized solution ->

        int n = str1.length();
        int m = str2.length();
        dp = new int[n + 1][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        traversal(str1, str2, 0, 0);
        buildChar(0, 0, str1, str2);
        return ans;

    }

    public int traversal(String str1, String str2, int i, int j) {

        //base case
        if (i == str1.length() || j == str2.length())
            return 0;

        //check cache
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (str1.charAt(i) == str2.charAt(j)) {
            dp[i][j] = 1 + traversal(str1, str2, i + 1, j + 1);
            return dp[i][j];
        } else {
            dp[i][j] = Math.max(traversal(str1, str2, i + 1, j), traversal(str1, str2, i, j + 1));
            return dp[i][j];
        }
    }

    public String buildChar(int i, int j, String str1, String str2) {

        //base case
        if (i == str1.length()) {
            while (j < str2.length()) {
                ans += str2.charAt(j);
                j++;
            }
            return ans;
        }

        if (j == str2.length()) {
            while (i < str1.length()) {
                ans += str1.charAt(i);
                i++;
            }
            return ans;
        }

       

        //now the main case if same append else take the superior one

        if (str1.charAt(i) == str2.charAt(j)) {

            ans += str1.charAt(i);
            buildChar(i + 1, j + 1, str1, str2);
            return ans;
        } else {
            if (dp[i + 1][j] > dp[i][j + 1]) {
                ans += str1.charAt(i);
                buildChar(i + 1, j, str1, str2);
                return ans;
            } else {
                ans += str2.charAt(j);
                buildChar(i, j + 1, str1, str2);
                return ans;
            }
        }

       
    }
}