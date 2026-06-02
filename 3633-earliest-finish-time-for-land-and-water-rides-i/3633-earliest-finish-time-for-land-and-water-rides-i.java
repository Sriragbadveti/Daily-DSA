class Solution {
    public int earliestFinishTime(int[] arr1, int[] arr2, int[] arr3, int[] arr4) {
        

        //this is going to be a bruteforce solution
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ;i<arr1.length ; i++){
            for(int j = 0 ; j<arr3.length ; j++){

                //from land->water
                int finishLand = arr1[i]+arr2[i];
                int landToWater = 0;
                if(finishLand<arr3[j]){
                    int diff = arr3[j]-finishLand;
                    landToWater = diff+finishLand+arr4[j];                    
                }else{
                    landToWater = finishLand+arr4[j];
                }


                int finishWater = arr3[j]+arr4[j];
                int waterToLand = 0;

                if(finishWater<arr1[i]){
                    int diff = arr1[i] - finishWater;
                    waterToLand = diff+finishWater+arr2[i];
                }else{
                    waterToLand = finishWater+arr2[i];
                }

                ans = Math.min(ans , Math.min(landToWater , waterToLand));

            }
        }

        return ans;
    }
}