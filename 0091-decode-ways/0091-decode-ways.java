class Solution {
    int dp[];

    public int numDecodings(String s) {

        dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return traversal(s, 0);

    }

    public int traversal(String s, int index) {

        //base case
        if (index == s.length())
            return 1;

        //check zero 
        if (s.charAt(index) == '0')
            return 0;

        //cache
        if (dp[index] != -1)
            return dp[index];

        //take one digit
        int oneDig = traversal(s, index + 1);
        int twoDig = 0;

        if (index + 1 < s.length()) {

            if (s.charAt(index) == '1' || s.charAt(index) == '2' && s.charAt(index + 1) <= '6') {
                twoDig = traversal(s, index + 2);
            }
        }

        dp[index] = oneDig + twoDig;

        return dp[index];
    }
}