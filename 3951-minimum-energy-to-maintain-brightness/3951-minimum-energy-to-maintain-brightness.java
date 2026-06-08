class Solution {
    public long minEnergy(int n, int brightness, int[][] intervals) {

        if(intervals == null || intervals.length == 0)return 0;

        Arrays.sort(intervals , (a,b)->Integer.compare(a[0] , b[0]));
       //here basically to calc the min buls we just need to divide by 3 and get the answer because one buld can illuminate 3 positions

       int minBulbs = (brightness + 2 )/3;

       ///now merge the intervals
       long totalTime = 0;
       int currStart = intervals[0][0];
       int currEnd = intervals[0][1];

       //now merge the intervals and if 2 or more exist calculate the total time uptill that point
       for(int i = 1; i<intervals.length ; i++){
        if(intervals[i][0] <= currEnd){
            currEnd = Math.max(currEnd , intervals[i][1]);
        }else{
            totalTime+=(currEnd - currStart +1L);
            currStart = intervals[i][0];
            currEnd = intervals[i][1];
        }

       }

       totalTime+=(currEnd-currStart+1L);

       return minBulbs * totalTime;
    
    }
}