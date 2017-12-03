public class Solution {
  public int minReplacements(String input) {
        char[] array = input.toCharArray();
        int i = 0;
        int j = array.length - 1;
        int res = 0;
        
        while (i < j) {
            while (i < input.length() && input.charAt(i) == 'a') {
                i++;
            }
            if (i == input.length()) return res;
        
            while (j >= 0 && input.charAt(j) == 'b') {
                j--;
            }
            if (j == 0) return res;    

            int left = i;
            int count1 = 0;
            int right = j;
            int count2 = 0;
            
            while (left <= j && input.charAt(left) == 'b') {
                left++;
                count1++;
            }
            while (right >= i && input.charAt(right) == 'a') {
                right--;
                count2++;
            }
            if (count1 <= count2) {
                res += count1;
                i += count1;
            } else {
                res += count2;
                j -= count2;
            }
        }
        return res;
  }
}
