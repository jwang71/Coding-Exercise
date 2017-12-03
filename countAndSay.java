public class Solution {
  public String countAndSay(int n) {
    String last = "1";
    
    for (int i = 1; i < n; i++) {
      StringBuilder sb = new StringBuilder();
      int j = 0;
      while (j < last.length()) {
        int count = 1;
      
        while (j + 1 < last.length() && last.charAt(j+1) == last.charAt(j)) {
          count++;
          j++;
        }
        sb.append(count).append(last.charAt(j));
        j++;
      }
      last = sb.toString();
    }
    return last;
  }
}
