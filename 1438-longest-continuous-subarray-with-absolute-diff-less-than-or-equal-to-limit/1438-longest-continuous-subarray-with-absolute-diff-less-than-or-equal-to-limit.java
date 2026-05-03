import java.util.*;

class Solution {
    public int longestSubarray(int[] arr, int limit) {

        Deque<Integer> maxDec = new ArrayDeque<>();
        Deque<Integer> minDec = new ArrayDeque<>();

        int left = 0;
        int res = 0;

        for (int right = 0; right < arr.length; right++) {

            // maintain max deque (decreasing)
            while (!maxDec.isEmpty() && arr[maxDec.peekLast()] < arr[right]) {
                maxDec.pollLast();
            }

            // maintain min deque (increasing)
            while (!minDec.isEmpty() && arr[minDec.peekLast()] > arr[right]) {
                minDec.pollLast();
            }

            maxDec.addLast(right);
            minDec.addLast(right);

            // shrink window
            while (arr[maxDec.peekFirst()] - arr[minDec.peekFirst()] > limit) {

                if (maxDec.peekFirst() == left)
                    maxDec.pollFirst();
                if (minDec.peekFirst() == left)
                    minDec.pollFirst();

                left++;
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}