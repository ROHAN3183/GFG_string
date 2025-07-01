class Solution {
    static ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        indexing(root, map);

        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys); 

        for (int i=0;i<keys.size();i++) {
            int key=keys.get(i);
            result.add(new ArrayList<>(map.get(key)));
        }

        return result;
    }

    static void indexing(Node root, HashMap<Integer, List<Integer>> map) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            Node node = curr.node;
            int hd = curr.hd;

            map.putIfAbsent(hd, new ArrayList<>());
            map.get(hd).add(node.data);

            if (node.left != null) {
                queue.offer(new Pair(node.left, hd - 1));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, hd + 1));
            }
        }
    }

    static class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
}
