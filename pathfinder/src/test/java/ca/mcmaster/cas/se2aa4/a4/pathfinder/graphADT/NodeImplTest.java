package ca.mcmaster.cas.se2aa4.a4.pathfinder.graphADT;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.mcmaster.cas.se2aaa4.a4.pathfinder.graphADT.*;

import static org.junit.jupiter.api.Assertions.*;


public class NodeImplTest {
    Node<String,Double> node;


    @BeforeEach
    public void setUp() {
        node = new NodeImpl<String,Double>("A", 0.0, 0);
    }

    @Test
    public void testGetLabel() {
        assertEquals("A", node.getValue());
    }

    @Test
    public void testGetWeight() {
        assertEquals(0.0, node.getWeight());
    }

    @Test
    public void testSetWeight() {
        node.setWeight(1.0);
        assertEquals(1.0, node.getWeight());
    }

    @Test
    public void testSetLabel() {
        node.setValue("B");
        assertEquals("B", node.getValue());
    }

    @Test
    public void testGetIndex() {
        assertEquals(0, node.getIndex());
    }

    @Test
    public void testSetIndex() {
        node.setIndex(1);
        assertEquals(1, node.getIndex());
    }


    @Test
    public void testNotEquals() {
        Node<String,Double> node2 = new NodeImpl<String,Double>("A", 0.0, 1);
        assertNotEquals(node, node2);
    }
}