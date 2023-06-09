package com.robinson.algorithms.recursion;

import java.util.ArrayList;

public class MazeSolver {


    public ArrayList<int[]> mazeSolver(String[][] maze, String wall, int[] start, int[] end) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        ArrayList<int[]> path = new ArrayList<>();

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                visited[i][j] = false;
            }
        }

        walk(maze, wall, start, end, visited, path);


        return path;
    }

    //  1. is a wall
    //  2. already visited
    //  3. off the maze/map
    //  4. it is the end
    public boolean walk(String[][] maze, String wall, int[] curr, int[] end, boolean[][] visited, ArrayList<int[]> path) {
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        if ((curr[0] < 0 || curr[0] > maze.length) || (curr[1] < 0 || curr[1] >= maze[0].length)) {
            return false;
        }

        if (visited[curr[0]][curr[1]]) {
            return false;
        }

        if (curr[0] == end[0] && curr[1] == end[1]) {
            path.add(new int[]{curr[0], curr[1]});
            return true;
        }

        if (maze[curr[0]][curr[1]].equals(wall)) {
            return false;
        }

        visited[curr[0]][curr[1]] = true;
        path.add(new int[]{curr[0], curr[1]});

        for (int[] i : dir) {
            int[] newDir = {curr[0] + i[0], curr[1] + i[1]};
            if (walk(maze, wall, newDir, end, visited, path)) {
                return true;
            }
        }
        path.remove(path.size() - 1);

        return false;
    }

}
