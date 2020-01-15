
class BackspaceCompare {

  public static boolean compare(String str1, String str2) {
    // TODO: Write your code here
    int index1 = str1.length() - 1, index2 = str2.length() - 1;
    while (index1 >= 0 || index2 >= 0) {
      
      int p1 = getNextValidCharacter(str1, index1);
      int p2 = getNextValidCharacter(str2, index2);

      if (p1 < 0 && p2 < 0) {
        return true; //end of both strings
      }

      if (p1 < 0 || p2 < 0) {
        return false; //end of one string
      }

      if (str1.charAt(p1) != str2.charAt(p2)) {
        return false;
      }

      index1 = p1 - 1;
      index2 = p2 - 1;
    }

    return true;
  }

  private static int getNextValidCharacter(String str, int index) {
    int backspaceCount = 0;
    while (index >= 0) {
      char c = str.charAt(index);
      if (c == '#') {
        backspaceCount++;
      } else if (backspaceCount > 0) {
        backspaceCount--;
      } else {
        break;
      }

      index--;
    }

    return index;
  }
}
