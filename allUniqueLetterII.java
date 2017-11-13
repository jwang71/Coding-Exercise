  public boolean allUnique(String word) {
    int[] map = new int[8];
    int n = word.length();
    
    for (int i = 0; i < n; i++) {
      int c = word.charAt(i);
      int row = c / 32;
      int col = c % 32;
      int w = 1<<col;
      if ((w&map[row]) != 0) {
        return false;
      } else {
        map[row] |= w;
      }
    }
    return true;
  }