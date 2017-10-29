public class Solution {
  public String reverse(String input) {
    HashSet<Character> set = new HashSet<>();
    set.add('a');
    set.add('e');
    set.add('i');
    set.add('o');
    set.add('u');
    
    int count = 0;
    char[] array = input.toCharArray();
    int[] positions = new int[input.length()];
    
    for (int i = 0; i < input.length(); i++) {
      if (set.contains(input.charAt(i))) {
        positions[count] = i;
        count++;
      }
    }
    
    for (int i = 0; i < count; i++) {
      array[i] = input.charAt(positions[count - i - 1]);
    }
    return String.valueOf(array);
  }
}
    
    for (int i = 0; i < count; i++) {
      array[pos[i]] = input.charAt(pos[count - i - 1]);
    }
    return String.valueOf(array);
  }
}
