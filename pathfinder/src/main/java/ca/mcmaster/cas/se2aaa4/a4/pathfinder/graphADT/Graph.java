package ca.mcmaster.cas.se2aaa4.a4.pathfinder.graphADT;

import java.util.List;

public interface Graph {
    int getNumberOfNodes();
    int getNumberOfEdges();
    List<Node> getNodes();
    List<Edge> getEdges();
    List<Integer> getNeighbours(int node);
    int getEdgeIndex(int startNode, int endNode);
    void addNode(Node node);
    void addEdge(Edge edge);
    void setNeighbours(int node, List<Integer> neighbours);
    
}