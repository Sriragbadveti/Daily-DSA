
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        ArrayList<Integer> res = new ArrayList<>();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            int course = edge[0];
            int pre = edge[1];

            graph.get(pre).add(course);
        }

        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            for (int neighbour : graph.get(i)) {
                indegree[neighbour]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            res.add(node);

            for (int neighbour : graph.get(node)) {
                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }

        if (count != n) return new int[0];

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}
