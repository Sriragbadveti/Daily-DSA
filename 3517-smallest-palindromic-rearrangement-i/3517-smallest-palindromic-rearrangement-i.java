class Solution {
    public String smallestPalindrome(String s) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        //first add all the frequencies into the treemap
        int n = s.length();
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        char middle = '#' ;
        //first we build the left half of the string
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

            char ch = entry.getKey();
            int freq = entry.getValue();
            if (freq % 2 != 0)
                middle = ch;
            for (int i = 0; i < freq / 2; i++) {
                sb.append(ch);
            }

        }

        //now build the entire string
        String left = sb.toString();
        String middleo = String.valueOf(middle);
        String right = new StringBuilder(left).reverse().toString();

        if(middle == '#') return left+right;

        return left + middleo + right;

    }
}