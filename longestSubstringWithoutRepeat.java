public class Solution {
  public int longest(String input) {
    int i = 0;
    int j = 0;
    int max = 0;
    Set<Character> set = new HashSet<>();
    
    while (i < input.length()) {
      if (!set.contains(input.charAt(i))) {
        set.add(input.charAt(i));
        max = Math.max(max, i - j + 1);
        i++;
      } else {
        set.remove(input.charAt(j));
        j++;
      }
    }
    return max;
  }
}
