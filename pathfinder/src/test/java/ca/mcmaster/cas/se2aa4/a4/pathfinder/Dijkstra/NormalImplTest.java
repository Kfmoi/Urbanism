package ca.mcmaster.cas.se2aa4.a4.pathfinder.Dijkstra;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.mcmaster.cas.se2aaa4.a4.pathfinder.Dijkstra.*;
import ca.mcmaster.cas.se2aaa4.a4.pathfinder.graphADT.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;


public class NormalImplTest {
    private  Graph graph;
    private  PathFinder pathFinder;

    @BeforeEach
    public void setUp() {
        graph = new GraphImpl(3);
        Node nodeA = new NodeImpl( 0.0, 0);
        Node nodeB = new NodeImpl( 0.0, 1);
        Node nodeC = new NodeImpl( 5.0, 2);

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);

        Edge edgeAB = new EdgeImpl(0,2.0, nodeA.getIndex(), nodeB.getIndex());
        Edge edgeAC = new EdgeImpl(1,1.0, nodeA.getIndex(), nodeC.getIndex());
        Edge edgeBC = new EdgeImpl(2,0.0, nodeB.getIndex(), nodeC.getIndex());

        graph.addEdge(edgeAB);
        graph.addEdge(edgeAC);
        graph.addEdge(edgeBC);

        graph.setNeighbours(0, List.of(0,1));
        graph.setNeighbours(1, List.of(2));
        graph.setNeighbours(2, List.of());

        pathFinder = new DijkstraPathfinder(graph, nodeA.getIndex(), nodeC.getIndex());

    }

    @Test
    public void testFindPath() {
        List<Integer> actualPath = pathFinder.getPath();
        assertEquals(List.of(0,2), actualPath);
        
    }

    @Test
    public void testGetCost() {
        pathFinder.getPath();
        double actualCost = pathFinder.getPathCost();
        assertEquals(1.0, actualCost);
    }

    @Test
    public void testGetEdges() {
        pathFinder.getPath();
        List<Integer> actualEdges = pathFinder.getPathEdges();
        assertEquals(List.of(1), actualEdges);
    }

    @Test
    public void testGetStartNode() {
        Node nodeA = new NodeImpl( 0.0, 0);
        PathFinder pathFinder = new DijkstraPathfinder(graph, 0, 0);
        pathFinder.setStartNode(nodeA.getIndex());
        assertEquals(0, pathFinder.getStartNode());
    }

    @Test
    public void testGetEndNode() {
        Node nodeA = new NodeImpl( 0.0, 0);
        PathFinder pathFinder = new DijkstraPathfinder(graph, 0, 0);
        pathFinder.setEndNode(nodeA.getIndex());
        assertEquals(0, pathFinder.getEndNode());
    }
}
