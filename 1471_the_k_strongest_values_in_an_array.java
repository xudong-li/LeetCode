class Solution {
    public int[] getStrongest(int[] arr, int k) {
        //1. find the median
        Arrays.sort(arr);
        int median = arr[(arr.length - 1) / 2];
        
        int[] result = new int[k];
        
        int left = 0, right = arr.length - 1;
        
        for (int i = 0; i < result.length; i++) {
            if (Math.abs(arr[left] - median) > Math.abs(arr[right] - median)) {
                result[i] = arr[left];
                left++;
            } else if (Math.abs(arr[left] - median) == Math.abs(arr[right] - median)) {
                result[i] = arr[right];
                right--;
            } else {
                result[i] = arr[right];
                right--;
            }
        }
        
        return result;
    }
}