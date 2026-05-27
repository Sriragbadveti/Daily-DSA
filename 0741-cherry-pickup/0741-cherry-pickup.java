class Solution {
    int dp[][][][];

    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m + 1][n + 1][m + 1][n + 1];

        for (int arr1[][][] : dp) {

            for (int arr2[][] : arr1) {

                for (int arr3[] : arr2) {

                    Arrays.fill(arr3, -1);
                }
            }
        }

       
        return Math.max(0,
                traversal(grid, 0, 0, 0, 0));
    }

    public int traversal(int grid[][], int r1, int c1, int r2, int c2) {

        int m = grid.length;
        int n = grid[0].length;
        if (r1 >= m || c1 >= n ||
                r2 >= m || c2 >= n) {
            return -1000000;
        }

        //base case
        // IMPORTANT:
        // both travelers must take same steps
        if (r1 + c1 != r2 + c2) {
            return -1000000;
        }

        // invalid thorn cells
        if (grid[r1][c1] == -1 ||
                grid[r2][c2] == -1) {
            return -1000000;
        }

        // reached destination
        if (r1 == m - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }

        if (dp[r1][c1][r2][c2] != -1)
            return dp[r1][c1][r2][c2];

     

        //now if both land up on the same cell just pick the cherries once
        int cherries = 0;

        if (r1 == r2 && c1 == c2) {
            cherries = grid[r1][c1];

            

        } else {

            cherries += grid[r1][c1] + grid[r2][c2];

        }

        //now liste the 4 possibilities
        int p1 = traversal(grid, r1 + 1, c1, r2 + 1, c2);
        int p2 = traversal(grid, r1 + 1, c1, r2, c2 + 1);
        int p3 = traversal(grid, r1, c1 + 1, r2, c2 + 1);
        int p4 = traversal(grid, r1, c1 + 1, r2 + 1, c2);

        dp[r1][c1][r2][c2] = cherries + Math.max(Math.max(p1, p2), Math.max(p3, p4));
        return dp[r1][c1][r2][c2];
    }

}