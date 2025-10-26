class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        int [] distance = new int [V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[src]=0;
        
        for(int i=0;i<V-1;i++){
            boolean updated=false;
            for(int [] edge:edges){
                int u=edge[0];
                int v=edge[1];
                int w=edge[2];
                if(distance[u]!=Integer.MAX_VALUE &&distance[u]+w<distance[v]){
                    distance[v]=distance[u]+w;
                    updated=true;
                }
                if(distance[v]!=Integer.MAX_VALUE &&distance[v]+w<distance[u]){
                    distance[u]=w+distance[v];
                    updated=true;
                }
            }
            if(!updated)break;
        }
        return distance;
    }
}