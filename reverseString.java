public class Solution {
  public String reverse(String input) {
    char[] array = input.toCharArray();
    int i = 0;
    int j = input.length() - 1;
    while (i < j) {
      swap(array, i++, j--);
    }
    return new String(array);
  }
  
  public void swap(char[] array, int i, int j) {
    char temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  //recursion
  public String reverseRecursion(String input) {
    if (input.length() <= 1) return input;
    char[] array = input.toCharArray();
    reverse(array, 0, array.length - 1);
    return new String(array);
  }
  
  public void reverse(char[] array, int start, int end) {
    if (start >= end) return;
    reverse(array, start+1, end-1);
    swap(array, start, end);
  }
}
