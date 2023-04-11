package ca.mcmaster.cas.se2aaa4.a4.pathfinder.graphADT;

import java.util.ArrayList;
import java.util.List;

public class GraphImpl implements Graph {
    private List<Node> nodes = new ArrayList<>();
    private List<Edge> edges = new ArrayList<>();
    private List<List<Integer>> neighList;

    public GraphImpl(int size) {
        neighList = new ArrayList<List<Integer>>();
        for (int i = 0; i < size; i++) {
            neighList.add(new ArrayList<Integer>());
        }
    }

    @Override
    public int getNumberOfNodes() {
        return nodes.size();
    }

    @Override
    public int getNumberOfEdges() {
        return edges.size();
    }

    @Override
    public List<Node> getNodes() {
        return nodes;
    }

    @Override
    public List<Edge> getEdges() {
        return edges;
    }

    @Override
    public List<Integer> getNeighbours(int node) {
        return neighList.get(node);
    }

    @Override
    public int getEdgeIndex(int startNode, int endNode) {
        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i).getSourceIndex() == startNode && edges.get(i).getDestinationIndex() == endNode) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void addNode(Node node) {
        nodes.add(node);
        node.setIndex(nodes.size() - 1);
    }

    @Override
    public void addEdge(Edge edge) {
        edges.add(edge);
        edge.setIndex(edges.size() - 1);
    }

    @Override
    public void setNeighbours(int node, List<Integer> neighbours) {
        neighList.get(node).addAll(neighbours);
    }

    
}

