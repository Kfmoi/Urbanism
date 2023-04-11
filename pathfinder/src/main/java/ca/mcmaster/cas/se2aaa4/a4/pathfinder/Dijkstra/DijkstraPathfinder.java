package ca.mcmaster.cas.se2aaa4.a4.pathfinder.Dijkstra;

import java.util.*;

import ca.mcmaster.cas.se2aaa4.a4.pathfinder.graphADT.Edge;
import ca.mcmaster.cas.se2aaa4.a4.pathfinder.graphADT.Graph;
import ca.mcmaster.cas.se2aaa4.a4.pathfinder.graphADT.Node;

public class DijkstraPathfinder implements PathFinder {

    private Graph graph;
    private int startNode;
    private int endNode;
    private double pathCost;
    private List<Node> pathNodes = new ArrayList<>();
    private List<Edge> pathEdges = new ArrayList<>();

    public DijkstraPathfinder(Graph graph, int startNode, int endNode) {
        this.graph = graph;
        this.startNode = startNode;
        this.endNode = endNode;
    }


  @Override
  public List<Integer> findPath(Graph graph, int startNode, int endNode) {
     int n = graph.getNumberOfNodes();
     double[] distance = new double[n];
    int[] previous = new int[n];
    int currentindex;
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>(n, Comparator.comparingDouble(i -> distance[i]));
    Arrays.fill(previous, -1);
    Arrays.fill(distance, Double.MAX_VALUE);
    distance[startNode] = 0.0;
    queue.add(startNode);

    while (!queue.isEmpty()) {
      currentindex = queue.remove();
      if (currentindex == endNode){
        break;
      }
      for (int edgeIndex : graph.getNeighbours(currentindex)) {
        Edge edge = graph.getEdges().get(edgeIndex);
        double cost = distance[currentindex] + edge.getCost();
        if (cost < distance[edge.getDestinationIndex()]) {
            distance[edge.getDestinationIndex()] = cost;
            previous[edge.getDestinationIndex()] = currentindex;
            queue.add(edge.getDestinationIndex());
        }
    }

  }
            List<Integer> path = new ArrayList<>();
            int current = endNode;
            while (previous[current] != -1 || current != startNode) {
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
                    Node uNode = graph.getNodes().get(uIndex);
                    Edge edges = graph.getEdges().get(graph.getEdgeIndex(uIndex, vIndex));
                    pathNodes.add(uNode);
                    pathEdges.add(edges);
                }
                pathNodes.add(graph.getNodes().get(endNode));
        }
        return path;
    }

@Override
public void setGraph(Graph graph) {
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
public List<Integer> getPathEdges() {
    List<Integer> edges = new ArrayList<>();
    for (Edge edge : pathEdges) {
        edges.add(edge.getIndex());
    }
    return edges;
}

@Override
public List<Integer> getPath() {
    return findPath(graph, startNode, endNode);
}


@Override
public int getStartNode() {
    return startNode;
}


@Override
public int getEndNode() {
    return endNode;
}


}
