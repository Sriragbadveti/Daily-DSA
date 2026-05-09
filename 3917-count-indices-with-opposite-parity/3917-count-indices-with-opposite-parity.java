class Solution {
    public int[] countOppositeParity(int[] arr) {
        int n = arr.length;
        int res[] = new int[n];
        boolean isEven = false;
        
        for(int i = 0 ; i<n ; i++){
            int count = 0;
            if(arr[i] %2==0){
                isEven = true;
            }else{
                isEven = false;

            }

            for(int j = i+1 ; j<n; j++){
                
                if(isEven){
                    if(arr[i] != arr[j] && arr[j]%2 == 1){
                        count++;
                    }
                }else{
                    if(arr[i]!=arr[j] && arr[j]%2 == 0){
                        count++;
                    }
                }

                res[i] = count;

                
            }
        }
        return res;
    }
}