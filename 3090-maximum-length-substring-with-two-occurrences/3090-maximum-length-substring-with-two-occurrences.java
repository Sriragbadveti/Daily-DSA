class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        Map<Character , Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int result = Integer.MIN_VALUE;
        while(j<n){
            //first add to map
            char ch = s.charAt(j);
            map.put(ch , map.getOrDefault(ch , 0)+1);
            while(map.get(ch)>2){
                 char leftChar = s.charAt(i);
                map.put(leftChar, map.get(leftChar) - 1);
                i++;
            }
            result = Math.max(result , j-i+1);
            j++;
        }
        return result;
    }
}