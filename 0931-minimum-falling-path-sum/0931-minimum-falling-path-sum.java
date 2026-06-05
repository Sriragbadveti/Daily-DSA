class Solution {
    Integer[][] dp;
    int n ;
    int m;
    public int minFallingPathSum(int[][] matrix) {
        
        n= matrix.length;
        m = matrix[0].length;
      
       dp = new Integer[n][m];

        //now call the function solve for every columnn
        int row = 0;
        int min = Integer.MAX_VALUE;
        for(int col= 0 ; col<m ; col++){
            min = Math.min(min , solve(matrix , row , col));
        }
        return min;
    }

    private int solve(int matrix[][] , int row , int col){

        //base case
        if(row==n-1 ) return matrix[row][col];

        //check cache
        if(dp[row][col] != null) return dp[row][col];
        int min = Integer.MAX_VALUE;
        int sum = matrix[row][col];

        if(row+1<n && col-1>=0){
            min = Math.min(min , sum+solve(matrix , row+1 , col-1));
        }

        if(row+1<n){
            min = Math.min(min , sum+solve(matrix , row+1 , col));
        }

        if(row+1<n && col+1<m ){
            min = Math.min(min , sum+solve(matrix , row+1 , col+1));
        }

        dp[row][col] = min;
        return dp[row][col];
    }
}