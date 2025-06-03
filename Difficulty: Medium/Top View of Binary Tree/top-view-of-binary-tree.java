class Solution {
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Map<Integer, Integer> map = new TreeMap<>();  // HD -> Node.data
        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[]{root, 0}); // Node and its HD

        while (!queue.isEmpty()) {
            Object[] curr = queue.poll();
            Node node = (Node) curr[0];
            int hd = (int) curr[1];

            if (!map.containsKey(hd)) {
                map.put(hd, node.data); // First node at this HD
            }

            if (node.left != null) {
                queue.offer(new Object[]{node.left, hd - 1});
            }
            if (node.right != null) {
                queue.offer(new Object[]{node.right, hd + 1});
            }
        }

        result.addAll(map.values());
        return result;
    }
}
