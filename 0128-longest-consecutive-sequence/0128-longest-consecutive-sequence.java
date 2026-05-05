class Solution {
    public int longestConsecutive(int[] arr) {

        Map<Integer, Boolean> present = new HashMap<>();
        Map<Integer, Boolean> checked = new HashMap<>();

        //first push all the values into the present hashmap
        for (int i = 0; i < arr.length; i++) {
            present.put(arr[i], true);
        }

        //now start the main process
        int length = 0;
        int longestLength = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!checked.containsKey(arr[i]) && !present.containsKey(arr[i]-1 )) {

                int curr = arr[i];
                while (present.containsKey(curr)) {
                    checked.put(arr[i], true);
                    length++;
                    curr++;
                }
                longestLength = Math.max(longestLength, length);
                length = 0;
            }else if(checked.containsKey(arr[i]) ) continue;
        }
        return longestLength;

    }
}