class Solution {

    int n;

    public int findCircleNum(int[][] isConnected) {

        n = isConnected.length;

        boolean[] visited = new boolean[n];

        int count = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                count++;

                dfs(i, visited, isConnected);
            }
        }

        return count;
    }

    public void dfs(int u, boolean[] visited, int[][] isConnected) {

        visited[u] = true;

        for (int i = 0; i < n; i++) {

            if (isConnected[u][i] == 1 && !visited[i]) {

                dfs(i, visited, isConnected);
            }
        }
    }
}