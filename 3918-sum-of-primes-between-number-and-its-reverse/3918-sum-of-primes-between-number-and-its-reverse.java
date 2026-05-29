class Solution {
    public int sumOfPrimesInRange(int n) {

        int rev = 0;
        int original = n;

        while (n > 0) {
            int digit = n % 10;
            rev = rev * 10 + digit;
            n = n / 10;
        }

        //since now the number is revered we can start the simulation from the original number to the revered number ->

        int min = Math.min( original , rev);
        int max = Math.max(original , rev);
        int sum = 0;

        for(int i = min ; i<=max; i++){
            if(isPrime(i)) sum+=i;
        }

        return sum;
    }
    public boolean isPrime(int num) {

        if (num < 2) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {

            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}