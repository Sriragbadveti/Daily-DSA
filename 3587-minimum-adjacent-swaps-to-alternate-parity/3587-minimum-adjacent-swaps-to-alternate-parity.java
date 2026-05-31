class Solution {
    public int minSwaps(int[] nums) {

        int n = nums.length;

        List<Integer> evenPos = new ArrayList<>();
        List<Integer> oddPos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                evenPos.add(i);
            } else {
                oddPos.add(i);
            }
        }

        int evenCount = evenPos.size();
        int oddCount = oddPos.size();

        if (Math.abs(evenCount - oddCount) > 1) {
            return -1;
        }

        long ans = Long.MAX_VALUE;

        // Pattern: E O E O ...
        if (evenCount >= oddCount) {
            ans = Math.min(ans, calculate(evenPos, 0));
        }

        // Pattern: O E O E ...
        if (oddCount >= evenCount) {
            ans = Math.min(ans, calculate(oddPos, 0));
        }

        return (int) ans;
    }

    private long calculate(List<Integer> positions, int start) {

        long swaps = 0;

        for (int i = 0; i < positions.size(); i++) {

            int targetPos = start + 2 * i;

            swaps += Math.abs(positions.get(i) - targetPos);
        }

        return swaps;
    }
}