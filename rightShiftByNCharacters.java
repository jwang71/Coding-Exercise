public class Solution {
  public String rightShift(String input, int n) {
    if (input == null || input.length() == 0) return input;
    int len = input.length();
    n = n % len;
    
    char[] array = input.toCharArray();
    
    reverse(array, 0, len - n - 1);
    reverse(array, len - n, len - 1);
    reverse(array, 0, len - 1);
    return new String(array);
  }
  
  public void reverse(char[] array, int left, int right) {
    while (left < right) {
      char temp = array[left];
      array[left] = array[right];
      array[right] = temp;
      left++;
      right--;
    }
  }
}
