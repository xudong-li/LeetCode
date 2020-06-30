class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = - N;
        }
        
        return fastPower(x, N);
    }
    
    private double fastPower(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double half = fastPower(x, N / 2);
        if (N % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}