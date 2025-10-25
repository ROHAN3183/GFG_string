class Solution {
    class Pair {
        int node;
        int dis;

        Pair(int node, int dis) {
            this.node = node;
            this.dis = dis;
        }
    }

    public int[] dijkstra(int V, int[][] edges, int src) {
        int[] distance = new int[V];
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.dis == b.dis) {
                return a.node - b.node;
            }
            return a.dis - b.dis;
        });
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }
        return dijkstraLogic(adj, distance, pq, src);
    }

    int[] dijkstraLogic(ArrayList<ArrayList<Pair>> adj, int[] distance, PriorityQueue<Pair> pq, int src) {
        distance[src] = 0;
        pq.offer(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int currNode = curr.node;
            int currDis = curr.dis;
            if (currDis > distance[currNode]) {
                continue;
            }
            for (Pair neibour : adj.get(currNode)) {
                if (currDis + neibour.dis < distance[neibour.node]) {
                    distance[neibour.node] = currDis + neibour.dis;
                    pq.offer(new Pair(neibour.node, distance[neibour.node]));
                }
            }
        }
        return distance;
    }
}