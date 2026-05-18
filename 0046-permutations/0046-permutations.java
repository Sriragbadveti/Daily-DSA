class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(nums , result , new ArrayList<>() , 0);
        return result;

    }

    public void backTrack(int[] nums , List<List<Integer>> result , List<Integer>path , int index ){

        if(path.size()==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0 ; i<nums.length ; i++){
            if(!path.contains(nums[i])){
                path.add(nums[i]);
                backTrack(nums , result , path , index+1);
                path.remove(path.size()-1);
            }
        }
    }
}