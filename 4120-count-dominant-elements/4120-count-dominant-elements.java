class Solution {
    public int countDominantElements(int[] nums) {
        // Intuition: compute neighbor average for every index
        int n = nums.length;
        int r = 0;
        for (int i = 0; i < n; i++) {
            int total = 0;
            int cnt = 0;
            if (i > 0) {
                total += nums[i - 1];
                cnt++;
            }
            if (i < n - 1) {
                total += nums[i + 1];
                cnt++;
            }
            // No neighbors, always dominant
            if (cnt == 0) {
                r++;
                continue;
            }
            if (nums[i] >= (double) total / cnt) r++;
        }
        return r;
    }
}