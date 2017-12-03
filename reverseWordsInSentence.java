public class Solution {
  public String reverseWords(String input) {
    String[] array = input.split(" ");
    StringBuilder sb = new StringBuilder();
    for (int i = array.length- 1; i >= 0; i--) {
      if (!array[i].equals(""))
      sb.append(array[i]).append(" ");
    }
    return sb.toString().trim();
  }
}
