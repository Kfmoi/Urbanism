package ca.mcmaster.cas.se2aaa4.a4.pathfinder.Dijkstra;

import java.util.List;

import ca.mcmaster.cas.se2aaa4.a4.pathfinder.graphADT.*;

public interface PathFinder<T, G> {
    List<Integer> findPath();

    void setGraph(Graph<T,G> graph);

    void setStartNode(int startNode);

    void setEndNode(int endNode);

    double getPathCost();

    List<Node<T,G>> getPathNodes();

    List<Edge<T,G>> getPathEdges();

    List<Integer> getPath();
}
