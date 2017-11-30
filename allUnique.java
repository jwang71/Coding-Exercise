  public boolean allUnique(String word) {
    if (word.length() == 0) return true;
    int[] map = new int[26];
    for (int i = 0; i < word.length(); i++) {
      map[word.charAt(i) - 'a']++;
    }
    
    for (int i = 0; i < 26; i++) {
      if (map[i] > 1) {
        return false;
      }
    }
    return true;
  }