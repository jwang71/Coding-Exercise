  public String hex(int number) {
    // Write your solution here.
    String prefix = "0x";
    if (number == 0) return "0x0";
    
    StringBuilder sb = new StringBuilder();
    while (number > 0) {
      int rem = number % 16;
      if (rem < 10) {
        sb.append((char)('0' + rem));
      } else {
        sb.append((char)(rem - 10 + 'A'));
      }
      number /= 16;
    }
    return prefix + sb.reverse().toString();
  }