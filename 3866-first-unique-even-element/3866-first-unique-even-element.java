class Solution {
    public int firstUniqueEven(int[] arr) {
        int n = arr.length;
        Map<Integer , Integer> map = new HashMap<>();

        //fill the frequencies->
        for(int i = 0 ; i<n ;i++){
            map.put(arr[i] , map.getOrDefault(arr[i] , 0)+1);
        }

        //scan the array again and return->
        for(int i = 0 ; i<n ; i++){
            if(arr[i]%2==0 && map.get(arr[i])==1 ){
                return arr[i];
            }
        }
        return -1;
    }
}