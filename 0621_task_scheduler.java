class Solution {
    public int leastInterval(char[] tasks, int n) {
        char[] counter = new char[26];
        int max = 0;
        int maxCount = 0;
        
        for (char task : tasks) {
            counter[task - 'A']++;
            if (max == counter[task - 'A']) {
                maxCount++;
            } else if (max < counter[task - 'A']) {
                maxCount = 1;
                max = counter[task - 'A'];
            }
        }
        
        // A, B, X, X, A, B, X, X, A, B
        int spacesCouldBeFilled = (max - 1) * (n - (maxCount - 1));
        int availableTasks = tasks.length - max * maxCount;
        int idles = Math.max(0, spacesCouldBeFilled - availableTasks);
        
        return tasks.length + idles;
        
    }
}