class Solution {

    public boolean canFinish(int numCourses, int[][] arr) {

        int n = numCourses;

        // Build adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add directed edges
        for (int[] edge : arr) {

            int course = edge[0];
            int pre = edge[1];

            graph.get(pre).add(course);
        }

        // Visited arrays
        boolean[] visited = new boolean[n];
        boolean[] path = new boolean[n];

        // Check every component
        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                if (dfs(i, visited, path, graph)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean dfs(
        int u,
        boolean[] visited,
        boolean[] path,
        ArrayList<ArrayList<Integer>> graph
    ) {

        visited[u] = true;
        path[u] = true;

        for (int node : graph.get(u)) {

            if (!visited[node]) {

                if (dfs(node, visited, path, graph)) {
                    return true;
                }

            } else if (path[node]) {

                return true;
            }
        }

        // Backtracking
        path[u] = false;

        return false;
    }
}