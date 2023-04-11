package ca.mcmaster.cas.se2aa4.a4.pathfinder.graphADT;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ca.mcmaster.cas.se2aaa4.a4.pathfinder.graphADT.NodeImpl;

public class NodeImplTest {

    @Test
    public void testGetCost() {
        NodeImpl node = new NodeImpl(10.0, 1);
        assertEquals(10.0, node.getCost(), 0.0001);
    }

    @Test
    public void testSetCost() {
        NodeImpl node = new NodeImpl(10.0, 1);
        node.setCost(20.0);
        assertEquals(20.0, node.getCost(), 0.0001);
    }

    @Test
    public void testGetProperty() {
        NodeImpl node = new NodeImpl(10.0, 1);
        node.setProperty("foo", "bar");
        assertEquals("bar", node.getProperty("foo"));
    }

    @Test
    public void testSetProperty() {
        NodeImpl node = new NodeImpl(10.0, 1);
        node.setProperty("foo", "bar");
        assertEquals("bar", node.getProperty("foo"));
    }

    @Test
    public void testGetIndex() {
        NodeImpl node = new NodeImpl(10.0, 1);
        assertEquals(1, node.getIndex());
    }

    @Test
    public void testSetIndex() {
        NodeImpl node = new NodeImpl(10.0, 1);
        node.setIndex(2);
        assertEquals(2, node.getIndex());
    }

}
