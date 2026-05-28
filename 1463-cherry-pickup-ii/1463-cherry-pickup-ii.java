class Solution {
    int dp [][][];
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        dp = new int[m][n][n];

        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }
        return traversal(grid , 0 , 0 , n-1);
    }

    public int traversal(int grid[][] , int row , int c1 , int c2){

        int m = grid.length;
        int n = grid[0].length;

        //base cases->

        if(row>=m || c1>=n || c2>=n || c1<0 || c2<0)return Integer.MIN_VALUE;

        //check cache

        if(dp[row][c1][c2] != -1) return dp[row][c1][c2];

        //if both are on the same column
        int cherries = 0;
        if(c1==c2){
            cherries=grid[row][c1];
        }else{
            cherries = grid[row][c1] + grid[row][c2];
        }

        if(row == m-1)return cherries;
        int max = 0;
        //now movements
        for(int d1 = -1 ; d1<=1 ;d1++){
            for(int d2 = -1 ; d2<=1 ; d2++){
                int next = traversal(grid , row+1 , c1+d1 ,c2+d2);
                max = Math.max(max , next);
            }
        }

        return dp[row][c1][c2] = cherries+max;
    }
}