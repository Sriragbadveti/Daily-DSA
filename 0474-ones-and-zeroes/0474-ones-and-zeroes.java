class Solution {
    int dp [][][];
    public int findMaxForm(String[] strs, int m, int n) {

       dp = new int[strs.length+1][m+1][n+1];
       for(int arr[][] : dp) {

       for(int row[] : arr) {

        Arrays.fill(row, -1);
    }
}
      

       return traversal(strs , m , n ,0);
    }

    public int traversal(String strs[] , int m , int n , int index ) {

        //base case
        if(index == strs.length) return 0;
        


        //check cache
        if(dp[index][m][n] != -1) return dp[index][m][n];

        int curr = 0;
        String s = strs[index];
        int zeroes = 0;
        int ones = 0;
        for(int k = 0 ; k<s.length() ; k++){
             if(s.charAt(k) == '0')zeroes++;
             else ones++;
        } 
        int take = 0;
        if(zeroes <= m && ones<=n){
            take = 1+traversal(strs , m-zeroes , n-ones , index+1 );
        }

        int skip = traversal(strs , m , n , index+1);
        dp[index][m][n] = Math.max(take ,skip);
        return dp[index][m][n];
    }
}