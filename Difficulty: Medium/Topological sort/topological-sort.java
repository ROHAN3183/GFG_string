class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        ArrayList<Integer>result=new ArrayList<>();
        Stack<Integer>stack=new Stack<>();
        boolean[] visited=new boolean [V];
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] edge:edges){
            
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(adj,result,i,visited,stack);
            }
        }
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }

        return result;
    }
    static void dfs(ArrayList<ArrayList<Integer>>adj,ArrayList<Integer>result,int i,boolean [] visited,Stack<Integer>stack){
        visited[i]=true;
        for(int neibour:adj.get(i)){
            if(!visited[neibour]){
                dfs(adj,result,neibour,visited,stack);
            }
        }
        stack.push(i);
        return;
    }
}