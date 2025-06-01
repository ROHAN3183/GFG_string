class Solution {

    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> result = new ArrayList<>();
        int n = maze.length;

        if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0) {
            return result; // No path if start or end is blocked
        }

        boolean[][] visited = new boolean[n][n];
        dfs(maze, 0, 0, "", result, visited);
        return result;
    }

    private void dfs(int[][] maze, int i, int j, String path, ArrayList<String> result, boolean[][] visited) {
        int n = maze.length;

        // Base Case: reached destination
        if (i == n - 1 && j == n - 1) {
            result.add(path);
            return;
        }

        // Mark as visited
        visited[i][j] = true;

        // Move Down
        if (isSafe(maze, i + 1, j, visited)) {
            dfs(maze, i + 1, j, path + "D", result, visited);
        }

        // Move Left
        if (isSafe(maze, i, j - 1, visited)) {
            dfs(maze, i, j - 1, path + "L", result, visited);
        }

        // Move Right
        if (isSafe(maze, i, j + 1, visited)) {
            dfs(maze, i, j + 1, path + "R", result, visited);
        }

        // Move Up
        if (isSafe(maze, i - 1, j, visited)) {
            dfs(maze, i - 1, j, path + "U", result, visited);
        }

        // Backtrack
        visited[i][j] = false;
    }

    private boolean isSafe(int[][] maze, int i, int j, boolean[][] visited) {
        int n = maze.length;
        return i >= 0 && i < n && j >= 0 && j < n && maze[i][j] == 1 && !visited[i][j];
    }
}
