import java.util.*;

class GeneralizedAbbreviation {

  public static List<String> generateGeneralizedAbbreviation(String word) {
    List<String> result = new ArrayList<String>();
    // TODO: Write your code here
    helper(word, "", 0, 0, result);
    return result;
  }

  private static void helper(String word, String curr, int pos, int count, List<String>result) {
    if (pos == word.length()) {
      if (count > 0) {
        curr += count;
      }
      result.add(curr);
    } else {
      helper(word, curr, pos + 1, count + 1, result);
      if (count > 0) {
        curr = curr + count + word.charAt(pos);
      } else {
        curr = curr + word.charAt(pos);
      }
      helper(word, curr, pos + 1, 0, result);
    }

  }

  public static void main(String[] args) {
    List<String> result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("BAT");
    System.out.println("Generalized abbreviation are: " + result);

    result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("code");
    System.out.println("Generalized abbreviation are: " + result);
  }
}
