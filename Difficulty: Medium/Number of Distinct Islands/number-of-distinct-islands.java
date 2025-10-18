class Solution {

    class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Set<String> set = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    String ans = bfs(grid, i, j, visited);
                    if (!set.contains(ans)) {
                        set.add(ans);
                    }
                }
            }
        }
        return set.size();
    }

    String bfs(int[][] grid, int i0, int j0, boolean[][] visited) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(i0, j0));
        visited[i0][j0] = true;
        String temp = "";

        while (!queue.isEmpty()) {
            Pair node = queue.poll();
            int i = node.i;
            int j = node.j;

            int distanceX = i - i0;
            int distanceY = j - j0;
            temp = temp + distanceX + "," + distanceY + " ||";

            // top
            if (i - 1 >= 0 && grid[i - 1][j] == 1 && !visited[i - 1][j]) {
                visited[i - 1][j] = true;
                queue.offer(new Pair(i - 1, j));
            }

            // bottom
            if (i + 1 < grid.length && grid[i + 1][j] == 1 && !visited[i + 1][j]) {
                visited[i + 1][j] = true;
                queue.offer(new Pair(i + 1, j));
            }

            // left
            if (j - 1 >= 0 && grid[i][j - 1] == 1 && !visited[i][j - 1]) {
                visited[i][j - 1] = true;
                queue.offer(new Pair(i, j - 1));
            }

            // right
            if (j + 1 < grid[0].length && grid[i][j + 1] == 1 && !visited[i][j + 1]) {
                visited[i][j + 1] = true;
                queue.offer(new Pair(i, j + 1));
            }
        }

        return temp;
    }
}
