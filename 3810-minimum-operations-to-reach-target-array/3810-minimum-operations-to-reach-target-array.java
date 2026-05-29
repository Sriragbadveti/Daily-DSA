class Solution {
    public int minOperations(int[] nums, int[] target) {
        
       HashSet<Integer> set = new HashSet<>();
       int count = 0;

        for(int i = 0; i<nums.length ; i++){

            if(nums[i] == target[i]) continue;
            else{
                if(set.contains(nums[i]))continue;
                else{
                    set.add(nums[i]);
                    count++;
                }
            }

        }
        return count;
    }
}