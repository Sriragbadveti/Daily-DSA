class Solution {
    public boolean checkSubarraySum(int[] arr, int k) {
        
        // we could have used the standard mathematical substitution logicc but since here the multiple of k should be there we ll store the prefSum % k's remainder in the map

        int n = arr.length;
        int pref = 0;
        Map<Integer , Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i = 0 ;i<n ; i++){
            pref+=arr[i];

            int rem = pref%k;

            if(map.containsKey(rem)){
                //check if the size is greater than or equal to 2
                if( i - map.get(rem) >= 2){
                    return true;
                }

            }else{
                map.put(rem ,i);
            }
        }
        return false;
    }
}