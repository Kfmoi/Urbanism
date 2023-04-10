package ca.mcmaster.cas.se2aa4.a4.pathfinder.Dijkstra;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.mcmaster.cas.se2aaa4.a4.pathfinder.Dijkstra.*;
import ca.mcmaster.cas.se2aaa4.a4.pathfinder.graphADT.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;


public class DijkstraPathfinderTest {
    Graph<String,Double> graph;
    PathFinder<String,Double> pathFinder;

    @BeforeEach
    public void setUp() {
        graph = new GraphImpl<>(3);
        Node<String,Double> nodeA = new NodeImpl<String,Double>("A", 0.0, 0);
        Node<String,Double> nodeB = new NodeImpl<String,Double>("B", 0.0, 1);
        Node<String,Double> nodeC = new NodeImpl<String,Double>("C", 0.0, 2);

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);

        graph.setNeighbours(0, List.of(1,2));
        graph.setNeighbours(1, List.of(0,2));
        graph.setNeighbours(2, List.of(0,1));

        Edge<String,Double> edgeAB = new EdgeImpl<>(nodeA, nodeB, 0.0, 0);
        Edge<String,Double> edgeAC = new EdgeImpl<>(nodeA, nodeC, 0.0, 1);
        Edge<String,Double> edgeBA = new EdgeImpl<>(nodeB, nodeA, 0.0, 2);

        graph.addEdge(edgeAB);
        graph.addEdge(edgeAC);
        graph.addEdge(edgeBA);

        pathFinder = new DijkstraPathfinder<>(graph,0,2);

    }

    @Test
    public void testFindPath() {
        List<Integer> actualPath = pathFinder.findPath();
        assertEquals(List.of(0,2), actualPath);
        
    }
}
