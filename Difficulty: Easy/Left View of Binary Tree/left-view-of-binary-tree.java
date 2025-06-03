
class Solution {
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer>result=new ArrayList<>();
        sideView(root,result,1);
        return result;
        
    }
    void sideView(Node root,ArrayList<Integer>result,int level){
        if(root==null){
            return;
        }
        if(level>result.size()){
            result.add(root.data);
        }
        sideView(root.left,result,level+1);
        sideView(root.right,result,level+1);
    }
}