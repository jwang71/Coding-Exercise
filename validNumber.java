class Solution {
    public boolean isNumber(String s) {
       int i = 0;
        while (s.charAt(i) == ' ') {
            i++;
            if (i >= s.length()) return false;
        }
        if (s.charAt(i) == '+' || s.charAt(i) == '-') i++;
        int j = s.length() - 1;
        while (s.charAt(j) == ' ') {
            j--;
            if (j < 0) {
                return false;
            }
        }
        if (i <= j) {
            s = s.substring(i, j + 1);
        } else {
            return false;
        }
        
        int dot = -1;
        int ee = -1;
        for (i = 0; i < s.length(); i++) {
            if (dot == -1 && s.charAt(i) == '.') {
                dot = i;
            } else if (ee == -1 && s.charAt(i) == 'e') {
                ee = i;
                if (i+1 < s.length() && (s.charAt(i+1) == '+' || s.charAt(i+1) == '-')) {
                    i++;
                }
            } else {
                if (Character.isDigit(s.charAt(i))) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        //xxx.yyezzz
        String startStr, midStr, lastStr;
        if (dot == -1 && ee == -1) { //xxx
            startStr = s;
            if (startStr.length() < 1) return false;
        } else if (dot == -1 && ee != -1) {     //xxxezzz
            startStr = s.substring(0, ee);

            if (ee+1 < s.length() && (s.charAt(ee+1)=='+' || s.charAt(ee+1)=='-')) {
                lastStr = s.substring(ee+2);
            } else {
                lastStr = s.substring(ee+1);                
            }
            
            if (startStr.length() < 1 || lastStr.length() < 1) return false;
        } else if (dot != -1 && ee == -1) {     //xxx.yy 
            startStr = s.substring(0, dot);
            midStr = s.substring(dot+1);
            if (startStr.length() < 1 && midStr.length() < 1) return false;
        } else {       //xxx.yyezzz
            if (dot > ee) return false;   //注意这里要判断e和.的位置，dot必须在e的前面 
            startStr = s.substring(0, dot);
            midStr = s.substring(dot+1, ee);
            
            if (ee+1 < s.length() && (s.charAt(ee+1)=='+' || s.charAt(ee+1)=='-')) {
                lastStr = s.substring(ee+2);
            } else {
                lastStr = s.substring(ee+1);                
            }       
            if ((startStr.length() < 1 && midStr.length() < 1 )|| lastStr.length() < 1) return false;
        }
        return true;
    }
}