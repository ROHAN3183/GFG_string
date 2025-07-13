class Solution {
    Node lastvisit=null;
    Node head=null;
    
    public Node flattenBST(Node root){
        inorder(root);
        return head;
    
    }
    void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        
        if(lastvisit==null){
            
            head=root;
        }
        else{
            lastvisit.right=root;
        }
        
        root.left=null;
        lastvisit=root;
        
        inorder(root.right);
    }
}
