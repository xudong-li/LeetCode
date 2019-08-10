class Solution {
    public boolean isMatch(String s, String p) {
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        
        boolean[][] dp = new boolean[ss.length + 1][pp.length + 1];
        
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                // "" matches "", so it is true;
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                
                // "" pattern cannot match any s.
                if (j == 0) {
                    dp[i][j] = false;
                    continue;
                }
                
                //set the value to false by default
                dp[i][j] = false;
                
                //if pattern is not a star, and it is '.' or s and p have the same char,
                //then it is a match.
                if (pp[j - 1] != '*') {
                    if (i > 0 && (pp[j - 1] == '.' || pp[j - 1] == ss[i - 1])) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    // 0 matches, i.e. b = ba*
                    if (j > 1) {
                        dp[i][j] = dp[i][j - 2];
                    }
                    //1 or more matches
                    if (i > 0 && j > 1 && (pp[j - 2] == '.' || pp[j - 2] == ss[i - 1])) {
                        dp[i][j] = (dp[i][j - 2] || dp[i - 1][j]);
                    }
                }
                
            }
        }
        
        return dp[dp.length - 1][dp[0].length - 1];
    }
}