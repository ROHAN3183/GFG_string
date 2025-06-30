class Tree {
    int ceil=-1;
    int findCeil(Node root, int key) {
        inorder(root,key);
        
        return ceil;
    }
    void inorder(Node root,int key){
        if(root==null){
            return;
        }
        
        inorder(root.left,key);
        
        if(root.data>=key && ceil==-1){
           ceil=root.data;
           return;
        }

        inorder(root.right,key);
      
    }
}