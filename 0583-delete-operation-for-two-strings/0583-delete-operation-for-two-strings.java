class Solution {
    int dp[][];
    public int minDistance(String s1, String s2) {
        dp = new int[s1.length()][s2.length()];
         for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
       int lcs =  traversal(s1, s2, 0,0);
        
        int deletions = s1.length() - lcs;
        int additions = s2.length()-lcs;
        
        return deletions+additions;
    }
    public int traversal(String s1 , String s2 , int n , int m){
        
        //base case
        if(n==s1.length() || m==s2.length()){
            return 0;
        }
        
        //check cache
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        
        if(s1.charAt(n) == s2.charAt(m)){
            dp[n][m] = 1+traversal(s1,s2,n+1,m+1);
            return dp[n][m];
        }else{
            dp[n][m] = Math.max(traversal(s1,s2,n+1,m) , traversal(s1,s2,n,m+1));
            return dp[n][m];
        }
    }
}