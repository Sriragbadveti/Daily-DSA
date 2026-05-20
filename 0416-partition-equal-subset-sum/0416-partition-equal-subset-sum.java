class Solution {
    Boolean dp[][] ;
    public boolean canPartition(int[] nums) {
        

        //first find if the sum is even or odd
        int sum = 0;
        for(int i = 0 ; i<nums.length ; i++){
            sum+=nums[i];
        }
        dp = new Boolean[nums.length][(sum/2)+1];

        if(sum%2!=0) return false;
        
        return subsets(nums , sum/2 , 0);

    }

    public  boolean subsets(int nums[] , int target , int index){

        if(target==0) return true;

        if(index == nums.length) return false;

        if(dp[index][target] != null) return dp[index][target];

        boolean take = false;

       if(nums[index] <=target){
         take = subsets(nums , target-nums[index] , index+1);
       }

       boolean skip = subsets(nums , target , index+1);

       return dp[index][target] = take||skip;
    }
}