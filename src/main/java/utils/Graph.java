package utils;

import java.beans.IntrospectionException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 有向图
 */
public class Graph {
    // 顶点的个数
    private int v;
    // 邻接表
    private LinkedList<Integer> adj[];
    boolean found = false;

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void bfs(int start, int end) {
        if (start == end) return;
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        while (!queue.isEmpty()) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); i++) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == end) {
                        print(prev, start, end);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    public void dfs(int start, int end) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        recurDfs(start, end, visited, prev);
        print(prev, start, end);
    }

    private void recurDfs(int start, int end, boolean[] visited, int[] prev) {
        if (found) return;
        visited[start] = true;
        if (start == end) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[start].size(); i++) {
            int q = adj[start].get(i);
            if (!visited[q]) {
                prev[q] = start;
                recurDfs(q, end, visited, prev);
            }
        }
    }

    private void print(int[] prev, int start, int end) {
        if (prev[end] != -1 && end != start) {
            print(prev, start, prev[end]);
        }
        System.out.print(end + " ");
    }


    public void addEdge(int s, int t) {
        // s先于t，边s->t
        adj[s].add(t);
    }

    public int getV() {
        return v;
    }

    public LinkedList<Integer>[] getAdj() {
        return adj;
    }
}
