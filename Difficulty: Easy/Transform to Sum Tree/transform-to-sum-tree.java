class Solution {
    public void toSumTree(Node root) {
        traverse(root);
    }
    int traverse(Node root){
        if(root==null){
            return 0;
        }
        int leftSum=traverse(root.left);
        
        int rightSum=traverse(root.right);
        
        int oldRootValue=root.data;
        
        root.data=leftSum+rightSum;
        
        return root.data+oldRootValue;
    }
}