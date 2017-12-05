public class Solution {
  public String decompress(String input) {
    if (input == null || input.length() <= 1) {
      return input;
    }
    int i = 0;
    StringBuilder sb = new StringBuilder();
    
    while (i < input.length()) {
      char c = input.charAt(i);
      int j = i + 1;
      int count = input.charAt(j) - '0';
      while (j + 1 < input.length() && Character.isDigit(j + 1)) {
        count = count * 10 + input.charAt(j+1);
        j++;
      }
      for (int k = 0; k < count; k++) {
        sb.append(c);
      }
      i = j + 1;
    }
    return sb.toString();
  }
}
