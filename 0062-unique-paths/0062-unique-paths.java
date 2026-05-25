class Solution {
    int dp [][];
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
       return traversal(0 , 0 , m ,n);
    }

    public int traversal(int rows , int cols , int m ,  int n){

        //base case
        if(rows==m-1 || cols==n-1)return 1;

        if(rows>=m || cols>=n) return 0;


        //check cache
        if(dp[rows][cols] != -1)return dp[rows][cols];

        int right = traversal(rows+1 , cols , m , n);
        int down = traversal(rows , cols+1 , m , n);

        dp[rows][cols] = right+down;

        return dp[rows][cols];
    }
}