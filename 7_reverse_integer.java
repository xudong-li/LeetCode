class Solution {
    public int reverse(int x) {
        String intToString = Integer.toString(x);
        int result = 0;
        if (intToString.charAt(0) == '-') {
            StringBuilder sb = new StringBuilder(intToString.substring(1, intToString.length()));
            String reversedString = '-' + sb.reverse().toString();
            try{
                result = Integer.parseInt(reversedString);
            } catch (NumberFormatException e) {
                return 0;
            }
            
            
        } else {
            StringBuilder sb = new StringBuilder(intToString);
            String reversedString = sb.reverse().toString();
            try{
                result = Integer.parseInt(reversedString);
            } catch (NumberFormatException e) {
                return 0;
            }
        }
        
        return result;
    }
}


class Solution {
    public int reverse(int x) {
        int reversed_num = 0;
        while (x != 0) {
            int temp = reversed_num * 10 + x % 10;
            x = x / 10;
            if (temp / 10 != reversed_num) { //check for overflow
                reversed_num = 0;
                break;
            }
            reversed_num = temp;
        }
        return reversed_num;
    }
}