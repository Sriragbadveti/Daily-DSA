class Solution {
    public int minFlipsMonoIncr(String s) {
         int onesSeen = 0;
        int flips = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '1') {
                onesSeen++;
            } else {

                // Option 1: flip this 0 to 1
                // Option 2: flip all previous 1s to 0
                flips = Math.min(flips + 1, onesSeen);
            }
        }

        return flips;
    }
}