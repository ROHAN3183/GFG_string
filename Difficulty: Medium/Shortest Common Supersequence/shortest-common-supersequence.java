
class Solution {
    static Integer [][] memo;
    public static int shortestCommonSupersequence(String s1, String s2) {
        memo =new Integer [s1.length()][s2.length()];
        return dfs(s1,s2,0,0);
        
    }
    static int dfs(String s1,String s2,int i,int j){
        if(i>=s1.length()||j>=s2.length()){
            if(i>=s1.length()){
                return s2.length()-j;
            }
            if(j>=s2.length()){
                return s1.length()-i;
            }
        }
        if(memo[i][j]!=null){
            return memo[i][j];
        }
        
        if(s1.charAt(i)==s2.charAt(j)){
            return memo[i][j]=1 + dfs(s1,s2,i+1,j+1);
        }
        return memo[i][j]=Math.min(1+dfs(s1,s2,i+1,j),1+dfs(s1,s2,i,j+1));
    }
}