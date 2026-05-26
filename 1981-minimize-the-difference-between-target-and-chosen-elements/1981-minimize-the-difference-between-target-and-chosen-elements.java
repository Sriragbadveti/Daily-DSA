class Solution {
    int dp[][];
    public int minimizeTheDifference(int[][] mat, int target) {
        int n= mat.length;
        dp = new int[n+1][5000];

        for(int row[] : dp){
            Arrays.fill(row,-1);
        }

        return traversal(mat , target , 0 , 0);
    }

    public int traversal(int mat[][] , int target , int currSum , int row){

        int n = mat.length;
        int m = mat[0].length;

      
        if(row==n)return Math.abs(currSum-target);
        if(dp[row][currSum] != -1)return dp[row][currSum];

        //now check for eveery element in row one
        int ans = Integer.MAX_VALUE;
        for(int col = 0 ; col<m ; col++){

            ans = Math.min(ans , traversal(mat , target , currSum+mat[row][col] , row+1));
        }

        dp[row][currSum] = ans;
        return ans;
    }
}