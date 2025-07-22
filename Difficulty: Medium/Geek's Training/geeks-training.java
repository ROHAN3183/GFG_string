// User function Template for Java

class Solution {
    public int maximumPoints(int arr[][]) {
        int n=arr.length;
        int [][] dp =new int [n][4];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<4;j++){
                dp[i][j]=-1;
            }
        }
        
        int max=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            max=Math.max(max,dfs(arr,n-1,3,dp));
        }
        return max;
        
    }
    int dfs(int [][] arr ,int row,int prev ,int [][]dp){
        if(row<0){
            return 0;
        }
        if(dp[row][prev]!=-1){
            return dp[row][prev];
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<3;i++){
           if(prev!=i){
               max=Math.max(max,arr[row][i]+dfs(arr,row-1,i,dp));
           }
        }
        dp[row][prev]=max;
        return max;
    }
}