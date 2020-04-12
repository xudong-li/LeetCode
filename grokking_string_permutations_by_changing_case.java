import java.util.*;

class LetterCaseStringPermutation {

  public static List<String> findLetterCaseStringPermutations(String str) {
    List<String> permutations = new ArrayList<>();
    // TODO: Write your code here
    helper(str.toCharArray(), 0, permutations);
    return permutations;
  }

  private static void helper(char[] chars, int index, List<String> permutations) {
    if (index == chars.length) {
      permutations.add(new String(chars));
      return;
    }

    if (chars[index] >= '0' && chars[index] <= '9') {
      helper(chars, index + 1, permutations);
      return;
    }

    chars[index] = Character.toLowerCase(chars[index]);
    helper(chars, index + 1, permutations);

    chars[index] = Character.toUpperCase(chars[index]);
    helper(chars, index + 1, permutations);

    return;
  }

  public static void main(String[] args) {
    List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
    System.out.println(" String permutations are: " + result);

    result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
    System.out.println(" String permutations are: " + result);
  }
}
