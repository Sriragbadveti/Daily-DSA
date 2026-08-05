class Solution {
    public int smallestDivisor(int[] arr, int threshold) {
        
        //find the max divisor in the array for search space
        int max = 0;
        for(int i = 0 ; i<arr.length ; i++){
            max = Math.max(max , arr[i]);
        }
        int result = 0;
      

        int low =1;
        int high = max;
        while(low<=high){
            int mid = (low+high)/2;
            int ans = helper(mid , arr , threshold);    
            if(ans<=threshold){
                result = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return result;
    }

    private int helper(int mid , int arr[] , int threshold){
        int ans = 0;
        for(int i =  0 ; i<arr.length ; i++){
            ans+=(arr[i]+mid-1)/mid;
        }
        return ans;
    }
}