package ca.mcmaster.cas.se2aa4.a4.pathfinder.graphADT;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.mcmaster.cas.se2aaa4.a4.pathfinder.graphADT.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;


public class GraphImplTest {

    Graph<String,Double> graph;


    @BeforeEach
    public void setUp() {
        graph = new GraphImpl<>(5);
    }

    @Test
    public void testGetNumberOfNodes() {
        Node<String,Double> nodeA = new NodeImpl<String,Double>("A", 0.0, 0);
        Node<String,Double> nodeB = new NodeImpl<String,Double>("B", 0.0, 1);
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        assertEquals(2, graph.getNumberOfNodes());
    }

    @Test
    public void testGetNumberOfEdges() {
        Node<String,Double> nodeA = new NodeImpl<String,Double>("A", 0.0, 0);
        Node<String,Double> nodeB = new NodeImpl<String,Double>("B", 0.0, 1);
        Edge<String,Double> edge = new EdgeImpl<>(nodeA, nodeB, 0.0, 0);
        graph.addEdge(edge);
        assertEquals(1, graph.getNumberOfEdges());
    }

    @Test
    public void testGetNodes() {
        Node<String,Double> nodeA = new NodeImpl<String,Double>("A", 0.0, 0);
        Node<String,Double> nodeB = new NodeImpl<String,Double>("B", 0.0, 1);
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        assertEquals(List.of(nodeA, nodeB), graph.getNodes());
    }

    @Test
    public void testGetEdges() {
        Node<String,Double> nodeA = new NodeImpl<String,Double>("A", 0.0, 0);
        Node<String,Double> nodeB = new NodeImpl<String,Double>("B", 0.0, 1);
        Edge<String,Double> edge = new EdgeImpl<>(nodeA, nodeB, 0.0, 0);
        graph.addEdge(edge);
        assertEquals(List.of(edge), graph.getEdges());
    }

    @Test
    public void testGetEdgeIndex() {
        Node<String,Double> nodeA = new NodeImpl<String,Double>("A", 0.0, 0);
        Node<String,Double> nodeB = new NodeImpl<String,Double>("B", 0.0, 1);
        Edge<String,Double> edge = new EdgeImpl<>(nodeA, nodeB, 0.0, 0);
        graph.addEdge(edge);
        assertEquals(0, graph.getEdgeIndex(0, 1));
    }



}