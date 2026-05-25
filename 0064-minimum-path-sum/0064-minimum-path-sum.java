class Solution {
    int dp[][];
    public int minPathSum(int[][] grid) {
        dp  = new int[grid.length][grid[0].length];
        for(int row[] : dp){
            Arrays.fill(row , -1);
        }

        return traversal(grid , 0 , 0);
    }

    public int traversal(int arr[][] , int rows , int cols){

        //base case

        int n = arr.length;
        int m = arr[0].length;
       
        if(rows>=n || cols>=m) return Integer.MAX_VALUE;
         if(rows == n-1 && cols==m-1)return arr[rows][cols];
        if(dp[rows][cols] != -1) return dp[rows][cols];

        int right =  traversal(arr , rows , cols+1);
        int down =  traversal(arr, rows+1 , cols);
        dp[rows][cols] =  arr[rows][cols] + Math.min(right , down);

        return dp[rows][cols];
    }
}