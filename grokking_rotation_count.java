class RotationCountOfRotatedArray {

  public static int countRotations(int[] arr) {
   // TODO: Write your code here
   int start = 0, end = arr.length - 1;
   if (arr[start] < arr[end]) {
     return 0;
   }
   while (start + 1 < end) {
     int mid = start + (end - start) / 2;
     // arr is always increasing except 1 point
     if (arr[mid] > arr[start]) {
       start = mid;
     } else {
       end = mid;
     }
   }

   if (arr[start] > arr[end]) {
     return end;
   } else {
     return start;
   }
  }

  public static void main(String[] args) {
    System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 10, 15, 1, 3, 8 }));
    System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 4, 5, 7, 9, 10, -1, 2 }));
    System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 1, 3, 8, 10 }));
  }
}
