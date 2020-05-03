import java.util.*;

class Entry {
  int key;
  int value;

  public Entry(int key, int value) {
    this.key = key;
    this.value = value;
  }
}

class KClosestElements {

  // Time Complexity: log(n) + K;
  public static List<Integer> findClosestElements(int[] arr, int K, Integer X) {
    List<Integer> result = new LinkedList<>();
    // TODO: Write your code here
    int target = binearySearch(arr, X);
    result.add(arr[target]);

    int left = target - 1, right = target + 1;
    while (result.size() < K) {
      while (result.size() < K && left >= 0 && right < arr.length) {
        if (X - arr[left] < arr[right] - X) {
          result.add(0, arr[left]);
          left--;
        } else {
          result.add(arr[right]);
          right++;
        }
      }
      if (result.size() < K && left >= 0) {
        result.add(0, arr[left]);
        left--;
      }
      if (result.size() < K && right < arr.length) {
        result.add(arr[right]);
        right++;
      }
    }
    return result;
  }

  private static int binearySearch(int[] arr, int X) {
    int left = 0, right = arr.length - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] == X) {
        return mid;
      } else if (arr[mid] < X) {
        left = mid;
      } else {
        right = mid;
      }
    }

    if (X - arr[left] < arr[right] - X) {
      return left;
    } else {
      return right;
    }
  }
  public static void main(String[] args) {
    List<Integer> result = KClosestElements.findClosestElements(new int[] { 5, 6, 7, 8, 9 }, 3, 7);
    System.out.println("'K' closest numbers to 'X' are: " + result);

    result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 6);
    System.out.println("'K' closest numbers to 'X' are: " + result);

    result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 10);
    System.out.println("'K' closest numbers to 'X' are: " + result);
  }
}
