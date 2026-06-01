class Solution {
    int dp[][];
    public int calculateMinimumHP(int[][] dungeon) {
        
        int n = dungeon.length;
        int m = dungeon[0].length;
        dp = new int[n+1][m+1];
        for(int row[] : dp){
            Arrays.fill(row , -1);
        }
        return traversal(dungeon , 0 , 0);
    }

    private int traversal(int dungeon[][] , int i , int j){

         int n = dungeon.length;
            int m = dungeon[0].length;
        //base case
        if(i>=n || j>=m) return Integer.MAX_VALUE;

        if(i==n-1 && j==m-1){

            if(dungeon[i] [j] > 0)return 1;
            else return Math.abs(dungeon[i][j])+1;
        }

        if(dp[i][j] != -1)return dp[i][j];

        int right =  traversal(dungeon , i , j+1);
        int down =  traversal(dungeon , i+1 , j);
        int ans = Math.min(right , down)-dungeon[i][j];

      return dp[i][j] = (ans>0) ? ans : 1; 


    }
}