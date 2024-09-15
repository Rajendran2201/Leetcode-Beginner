class Solution {
    public int countVowelStrings(int n) {
        return (int)findCombination(n+4, 4);
    }
    
    // Function to calculate combinations nCr
    public long findCombination(int n, int r) {
        if (r > n || r < 0) {
            return 0;
        }

         if (r == 0 || r == n) {
            return 1; // C(n, 0) or C(n, n) is 1
        }

         long result = 1;

        // Calculate nCr using the multiplicative formula to avoid overflow
        for (int i = 0; i < r; i++) {
            result *= (n - i);
            result /= (i + 1);
        }

        return result;
    }

    // Function to calculate factorial
    public long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}