class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        //so the approach in this question would be to find the earliest finish time possible on land so that we have more options going further and vice versa
       return Math.min(
            calFinishTime(landStartTime,landDuration,waterStartTime,waterDuration),
            calFinishTime(waterStartTime,waterDuration,landStartTime,landDuration)
        );
    }

    private int calFinishTime(int arr1[] , int arr2[] , int arr3[] , int arr4[]){

        //first find the earliest finishing time
        int minimize = Integer.MAX_VALUE;
        for(int i = 0 ; i<arr1.length ; i++){
            minimize = Math.min(minimize , arr1[i]+arr2[i]);
        }

        //now using that try out all the combinations for the water side
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i<arr3.length ; i++){
            ans = Math.min(ans , Math.max(minimize , arr3[i])+arr4[i]);
        }

        return ans;
    }
}