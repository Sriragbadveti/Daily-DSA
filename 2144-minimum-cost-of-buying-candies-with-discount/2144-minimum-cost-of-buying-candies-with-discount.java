class Solution {
    public int minimumCost(int[] cost) {
        
        
        int j = cost.length-1;
        Arrays.sort(cost);
        int costi = 0;
        while(j>=0){
            costi += cost[j];
            
            j--;
            if(j>=0){
                costi+=cost[j];
            }
            j-=2;

          
        }

        return costi;

        
    }
}