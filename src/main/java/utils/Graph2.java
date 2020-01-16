package utils;

import java.util.LinkedList;

/**
 * 无向图
 */
public class Graph2 {
    // 顶点的个数
    private int v;
    // 邻接表
    private LinkedList<Integer> adj[];

    public Graph2(int v){
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++){
            adj[i] = new LinkedList<>();
        }
    }
    public void addEdge(int s, int t){
        // s先于t，边s->t
        adj[s].add(t);
        adj[t].add(s);
    }

    public int getV() {
        return v;
    }

    public LinkedList<Integer>[] getAdj() {
        return adj;
    }
}
