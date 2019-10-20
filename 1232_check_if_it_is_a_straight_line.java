class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        double slop = (double)(coordinates[1][1] - coordinates[0][1]) / (double)(coordinates[1][0] - coordinates[0][0]);
        for (int i = 2; i < coordinates.length; i++) {
            double temp = (double)(coordinates[i][1] - coordinates[i-1][1]) / (double)(coordinates[i][0] - coordinates[i-1][0]);
            if (temp != slop) {
                return false;
            }                                                          
        }
        
        return true;
    }
}