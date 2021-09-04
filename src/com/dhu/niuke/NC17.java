package com.dhu.niuke;

public class NC17 {

    public int getLongestPalindrome(String A, int n) {

        if(A.length() == 0)
            return 0;
        int maxLen = 0;
        boolean[][] dp = new boolean[n][n];
        for(int len=0;len<n;len++){
            for(int i=0;i+len<n;i++){
                int j = i + len;
                if(len == 0)
                    dp[i][j] = true;
                else if(len == 1)
                    dp[i][j] = A.charAt(i) == A.charAt(j);
                else
                    dp[i][j] = (A.charAt(i)==A.charAt(j) && dp[i+1][j-1]);

                if(dp[i][j])
                    maxLen = Math.max(maxLen,j-i+1);
            }
        }
        return maxLen;
    }
}
