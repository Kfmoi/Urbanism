package ca.mcmaster.cas.se2aaa4.a4.pathfinder.graphADT;

import java.util.ArrayList;
import java.util.List;

public class GraphImpl<T, G> implements Graph<T,G> {
    private List<Node<T, G>> nodes;
    private List<Edge<T, G>> edges;
    private List<List<Integer>> neighList;
    private int edgeIndex;

    public GraphImpl(int size) {
        nodes = new ArrayList<Node<T, G>>(size);
        edges = new ArrayList<Edge<T, G>>(size);
        neighList = new ArrayList<List<Integer>>(size);
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
    public List<Node<T, G>> getNodes() {
        return nodes;
    }

    @Override
    public List<Edge<T, G>> getEdges() {
        return edges;
    }

    @Override
    public List<Integer> getNeighbours(int node) {
        return neighList.get(node);
    }

    @Override
    public int getEdgeIndex(int startNode, int endNode) {
        return edgeIndex;
    }

    @Override
    public void addNode(Node<T, G> node) {
        nodes.add(node);
    }

    @Override
    public void addEdge(Edge<T, G> edge) {
        edges.add(edge);
    }

    @Override
    public void setNeighbours(int node, List<Integer> neighbours) {
        neighList.get(node).addAll(neighbours);
    }

    
}

