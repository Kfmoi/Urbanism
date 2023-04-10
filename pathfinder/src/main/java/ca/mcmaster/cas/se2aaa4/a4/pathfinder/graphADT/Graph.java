package ca.mcmaster.cas.se2aaa4.a4.pathfinder.graphADT;

import java.util.List;

public interface Graph<T,G> {
    int getNumberOfNodes();
    int getNumberOfEdges();
    List<Node<T,G>> getNodes();
    List<Edge<T,G>> getEdges();
    List<Integer> getNeighbours(int node);
    int getEdgeIndex(int startNode, int endNode);
    void addNode(Node<T,G> node);
    void addEdge(Edge<T,G> edge);
    void setNeighbours(int node, List<Integer> neighbours);
}