class Solution {
    public long minimumTime(int[] arr, int totalTrips) {

        int min = Integer.MAX_VALUE;

        // Find the fastest bus
        for (int time : arr) {
            min = Math.min(min, time);
        }

        long low = 1;
        long high = (long) min * totalTrips;
        long result = high;

        while (low <= high) {

            long middle = low + (high - low) / 2;

            if (helper(middle, arr) >= totalTrips) {
                result = middle;
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return result;
    }

    private long helper(long middle, int[] arr) {

        long trips = 0;

        for (int time : arr) {
            trips += middle / time;
        }

        return trips;
    }
}