package ca.mcmaster.cas.se2aaa4.a4.pathfinder.Dijkstra;

import java.util.List;

import ca.mcmaster.cas.se2aaa4.a4.pathfinder.graphADT.*;

public interface PathFinder {
    List<Integer> findPath(Graph garph, int startNode, int endNode);

    void setGraph(Graph graph);

    void setStartNode(int startNode);

    int getStartNode();

    int getEndNode();

    void setEndNode(int endNode);

    double getPathCost();

    List<Integer> getPathEdges();

    List<Integer> getPath();

}
