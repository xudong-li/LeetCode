/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    
    private int n;
    
    public int findCelebrity(int n) {
        this.n = n;
        int celebrityCandidate = 0;
        
        for (int i = 0; i < n; i++) {
            if (knows(celebrityCandidate, i)) {
                celebrityCandidate = i;
            }
        }
        
        if (isCelebrity(celebrityCandidate)) {
            return celebrityCandidate;
        }
        return -1;
    }
    
    private boolean isCelebrity(int i) {
        for (int j = 0; j < n; j++) {
            if (i == j) continue;
            if (knows(i, j) || !knows(j, i)) {
                return false;
            }
        }
        
        return true;
    }
}