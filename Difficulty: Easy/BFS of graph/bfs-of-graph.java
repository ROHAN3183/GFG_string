class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited=new boolean [adj.size()];
        Queue<Integer>queue=new LinkedList<>();
        ArrayList<Integer>result=new ArrayList<>();
        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                bfs(adj,i,visited,queue,result);
            }
        }
        return result;
        
    }
    void bfs(ArrayList<ArrayList<Integer>> adj,int i,boolean [] visited,Queue<Integer>queue,ArrayList<Integer>result){
        queue.offer(i);
        visited[i]=true;
        result.add(i);
        while(!queue.isEmpty()){
            
            int node=queue.poll();
            
            for(int neighour:adj.get(node)){
                if(!visited[neighour]){
                    queue.offer(neighour);
                    visited[neighour]=true;
                    result.add(neighour);
                }
            }
        }
        return ;
    }
    
}