public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        boolean flag = false;
        //Fill 1st row
        for(int i=0; i<n; i++){
            if(flag || obstacleGrid[0][i] == 1){
                flag = true;
                dp[0][i] = 0;
            }else{
                dp[0][i] = 1;
            }
        }
        flag = false;
        //Fill 1st col
        for(int i=0; i<m; i++){
            if(flag || obstacleGrid[i][0] == 1){
                flag = true;
                dp[i][0] = 0;
            }else{
                dp[i][0] = 1;
            }
        }

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
