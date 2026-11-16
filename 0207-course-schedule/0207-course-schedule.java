
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int n = numCourses;

        // 1. Build adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // prerequisite -> course
        for (int[] edge : prerequisites) {
            int course = edge[0];
            int pre = edge[1];

            graph.get(pre).add(course);
        }

        // 2. Calculate indegree
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            for (int neighbour : graph.get(i)) {
                indegree[neighbour]++;
            }
        }

        // 3. Add all nodes with indegree 0
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // 4. Process nodes using BFS
        int count = 0;

        while (!queue.isEmpty()) {

            int node = queue.poll();
            count++;

            for (int neighbour : graph.get(node)) {

                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }

        // 5. Check whether all courses were processed
        return count == n;
    }
}
