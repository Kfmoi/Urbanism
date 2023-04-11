package ca.mcmaster.cas.se2aa4.a4.pathfinder.graphADT;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ca.mcmaster.cas.se2aaa4.a4.pathfinder.graphADT.EdgeImpl;

public class EdgeImplTest {

    private EdgeImpl edge = new EdgeImpl(0, 10.0, 1, 2);



    @Test
    public void testGetCost() {
        assertEquals(10.0, edge.getCost(), 0.0);
    }

    @Test
    public void testGetSourceIndex() {
        assertEquals(1, edge.getSourceIndex());
    }

    @Test
    public void testGetDestinationIndex() {
        assertEquals(2, edge.getDestinationIndex());
    }

    @Test
    public void testSetCost() {
        edge.setCost(5.0);
        assertEquals(5.0, edge.getCost(), 0.0);
    }

    @Test
    public void testSetSourceIndex() {
        edge.setSourceIndex(3);
        assertEquals(3, edge.getSourceIndex());
    }

    @Test
    public void testSetDestinationIndex() {
        edge.setDestinationIndex(4);
        assertEquals(4, edge.getDestinationIndex());
    }

    @Test
    public void testSetIndex() {
        edge.setIndex(1);
        assertEquals(1, edge.getIndex());
    }

    @Test
    public void testGetIndex() {
        assertEquals(0, edge.getIndex());
    }

}
