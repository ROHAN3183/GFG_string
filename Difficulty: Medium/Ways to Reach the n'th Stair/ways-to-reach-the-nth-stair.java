class Solution {
    Integer [] memo;
    int countWays(int n) {
        memo =new Integer[45];
        return dfs(n,0);
        
    }
    int dfs(int n , int  idx ){
        if(idx>n){
            return 0;
        }
        if(idx==n){
            return 1;
        }
        if(memo[idx]!=null){
            return memo[idx];
        }
        return memo[idx]=dfs(n,idx+1)+dfs(n,idx+2);
    }
}
