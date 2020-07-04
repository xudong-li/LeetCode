class Solution {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int[] prefixSum = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + A[i];
        }
        int LMax = prefixSum[L];
        int MMax = prefixSum[M];
        int result = 0;
        
        for (int i = L + M; i <= A.length; i++) {
            LMax = Math.max(LMax, prefixSum[i - M] - prefixSum[i - M - L]);
            MMax = Math.max(MMax, prefixSum[i - L] - prefixSum[i - M - L]);
            result = Math.max(result, Math.max(LMax + prefixSum[i] - prefixSum[i - M], MMax + prefixSum[i] - prefixSum[i - L]));    
        }
        
        return result;
    }
}