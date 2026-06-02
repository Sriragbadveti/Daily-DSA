class Solution {
    int dp[][];
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        dp = new int[n+1][d+1];
        for(int row[] : dp){
            Arrays.fill(row , -1);
        }
        if(n<d) return -1;
        return traversal(jobDifficulty , d , n , 0);
    }

    private int traversal(int arr[] , int d , int n , int index){

        //base case
        if(d==1){
            int maxD = arr[index];
            for(int i = index ; i<n ; i++){
                maxD = Math.max(maxD , arr[i]);
            }
            return maxD;
        }

        //check cache

        if(dp[index][d] != -1) return dp[index][d];


        int maxD = arr[index];
        int finalResult = Integer.MAX_VALUE;

        for(int i = index ; i<=n-d ; i++){
            
            maxD = Math.max(maxD , arr[i]);
            int result = maxD + traversal(arr , d-1 , n , i+1 );
            finalResult = Math.min(result , finalResult); 
        }

        dp[index][d]= finalResult;
        return dp[index][d];
    }
}