class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] p = {p1, p2, p3, p4};
        // sort the points based on x value;
        Arrays.sort(p, (a1, a2) -> a1[0] == a2[0] ? a1[1] - a2[1] : a1[0] - a2[0]);
        
        //return true if all for sides are the same length and diag is also the same length
        return (calculateDist(p[0], p[1]) == calculateDist(p[1], p[3]) && calculateDist(p[1], p[3]) == calculateDist(p[3], p[2]) && calculateDist(p[3], p[2]) == calculateDist(p[2], p[0]) && calculateDist(p[0], p[3]) == calculateDist(p[1], p[2]) && calculateDist(p[0], p[1]) != 0);
    }
    
    private int calculateDist(int[] p1, int[] p2) {
        return (p2[1] - p1[1]) * (p2[1] - p1[1]) + (p2[0] - p1[0]) * (p2[0] - p1[0]);
    }
}