class Solution {
    int count=0;
    public int singlevalued(Node root) {
        dfs(root);
        return count;
        
    }
    boolean dfs(Node root){
        if(root==null){
            return true;
        }

        boolean left=dfs(root.left);
        boolean right=dfs(root.right);
        
        if(!left||!right){
            return false;
        }
        if(root.left!=null && root.left.data!=root.data){
            return false;
        }
        if(root.right!=null && root.right.data!=root.data){
            return false;
        }
        count++;
        return true;
        
    }
}