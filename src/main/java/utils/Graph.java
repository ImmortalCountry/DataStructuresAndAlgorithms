package utils;

import java.util.LinkedList;

/**
 * 有向图
 */
public class Graph {
    // 顶点的个数
    private int v;
    // 邻接表
    private LinkedList<Integer> adj[];

    public Graph(int v){
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++){
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t){
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
