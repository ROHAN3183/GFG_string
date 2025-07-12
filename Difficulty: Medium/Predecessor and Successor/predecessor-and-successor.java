class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        ArrayList<Node> list = new ArrayList<>();
        ArrayList<Node> result = new ArrayList<>();

        inorder(root, list);

        int low = 0, high = list.size() - 1;
        Node predecessor = null;
        Node successor = null;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = list.get(mid).data;

            if (val == key) {
                if (mid > 0) predecessor = list.get(mid - 1);
                if (mid < list.size() - 1) successor = list.get(mid + 1);
                break;
            } else if (val > key) {
                successor = list.get(mid);
                high = mid - 1;
            } else {
                predecessor = list.get(mid);
                low = mid + 1;
            }
        }

        result.add(predecessor);
        result.add(successor);

        return result;
    }

    void inorder(Node root, List<Node> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }
}
