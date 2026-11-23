
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        // initialize and fill the color array with -1
        // -1 -> not visited
        // 0 -> group 1
        // 1 -> group 2

        ArrayList<Integer> color = new ArrayList<>();

        for(int i = 0; i < n; i++){
            color.add(-1);
        }

        // now start the dfs
        for(int i = 0; i < n; i++){
            if(color.get(i) == -1){
                if(dfs(graph, i, color, 0) == false) return false;
            }
        }

        return true;
    }

    public boolean dfs(int graph[][], int v,
                       ArrayList<Integer> color, int currColor){

        color.set(v, currColor);

        // now start exploring its connected nodes
        for(int neighbour : graph[v]){

            if(color.get(neighbour) == currColor) return false;

            if(color.get(neighbour) == -1){

                int colorOfV;

                if(color.get(v) == 0){
                    colorOfV = 1;
                } else {
                    colorOfV = 0;
                }

                if(dfs(graph, neighbour, color, colorOfV) == false) {
                    return false;
                }
            }
        }

        return true;
    }
}
