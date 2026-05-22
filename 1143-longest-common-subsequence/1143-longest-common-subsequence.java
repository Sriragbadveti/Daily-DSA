class Solution {
    int dp[][] ;
    public int longestCommonSubsequence(String text1, String text2) {
        
        dp = new int[text1.length()][text2.length()];
         for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return traversal(text1 , text2 , 0 , 0 );
    }

    public  int traversal(String text1 , String text2 , int n , int m){

        //base case
        if(n==text1.length() || m==text2.length())return 0;

        //check cache
        if(dp[n][m] != -1){
            return dp[n][m];
        }

        //choices

        
        if(text1.charAt(n) == text2.charAt(m)){
            dp[n][m]  = 1+traversal(text1 , text2 , n+1 , m+1);
            return dp[n][m];
        }else{

            dp[n][m] = (Math.max(traversal(text1 , text2 , n+1 , m) , traversal(text1 , text2 , n , m+1)));
            return dp[n][m];
        }
    }
}