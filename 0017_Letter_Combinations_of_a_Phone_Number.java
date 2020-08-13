// class Solution {
//     List<String> result = new ArrayList<>();
//     List<String> letters = Arrays.asList("abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");
    
//     public List<String> letterCombinations(String digits) {
//         if (digits.length() != 0) {
//             helper("", digits);
//         }
//         return result;
//     }
    
//     private void helper(String combination, String nextDigits) {
//         if (nextDigits.length() == 0) {
//             result.add(combination);
//         } else {
//             Character digit = nextDigits.charAt(0);
//             String letter = letters.get(digit - '0' - 2);
//             for (int i = 0; i < letter.length(); i++) {
//                 Character curr = letters.get(digit - '0' - 2).charAt(i);
//                 helper(combination + curr, nextDigits.substring(1));
//             }
//         }
//     }
// }

public class Solution {
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<String>();
        if(digits == null || digits.length() == 0) 
            return result;
        
        combination("", digits, 0, result);
        return result;
    }

    private void combination(String prefix, String digits, int index, List<String> result) {
        if (index >= digits.length()) {
            result.add(prefix);
            return;
        }
        String letters = KEYS[(digits.charAt(index) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, index + 1, result);
        }
    }
}