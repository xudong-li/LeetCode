import java.util.*;

class GenerateParentheses {

  public static List<String> generateValidParentheses(int num) {
    List<String> result = new ArrayList<String>();
    // TODO: Write your code here
    helper(result, "", num, num);
    return result;
  }

  // left indicates how many parentheses left on left side
  private static void helper(List<String> result, String curr, int left, int right) {
    if (left == 0 && right == 0) {
      result.add(curr);
      return;
    }

    if (left > 0) {
      helper(result, curr + "(", left - 1, right);
    }

    if (right > 0 && right > left) {
      helper(result, curr + ")", left, right - 1);
    }
  }
  public static void main(String[] args) {
    List<String> result = GenerateParentheses.generateValidParentheses(2);
    System.out.println("All combinations of balanced parentheses are: " + result);

    result = GenerateParentheses.generateValidParentheses(3);
    System.out.println("All combinations of balanced parentheses are: " + result);
  }
}
