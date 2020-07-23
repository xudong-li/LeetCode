class Solution {
    public boolean confusingNumber(int N) {
        int[] rotated = {0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
        char[] num = String.valueOf(N).toCharArray();
        
        StringBuilder sb = new StringBuilder();
        for (int i = num.length - 1; i >= 0; i--) {
            if (rotated[num[i] - '0'] == -1) {
                return false;
            }
            sb.append(rotated[num[i] - '0']);
        }
        int result = Integer.parseInt(sb.toString());
        return result != N;
    }
}