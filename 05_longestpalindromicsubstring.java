class Solution {
    public String longestPalindrome(String s) {
        if (s == "") {
            return s;
        }
        String result;
        int len = 1;
        int start = 0;
        int l = s.length();
        boolean[][] memo = new boolean[l][l];
        for (boolean[] row : memo) Arrays.fill(row, false);
        for (int i = 0; i < l; i++) memo[i][i] = true; 
        
        for (int i = 0; i < l - 1; i++) {
            if (s.charAt(i)==s.charAt(i+1)) {
                memo[i][i+1] = true;
                start = i;
                len = 2;
            }
        }
        
        for (int j = 3; j <= l; j++) {
            for (int i = 0; i < (l - j + 1); i++) {
                int k = i + j -1;
                if (s.charAt(i) == s.charAt(k) && memo[i+1][k-1]==true) {
                    memo[i][k] = true;
                    start = i;
                    len = j;
                }
            }
        }

        return s.substring(start, start+len);
    }
    
}
