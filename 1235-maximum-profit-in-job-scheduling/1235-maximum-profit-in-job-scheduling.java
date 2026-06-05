class Solution {
    int dp[];
    int n ;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<List<Integer>> jobs = new ArrayList<>();

        for (int i = 0; i < startTime.length; i++) {

            List<Integer> job = new ArrayList<>();

            job.add(startTime[i]);
            job.add(endTime[i]);
            job.add(profit[i]);

            jobs.add(job);
        }
        jobs.sort((a, b) -> a.get(0) - b.get(0));

        n = startTime.length;
        dp = new int[n+1];
        Arrays.fill(dp,-1);

        return traversal(jobs , 0);
    }


    private int traversal(List<List<Integer>>jobs , int index){

        //base case
        if(index>=n)return 0;

        //check cache
        if(dp[index]!=-1)return dp[index];

        int skip = traversal(jobs , index+1);
        int nextIndex = findIndex(jobs , jobs.get(index).get(1) , index+1);
        int take = jobs.get(index).get(2) + traversal(jobs , nextIndex);

        dp[index] = Math.max(skip , take);
        return dp[index];
    }

    private int findIndex(List<List<Integer>> jobs , int target , int start){

        int end = n-1;
        int result = n;
        while(start<=end){

            int middle = start + (end-start)/2;
            if(jobs.get(middle).get(0) >= target){
                result = middle;
                end = middle-1;
            }else{
                start = middle+1;
            }
        }
        return result;
    }
}