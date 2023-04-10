package ca.mcmaster.cas.se2aa4.a4.pathfinder.graphADT;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.mcmaster.cas.se2aaa4.a4.pathfinder.graphADT.*;

import static org.junit.jupiter.api.Assertions.*;


public class EdgeImplTest {
    Edge<String,Double> edge;
    Node<String,Double> nodeA;
    Node<String,Double> nodeB;

    @BeforeEach
    public void setUp() {
        nodeA = new NodeImpl<String,Double>("A", 0.0, 0);
        nodeB = new NodeImpl<String,Double>("B", 0.0, 1);
        edge = new EdgeImpl<>(nodeA, nodeB, 0.0, 0);
    }


    @Test
    public void testGetCost() {
        assertEquals(0.0, edge.getCost());
    }

    @Test
    public void testGetStartNode() {
        assertEquals(nodeA, edge.getStartNode());
    }

    @Test
    public void testGetEndNode() {
        assertEquals(nodeB, edge.getEndNode());
    }

    @Test
    public void testGetIndex() {
        assertEquals(0, edge.getIndex());
    }


    @Test
    public void testNotEquals() {
        Edge<String,Double> edge2 = new EdgeImpl<>(nodeA, nodeB, 0.0, 1);
        assertNotEquals(edge, edge2);
    }

    @Test
    public void testSetCost() {
        edge.setCost(1.0);
        assertEquals(1.0, edge.getCost());
    }

    @Test
    public void testSetStartNode() {
        Node<String,Double> nodeC = new NodeImpl<String,Double>("C", 0.0, 2);
        edge.setStartNode(nodeC);
        assertEquals(nodeC, edge.getStartNode());
    }

    @Test
    public void testSetEndNode() {
        Node<String,Double> nodeC = new NodeImpl<String,Double>("C", 0.0, 2);
        edge.setEndNode(nodeC);
        assertEquals(nodeC, edge.getEndNode());
    }

    @Test
    public void testSetIndex() {
        edge.setIndex(1);
        assertEquals(1, edge.getIndex());
    }

}
