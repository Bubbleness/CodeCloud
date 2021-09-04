package com.dhu.niuke;

public class NC92 {

    public String LCS (String s1, String s2) {
        // write code here

        int m = s1.length();
        int n = s2.length();
        if(m == 0 || n == 0)
            return "-1";
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<=n;i++)
            dp[0][i] = 0;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int sl1 = m;
        int sl2 = n;
        while(sl1 != 0 && sl2 != 0){
            if(s1.charAt(sl1-1) == s2.charAt(sl2-1)){
                sb.append(s1.charAt(sl1-1));
                sl1--;
                sl2--;
            }else{
                if(dp[sl1-1][sl2] > dp[sl1][sl2-1]){
                    sl1--;
                }else
                    sl2--;
            }
        }

        if(sb.length() == 0)
            return "-1";
        return sb.reverse().toString();
    }



    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        if(len1 == 0 || len2 == 0)
            return 0;

        int[][] dp = new int[len1+1][len2+1];
        for(int i=0;i<=len1;++i)
            dp[i][0] = 0;
        for(int i=0;i<=len2;++i)
            dp[0][i] = 0;

        for(int i=1;i<=len1;++i){
            for(int j=1;j<=len2;++j){
                if(text1.charAt(i-1) == text2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[len1][len2];
    }
}
