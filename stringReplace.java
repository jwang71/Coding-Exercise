public class Solution {
  public String replace(String input, String s, String t) {
    if (input == null || input.length() < s.length()) return input;
    
    if (s.length() >= t.length()) {
      return replaceShort(input, s, t);
    } else {
      return replaceLong(input, s, t);
    }
  }
  
  public String replaceShort(String input, String s, String t) {
    char[] array = input.toCharArray();
    char[] sarray = s.toCharArray();
    int slow = 0;
    
    for (int i = 0; i < input.length(); i++) {
      if (i <= input.length() - s.length()) {
        int j = 0;
        for (; j < s.length(); j++) {
          if (input.charAt(i+j) != s.charAt(j)) {
            break;
          }
        }
        if (j == s.length()) {
          int k = 0;
          while (k < t.length()) {
            array[slow++] = t.charAt(k++);
          }
          i = i + s.length() - 1;
        }  else {
          array[slow++] = input.charAt(i);
        }       
      } else {
        array[slow++] = input.charAt(i);
      }
    }
    return new String(array, 0, slow);
  }
  
  public String replaceLong(String input, String s, String t) {
    char[] array = input.toCharArray();
    char[] sarray = s.toCharArray();
    
    int count = 0;
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i <= input.length() - s.length(); i++) {
      int j = 0;
      for (; j < s.length(); j++) {
        if (input.charAt(i + j) != s.charAt(j)) {
          break;
        }
      }
      if (j == s.length()) {
        count++;
        set.add(i + s.length() - 1);
        i = i + s.length() - 1;
      }
    }
    
    int newLength = count*(t.length() - s.length()) + input.length();
    char[] res = new char[newLength];
    
    int slow = res.length - 1;
    int i = input.length() - 1;
    
    while (i >= 0) {
      if (!set.isEmpty() && set.contains(i)) {
        int k = t.length() - 1;
        while (k >= 0) {
          res[slow--] = t.charAt(k--);
        }
        i = i - s.length();
      } else {
        res[slow--] = input.charAt(i--);
      }
    }
    return new String(res);
  }
}
