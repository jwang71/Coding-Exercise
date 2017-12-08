public class Solution {
  public boolean match(String input, String pattern) {
    return helper(input, 0, pattern, 0);
  }
  
  public boolean helper(String input, int i, String pattern, int p) {
    if (i == input.length() && p == pattern.length()) return true;
    if (i == input.length() || p == pattern.length()) return false;
    
    if (Character.isLetter(pattern.charAt(p)) && input.charAt(i) == pattern.charAt(p)) {
      return helper(input, i+1, pattern, p+1);
    }

    if (Character.isDigit(pattern.charAt(p))) {
      int count = 0;
      while (p < pattern.length() &&Character.isDigit(pattern.charAt(p))) {
        count = count*10 + pattern.charAt(p)-'0';
        p++;
      }
      return helper(input, i+count, pattern, p);
    }
    return false;
  }
}
