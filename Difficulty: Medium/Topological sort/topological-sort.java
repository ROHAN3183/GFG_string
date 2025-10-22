class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        int [] indegree = new int [V];
        ArrayList<Integer>result=new ArrayList<>();
        Queue<Integer>queue=new LinkedList<>();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] edge:edges){
            
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        
        for(int i=0;i<V;i++){
            for(int neibour:adj.get(i)){
                indegree[neibour]++;
            }
        }
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        return bfs(adj,indegree,result,queue);
    }
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>>adj,int [] indegree,ArrayList<Integer>result,Queue<Integer>queue){
        while(!queue.isEmpty()){
            int node = queue.poll();
            result.add(node);
            for(int neigbour:adj.get(node)){
                indegree[neigbour]--;
                if(indegree[neigbour]==0){
                    queue.offer(neigbour);
                }
            }
        }
        return result;
    }
}