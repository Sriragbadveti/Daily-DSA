class Solution {
    
    public int maxLength(List<String> arr) {
        int n = arr.size();
      
        String temp = "";
        return traversal(arr , n , 0 , temp);
    }

    private int traversal(List<String> arr , int n , int index , String temp ){

        //base case
        if(index>=n) return temp.length();

         int exclude = traversal(arr, n, index + 1, temp);

        int include = 0;
        if (hasDuplicate(temp, arr.get(index))) {
            include = traversal(arr, n, index + 1, temp + arr.get(index));
        }

        return Math.max(include, exclude);
    }

   private boolean hasDuplicate(String temp, String check) {

        Set<Character> set = new HashSet<>();

        // store temp chars
        for (int i = 0; i < temp.length(); i++) {
            set.add(temp.charAt(i));
        }

        // FIX 2: check duplicates inside check itself
        Set<Character> curr = new HashSet<>();
        for (int i = 0; i < check.length(); i++) {

            char ch = check.charAt(i);

            if (curr.contains(ch))
                return false;

            curr.add(ch);

            if (set.contains(ch))
                return false;
        }

        return true;
    }
}