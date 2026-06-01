class Solution {
    public boolean partitionArray(int[] arr, int k) {
        int n = arr.length;

        Map<Integer , Integer> map = new HashMap<>();

        if(n%k!=0) return false;
         int groups = n / k;

        for(int i = 0 ; i<n ; i++){

            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if (map.get(arr[i]) > groups) {
                return false;
            }
        }
        

        return true;

    }
}