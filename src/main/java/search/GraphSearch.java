package search;

import utils.Graph2;

import java.util.LinkedList;
import java.util.Queue;

public class GraphSearch {
    Graph2 graph;
    int v;
    LinkedList<Integer>[] adj;
    boolean found;
    public GraphSearch(Graph2 graph){
        this.graph = graph;
        this.v = graph.getV();
        this.adj = graph.getAdj();
        this.found = false;
    }
    // 从s　->　ｔ
    public void bfs(int s, int t){
        if (s == t) return;
        boolean[] visited = new boolean[v];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int[] prev = new int[v];
        for (int i = 0; i < v; i++){
            prev[i] = -1;
        }
        while (queue.size() != 0){
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); i++){
                int q = adj[w].get(i);
                if (!visited[q]){
                    prev[q] = w;
                    if (q == t){
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    // 深度优先搜索
    public void dfs(int s, int t){
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; i++){
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev, found);
        print(prev, s, t);

    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev, boolean found) {
        if (found) return;
        visited[w] = true;
        if (w == t){
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); i++){
            int q = adj[w].get(i);
            if (!visited[q]){
                prev[q] = w;
                recurDfs(q, t, visited, prev, found);
            }
        }
    }

    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s){
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }
}
