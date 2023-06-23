package com.robinson.algorithms.graph;

import com.robinson.datastructures.Queue;

import java.util.ArrayList;

public class BFSGraphMatrix {


    public static ArrayList<Integer> bfs(int[][] graph, int source, int needle) {
        boolean[] visited = new boolean[graph.length];
        int[] prev = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < graph.length; i++) {
            prev[i] = -1;

        }

        visited[source] = true;
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(source);


        do {
            int curr = queue.deque();

            if (curr == needle) {
                break;
            }
            visited[curr] = true;


            int[] adjs = graph[curr];
            for (int i = 0; i < adjs.length; i++) {
                int edge = adjs[i];
                if (edge == 0) {
                    continue;
                }

                if (visited[i]) {
                    continue;
                }

                visited[i] = true;
                prev[i] = curr;
                queue.enqueue(i);
            }

        } while (queue.length > 0);
        if (prev[needle] == -1) {
            return null;
        }
        int curr = needle;

        ArrayList<Integer> out = new ArrayList<>();


        while (prev[curr] != -1) {
            out.add(curr);
            curr = prev[curr];
        }

        ArrayList<Integer> res = new ArrayList<>(source);
        res.addAll(out);
        return res;
    }

}

