class Tree {
    int findCeil(Node root, int key) {
        List<Node>list=new ArrayList<>();
        inorder(root,list);
        int size=list.size();
        for(int i=0;i<size;i++){
            Node node=list.get(i);
            if(node.data==key){
                return node.data;
            }
            else if(node.data>key){
                return node.data;
            }
        }
        return -1;
        
    }
    void inorder(Node root,List<Node>list){
        if(root==null){
            return;
        }
        inorder(root.left,list);
        list.add(root);
        inorder(root.right,list);
    }
}