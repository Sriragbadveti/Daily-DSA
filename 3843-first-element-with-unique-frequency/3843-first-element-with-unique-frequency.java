class Solution {
    public int firstUniqueFreq(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> mp1 = new HashMap<>();
        Map<Integer, Integer> mp2 = new HashMap<>();

        for (int i = 0; i < n; i++) {
            mp1.put(nums[i], mp1.getOrDefault(nums[i], 0) + 1);
        }

        //now loop over the mp1
        for (Map.Entry<Integer, Integer> entry : mp1.entrySet()) {

            int freq = entry.getValue();

            mp2.put(
                    freq,
                    mp2.getOrDefault(freq, 0) + 1);
        }

        //now the final loopp to check the first unique frequency
        for(int i = 0 ; i<n ; i++){
            int freq = mp1.get(nums[i]);

            if(mp2.get(freq)==1)return nums[i];
        }
        return -1;
    }
}