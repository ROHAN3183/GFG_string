
class Solution {
    boolean findTarget(Node root, int target) {
       Set<Integer>set=new HashSet<>();
       return dfs(root,target,set);
        
    }
    boolean dfs(Node root , int target ,Set<Integer>set){
        if(root==null){
            return false;
        }
        
        if(set.contains(root.data)){
            return true;
        }
        else{
            set.add(target-root.data);
        }
        
        return dfs(root.left,target,set)||dfs(root.right,target,set);
    }
}