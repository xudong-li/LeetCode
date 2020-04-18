class NextLetter {

  public static char searchNextLetter(char[] letters, char key) {
    // TODO: Write your code here
    int left = 0, right = letters.length - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (letters[mid] <= key) {
        left = mid;
      } else {
        right = mid;
      }
    }

    if (letters[left] > key) {
      return letters[left];
    }

    if (letters[right] > key) {
      return letters[right];
    }

    return letters[0];
  }

  public static void main(String[] args) {
    System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
    System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
    System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
    System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
  }
}