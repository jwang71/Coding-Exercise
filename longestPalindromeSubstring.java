 //DP
    public String longestPalindromeDP(String s) {
        if(s == null || s.length()==0)  
            return "";  
        boolean[][] dp = new boolean[s.length()][s.length()];  
        String res = "";  
        int maxLen = 0;  
        for(int i=s.length()-1;i>=0;i--)  
        {  
            for(int j=i;j<s.length();j++)  
            {  
                if(s.charAt(i)==s.charAt(j) && (j-i<=2 || dp[i+1][j-1]))  
                {  
                    dp[i][j] = true;  
                    if(maxLen<j-i+1)  
                    {  
                        maxLen=j-i+1;  
                        res = s.substring(i,j+1);  
                    }  
                }  
            }  
        }  
        return res; 
    }


//Solution ii 
    public String longestPalindrome(String s) {
        String res = "";
        if (s == null || s.length() == 0) return res;
        
        for (int i = 0; i < s.length()*2; i++) {
            int left = i/2;
            int right = i%2 == 1 ? i/2 : i/2 + 1;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                } else {
                    break;
                }
            }
            if ((right - left - 1) > res.length()) {
                res = s.substring(left + 1, right);
            }
        }
        return res;
    }