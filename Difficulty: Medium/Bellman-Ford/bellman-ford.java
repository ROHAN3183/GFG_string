class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        int [] distance = new int [V];
        Arrays.fill(distance,(int)1e8);
        distance[src]=0;
        for(int i=0;i<V-1;i++){
            boolean changed=false;
            for(int [] edge:edges){
                int u=edge[0];
                int v=edge[1];
                int w=edge[2];
                
                if(distance[u]!=(int)1e8 &&distance[u]+w<distance[v]){
                    distance[v]=distance[u]+w;
                    changed=true;
                }
            }
            if(!changed)break;
        }
        for(int [] edge:edges){
                int u=edge[0];
                int v=edge[1];
                int w=edge[2];
                
                if(distance[u]!=(int)1e8 &&distance[u]+w<distance[v]){
                    return new int[]{-1};
                }
        }
        return distance;
    }
}
