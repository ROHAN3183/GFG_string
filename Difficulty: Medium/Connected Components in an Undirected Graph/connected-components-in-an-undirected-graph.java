
class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        boolean [] visited = new boolean [V];
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        ArrayList<ArrayList<Integer>>result=new ArrayList<>();
        
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int [] edge : edges){
            
            int u = edge[0];
            int v= edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            
            
        }
        
        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                ArrayList<Integer>ans=new ArrayList<>();
                dfs(adj,visited,i,ans);
                result.add(ans);
            }
        }
        
        return result;
    }
    void dfs(ArrayList<ArrayList<Integer>> adj,boolean [] visited , int i , ArrayList<Integer>ans){
        visited[i]=true;
        ans.add(i);
        for(int neighour : adj.get(i)){
            if(!visited[neighour]){
                dfs(adj,visited,neighour,ans);
            }
        }
    }
}