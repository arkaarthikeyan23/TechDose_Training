public class OneEditDistance {
    public int min(int a, int b, int c){
        if(a<b && a<c)  return a;
        else if(b<c)    return b;
        return c;
    }
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length(), n = t.length();

        int[][] dp = new int[m+1][n+1];

        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i==0)    dp[i][j] = j;
                else if(j==0)   dp[i][j] = i;
                else if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1+min(dp[i-1][j], dp[i-1][j-1], dp[i][j-1]);
                }
            }
        }
        return dp[m][n]==1;
    }
}
