class Solution {
    public long gcdSum(int[] arr) {
        int n = arr.length;
        int prefMax[] = new int[n];
        int prefixGcd[] = new int[n];
        int max = Integer.MIN_VALUE;

        //form the prefmax array
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            prefMax[i] = max;
        }

        //form the gcd array

        for (int i = 0; i < n; i++) {
            prefixGcd[i] = gcd(arr[i], prefMax[i]);
        }

        //sort the array

        Arrays.sort(prefixGcd);

        //now form pairs
        int i = 0;
        int j = prefixGcd.length - 1;
        long sum = 0;

        while (i < j) {
            sum += gcd(prefixGcd[i], prefixGcd[j]);
            i++;
            j--;
        }

        return sum;

    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
             a = b;
             b = temp;
        }
        return a;
    }
}