import java.util.*;

class Solution {
    public long maximizeSum(int[] nums, int k) {

        long sum = 0;
        long[] differences = new long[nums.length];

        PriorityQueue<Long> maxHeap =
            new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            char[] digits = String.valueOf(nums[i]).toCharArray();

            Arrays.sort(digits);

            long maxNum = 0;

            for (int j = digits.length - 1; j >= 0; j--) {
                maxNum = maxNum * 10 + (digits[j] - '0');
            }

            differences[i] = maxNum - nums[i];

            maxHeap.offer(differences[i]);
        }

        for (int i = 0; i < k; i++) {
            sum += maxHeap.poll();
        }

        return sum;
    }
}