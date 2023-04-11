package ca.mcmaster.cas.se2aa4.a4.pathfinder.graphADT;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ca.mcmaster.cas.se2aaa4.a4.pathfinder.graphADT.*;


public class GraphImplTest {

    private Graph graph = new GraphImpl(3);
    

    @Test
    public void testAddNode() {
        Node node = new NodeImpl(0.0, 0);
        graph.addNode(node);
        List<Node> nodes = graph.getNodes();
        assertEquals(1, nodes.size());
        assertEquals(node, nodes.get(0));
    }
    
    @Test
    public void testAddEdge() {
        Node nodeA  = new NodeImpl(0.0, 0);
        Node nodeB = new NodeImpl(0.0, 1);
        Edge edge = new EdgeImpl(0,1.0, nodeA.getIndex(), nodeB.getIndex());
        graph.addEdge(edge);
        List<Edge> edges = graph.getEdges();
        assertEquals(1, edges.size());
        assertEquals(edge, edges.get(0));
    }
    
    @Test
    public void testGetNumberOfNodes() {
        assertEquals(0, graph.getNumberOfNodes());
        Node node  = new NodeImpl(0.0, 0);
        graph.addNode(node);
        assertEquals(1, graph.getNumberOfNodes());
    }
    
    @Test
    public void testGetNumberOfEdges() {
        assertEquals(0, graph.getNumberOfEdges());
        Node nodeA  = new NodeImpl(0.0, 0);
        Node nodeB = new NodeImpl(0.0, 1);
        Edge edge = new EdgeImpl(0,1.0, nodeA.getIndex(), nodeB.getIndex());
        graph.addEdge(edge);
        assertEquals(1, graph.getNumberOfEdges());
    }
    
    @Test
    public void testGetNodes() {
        List<Node> nodes = graph.getNodes();
        assertTrue(nodes.isEmpty());
        Node nodeA  = new NodeImpl(0.0, 0);
        Node nodeB = new NodeImpl(0.0, 1);
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        nodes = graph.getNodes();
        assertEquals(2, nodes.size());
        assertTrue(nodes.contains(nodeA));
        assertTrue(nodes.contains(nodeB));
    }
    
    @Test
    public void testGetEdges() {
        List<Edge> edges = graph.getEdges();
        assertTrue(edges.isEmpty());
        Node nodeA  = new NodeImpl(0.0, 0);
        Node nodeB = new NodeImpl(0.0, 1);
        Edge edge = new EdgeImpl(0,1.0, nodeA.getIndex(), nodeB.getIndex());
        graph.addEdge(edge);
        edges = graph.getEdges();
        assertEquals(1, edges.size());
        assertTrue(edges.contains(edge));
    }
    
    @Test
    public void testGetNeighbours() {
        Node nodeA = new NodeImpl(0.0, 0);
        Node nodeB = new NodeImpl(0.0, 1);
        Node nodeC = new NodeImpl(0.0, 2);
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.setNeighbours(0, Arrays.asList(1, 2));
        List<Integer> neighbours = graph.getNeighbours(0);
        assertEquals(2, neighbours.size());
        assertTrue(neighbours.contains(1));
        assertTrue(neighbours.contains(2));
    }
    
}
