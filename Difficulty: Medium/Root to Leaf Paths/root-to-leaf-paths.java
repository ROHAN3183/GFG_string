

class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>>result=new ArrayList<>();
        List<Integer>ans=new ArrayList<>();
        traverse(root,result,ans);
        return result;
        
    }
   static void traverse(Node root,ArrayList<ArrayList<Integer>>result,List<Integer>ans){
        
        if(root==null)return;
        
        ans.add(root.data);
        
        if(root.left==null && root.right==null){
            result.add(new ArrayList<>(ans));
        }
        
        traverse(root.left,result,ans);
        traverse(root.right,result,ans);
        ans.remove(ans.size()-1);
        
    }
}