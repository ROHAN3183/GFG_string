class Solution {
    static ArrayList<Integer> topView(Node root) {
        Queue<int[]> queue = new LinkedList<>(); // Each element: {hd, nodeData, level}
        HashMap<Integer, int[]> map = new HashMap<>(); // hd -> {nodeData, level}
        ArrayList<Integer> result = new ArrayList<>();
        
        traverse(root, queue, 0, 0);
        
        while (!queue.isEmpty()) {
            int[] pair = queue.poll(); // {hd, nodeData, level}
            int hd = pair[0];
            int data = pair[1];
            int level = pair[2];
            
            if (!map.containsKey(hd)) {
                map.put(hd, new int[]{data, level});
            } else {
                // If current node is higher (smaller level), update the map
                if (level < map.get(hd)[1]) {
                    map.put(hd, new int[]{data, level});
                }
            }
        }
        
        TreeMap<Integer, int[]> sortedMap = new TreeMap<>(map);
        for (int[] val : sortedMap.values()) {
            result.add(val[0]);
        }
        
        return result;
    }
    
    // Added 'level' parameter to keep track of depth
    static void traverse(Node root, Queue<int[]> queue, int hd, int level) {
        if (root == null) return;
        
        queue.offer(new int[]{hd, root.data, level});
        traverse(root.left, queue, hd - 1, level + 1);
        traverse(root.right, queue, hd + 1, level + 1);
    }
}
