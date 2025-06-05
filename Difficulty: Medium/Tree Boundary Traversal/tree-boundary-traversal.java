class Solution {
    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> result = new ArrayList<>();
        if (node == null) return result;
        
        if (!isLeaf(node)) result.add(node.data); // Add root only if not a leaf

        addLeftBoundary(node.left, result);
        addLeaves(node, result);
        addRightBoundary(node.right, result);

        return result;
    }

    // Check if a node is a leaf
    boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    // Add left boundary excluding leaves
    void addLeftBoundary(Node node, ArrayList<Integer> result) {
        while (node != null) {
            if (!isLeaf(node)) result.add(node.data);
            if (node.left != null) node = node.left;
            else node = node.right;
        }
    }

    // Add all leaf nodes (inorder)
    void addLeaves(Node node, ArrayList<Integer> result) {
        if (node == null) return;

        if (isLeaf(node)) {
            result.add(node.data);
            return;
        }

        addLeaves(node.left, result);
        addLeaves(node.right, result);
    }

    // Add right boundary in reverse order, excluding leaves
    void addRightBoundary(Node node, ArrayList<Integer> result) {
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            if (!isLeaf(node)) stack.push(node.data);
            if (node.right != null) node = node.right;
            else node = node.left;
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
    }
}
