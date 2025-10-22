class Solution {
    public boolean isBridge(int V, int[][] edges, int c, int d) {
        
        boolean [] visited = new boolean [V];
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();

        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());

        }
        
        for(int [] node:edges){
            
            int u =node[0];
            int v=node[1];
            
            if( ( u==c && v==d) || ( u==d && v==c ) ){
                continue;
            }
            
            adj.get(u).add(v);
            adj.get(v).add(u);

        }
        
        dfs(adj,visited,c);

        if(!visited[d]){
            return true;
        }
        return false;
    }
    void dfs(ArrayList<ArrayList<Integer>>adj,boolean [] visited,int i){
        if(visited[i]){
            return;
        }
        visited[i]=true;
        for(int neigbour:adj.get(i)){
            if(!visited[neigbour]){
                dfs(adj,visited,neigbour);
            }
        }
        return ;
    }
}