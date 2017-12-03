  public String remove(String input, String t) {
    if (input == null || t == null || t.length() == 0) return input;
    
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < t.length(); i++) {
      set.add(t.charAt(i));
    }
    
    int slow = -1;
    int fast = 0;
    char[] array = input.toCharArray();
    
    while (fast < input.length()) {
      if (set.contains(input.charAt(fast))) {
        fast++;
      } else {
        array[++slow] = array[fast++];
      }
    }
    return slow == -1 ? "" : new String(array, 0, slow + 1);
  }
