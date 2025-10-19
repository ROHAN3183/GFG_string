class Solution {
        class Pair{
            int i;
            int parent;
            Pair(int i,int parent){
                this.i=i;
                this.parent=parent;
            }
        }
    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        Queue<Pair>queue=new LinkedList<>();
        boolean [] visited = new boolean [V];
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
                if(bfs(adj,visited,i,queue,-1)){
                    return true;
                }
            }
        }
        return false;
    }
    boolean bfs(ArrayList<ArrayList<Integer>>adj,boolean [] visited , int i0,Queue<Pair>queue,int parent){
        queue.offer(new Pair(i0,parent));
        visited[i0]=true;
        while(!queue.isEmpty()){
            Pair node=queue.poll();

            for(int neighour :adj.get(node.i)){
                if(!visited[neighour]){
                    queue.offer(new Pair(neighour,node.i));
                    visited[neighour]=true;
                }
                else{
                    if(neighour!=node.parent){
                        return true;
                    }
                }
            }
            
        }
        return false;
    }
    
}