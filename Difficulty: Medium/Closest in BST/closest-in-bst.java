class Solution {
    static int minVal;
    static int minDiff(Node root, int K) {
        
        minVal=Integer.MAX_VALUE;
        dfs(root,K);
        return minVal;
        
    }
    static void dfs(Node root,int K){
        
        if(root==null){
            return;
        }
        
        minVal=Math.min(minVal,Math.abs(root.data-K));
        
        if(root.data>K){
            dfs(root.left,K);
        }
        else if(root.data<K){
            dfs(root.right,K);
        }
        else{
            minVal=0;
        }
        
        return;
    }
}