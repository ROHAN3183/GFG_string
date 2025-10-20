class Solution {
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) {
        
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        boolean [] visited =new boolean [n];
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(ArrayList<Integer> edge:edges){
            
            int u=edge.get(0);
            int v=edge.get(1);
            
            adj.get(u).add(v);
            adj.get(v).add(u);
            
            
        }
        
        if(!visited[0] && dfs(adj,visited,0,-1)){
            return false;
        }
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
        
    }
    
    boolean dfs(ArrayList<ArrayList<Integer>> adj,boolean [] visited ,int i,int parent){
        visited[i]=true;
        for(int neighour:adj.get(i)){
            if(!visited[neighour]){
                if(dfs(adj,visited,neighour,i)){
                    return true;
                }
            }
            else{
                if(neighour!=parent){
                    return true;
                }
            }
        }
        return false;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
