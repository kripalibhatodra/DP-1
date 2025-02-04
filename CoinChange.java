// Time Complexity :0(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : yes


// Your code here along with comments explaining your approach: DP

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins==null) return -1;
        if(amount==0) return 0;

        int m= coins.length;
        int n= amount;
        int dp[][]= new int[m+1][n+1];
        Arrays.fill(dp[0], 999999);
        dp[0][0]=0;
        for(int i =1; i<=m; i++){
            for(int j=0; j<=n;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }

        }
        return dp[m][n] == 999999? -1 : dp[m][n];
    }
}