package ca.mcmaster.cas.se2aaa4.a4.pathfinder.Dijkstra;

import java.util.*;

import ca.mcmaster.cas.se2aaa4.a4.pathfinder.graphADT.Edge;
import ca.mcmaster.cas.se2aaa4.a4.pathfinder.graphADT.Graph;
import ca.mcmaster.cas.se2aaa4.a4.pathfinder.graphADT.Node;

public class DijkstraPathfinder<T,G> implements PathFinder<T,G> {

    private Graph<T,G> graph;
    private int startNode;
    private int endNode;
    private double pathCost;
    private List<Node<T,G>> pathNodes;
    private List<Edge<T,G>> pathEdges;
    private List<Integer> path;

    public DijkstraPathfinder(Graph<T,G> graph, int startNode, int endNode) {
        this.graph = graph;
        this.startNode = startNode;
        this.endNode = endNode;
        this.pathCost = 0.0;
        this.pathNodes = new ArrayList<>();
        this.pathEdges = new ArrayList<>();
        this.path = new ArrayList<>();
    }


  @Override
  public List<Integer> findPath() {
     int n = graph.getNumberOfNodes();
     double[] distance = new double[n];
    int[] previous = new int[n];
    PriorityQueue<Integer> queue = new PriorityQueue<>(n, Comparator.comparingDouble(i -> distance[i]));
    Arrays.fill(distance, Double.MAX_VALUE);
    distance[startNode] = 0.0;
    queue.add(startNode);

    while (!queue.isEmpty()) {
      int u = queue.poll();
      if (u == endNode){
        break;
      }
      for (int v : graph.getNeighbours(u)) {
        int edgeWeight = graph.getEdgeIndex(u, v);

        if (edgeWeight != -1) {
            Edge<T,G> edge = graph.getEdges().get(edgeWeight);
            double cost = distance[u] + edge.getCost();
            if (cost < distance[v]) {
                distance[v] = cost;
                previous[v] = u;
                queue.remove(v);
                queue.add(v);
            }
        }
    }

  }
            List<Integer> path = new ArrayList<>();
            int current = endNode;
            while (current != startNode && current != startNode) {
                path.add(current);
                current = previous[current];
            }
            path.add(startNode);
            Collections.reverse(path);
             if (path.size() >= 1) {
                pathCost = distance[endNode];
                for (int i = 0; i < path.size() - 1; i++) {
                    int uIndex = path.get(i);
                    int vIndex = path.get(i + 1);
                    Node<T,G> uNode = graph.getNodes().get(uIndex);
                    Node<T,G> vNode = graph.getNodes().get(vIndex);
                    Edge<T,G> edges = graph.getEdges().get(graph.getEdgeIndex(uIndex, vIndex));
                    pathNodes.add(uNode);
                    pathEdges.add(edges);
                }
                pathNodes.add(graph.getNodes().get(endNode));
        }
        return path;
    }

@Override
public void setGraph(Graph<T, G> graph) {
    this.graph = graph;
}

@Override
public void setStartNode(int startNode) {
    this.startNode = startNode;
}

@Override
public void setEndNode(int endNode) {
    this.endNode = endNode;
}

@Override
public double getPathCost() {
    return pathCost;
}

@Override
public List<Node<T, G>> getPathNodes() {
    return pathNodes;
}

@Override
public List<Edge<T, G>> getPathEdges() {
    return pathEdges;
}

@Override
public List<Integer> getPath() {
    return path;
}
}
