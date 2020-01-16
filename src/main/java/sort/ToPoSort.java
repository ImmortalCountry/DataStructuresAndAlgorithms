package sort;

import utils.Graph;

import java.util.LinkedList;

public class ToPoSort {
    public static void toPoSortByKAHN(Graph graph) {
        int v = graph.getV();
        LinkedList<Integer>[] adj = graph.getAdj();

        // 统计每个顶点的入度
        int[] inDegree = new int[v];

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                // i -> w
                int w = adj[i].get(j);
                inDegree[w]++;
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int i = queue.remove();
            System.out.print("->" + i);
            for (int j = 0; j < adj[i].size(); j++) {
                int k = adj[i].get(j);
                inDegree[k]--;
                if (inDegree[k] == 0) queue.add(k);
            }
        }
    }

    public static void toPoSortByDFS(Graph graph) {
        int v = graph.getV();

        // 先构建逆邻接表，边s->t表示，s依赖于t，t先于s
        LinkedList<Integer>[] adj = graph.getAdj();
        LinkedList<Integer> inverseAdj[] = new LinkedList[v];

        // 申请空间
        for (int i = 0; i < v; i++){
            inverseAdj[i] = new LinkedList<>();
        }
        // 通过邻接表生成逆邻接表
        for (int i = 0; i < v; i++){
            for (int j = 0; j < adj[i].size(); j++){
                int w = adj[i].get(j);
                inverseAdj[w].add(i);
            }
        }
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++){
            if (visited[i] == false){
                visited[i] = true;
                dfs(i, inverseAdj, visited);
            }
        }
    }

    private static void dfs(int vertex, LinkedList<Integer>[] inverseAdj, boolean[] visited) {
        for (int i = 0; i < inverseAdj[vertex].size(); i++){
            int w = inverseAdj[vertex].get(i);
            if (visited[w] == true){
                continue;
            }
            visited[w] = true;
            dfs(w, inverseAdj, visited);
        }
        // 先把vertex这个顶点可达的所有顶点都打印出来之后，再打印它自己
        System.out.print("->" + vertex);
    }
}
