class Solution {
    public boolean isCycle(int V, int[][] edges) {
        boolean [] visited= new boolean [V];
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
            
        }
        for(int [] edge:edges){
            int u=edge[0];
            int v=edge[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if( dfs(adj,visited,i,-1)){
                    return true;
                }
            }
        }
        return false;
    }
    boolean dfs(ArrayList<ArrayList<Integer>>adj,boolean [] visited,int node,int parent){
        visited[node]=true;
        for(int neighour:adj.get(node)){
            if(!visited[neighour]){
                if(dfs(adj,visited,neighour,node)){
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