package utils;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GraphTest {

    private Graph graph;

    @Before
    public void init() {
        graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(2, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);
    }

    @Test
    public void bfs() {
        graph.bfs(0, 6);
    }

    @Test
    public void dfs() {
        graph.dfs(0, 6);
    }
}