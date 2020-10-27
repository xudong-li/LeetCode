class CustomComparator implements Comparator<String> {
    @Override
    public int compare(String a, String b) {
        String order1 = a + b; //102
        String order2 = b + a; //210
        //System.out.println(order2.compareTo(order1));
        return order2.compareTo(order1); // -1
    }
}

class Solution {
    public String largestNumber(int[] nums) {
        String[] numsStrings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsStrings[i] = String.valueOf(nums[i]);
        }
        
        // sort the string with custom comparator
        Arrays.sort(numsStrings, new CustomComparator());
        
        if (numsStrings[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for (String numsString : numsStrings) {
            sb.append(numsString);
        }
        
        return sb.toString();
    }
}