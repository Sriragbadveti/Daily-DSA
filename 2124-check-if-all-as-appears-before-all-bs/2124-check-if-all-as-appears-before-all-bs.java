class Solution {
    public boolean checkString(String s) {
        int n = s.length();
        int index = 0;
        while (index < n && s.charAt(index) != 'b') {
            index++;
        }

        while (index < n) {
            if (s.charAt(index) == 'a')return false;

            index++;
                
            
        }

        return true;
    }
}