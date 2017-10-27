class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        Stack<Integer> countStack = new Stack<>();
        Stack<String> result = new Stack<>();
        String res = "";
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int count = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    count = count * 10 + s.charAt(i) - '0';
                    i++;
                } 
                countStack.push(count);
            } else if (c == '[') {
                result.push(res);
                res = "";
                i++;
            } else if (c == ']') {
                StringBuilder sb = new StringBuilder(result.pop());
                int times = countStack.pop();
                for (int k = 0; k < times; k++) {
                    sb.append(res);
                }
                res = sb.toString();
                i++;
            } else {
                res += c;
                i++;
            }      
        }
        return res;
    }
}