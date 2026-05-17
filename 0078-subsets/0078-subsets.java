class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        

        //this code is purely recursive based solution without any loops

        List<List<Integer>> result = new ArrayList<>();
        findSubsets(nums , result , new ArrayList<>() , 0);
        return result;
    }

    public void findSubsets(int[] nums , List<List<Integer>> result , List<Integer>path , int index ){

        //base case
        if(index==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }


        //if we are not picking the element
        findSubsets(nums , result , path , index+1);

        //if we are picking the element
        path.add(nums[index]);
        findSubsets(nums , result , path , index+1);
        //and after we pick if it is not correct then remove/backtrack the last element in the path
        path.remove(path.size()-1);
    }
}