class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        return x == reverseInt(x);
    }
    
    private int reverseInt(int x) {
        int reversed = 0;
        while (x != 0) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return reversed;
    }
}