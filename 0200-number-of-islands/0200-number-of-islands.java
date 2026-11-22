class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean [m][n];
        int count = 0;
        for(int i = 0 ; i<m ; i++){
            for(int j = 0 ; j<n ; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    count++;
                    dfs(grid , i , j , visited);
                }
            }
        }
        return count;
    }

    public void dfs(char grid[][] , int i , int j , boolean visited[][]){
        //base cases
        int m = grid.length;
        int n = grid[0].length;
        if(i<0 || j<0 || i>=m || j>=n || visited[i][j] || grid[i][j] == '0' ){
            return;
        }

             visited[i][j] = true;
             dfs(grid, i + 1, j, visited);
        dfs(grid, i - 1, j, visited);
        dfs(grid, i, j + 1, visited);
        dfs(grid, i, j - 1, visited);
    }
}