package ca.mcmaster.cas.se2aaa4.a4.pathfinder.graphADT;


public class EdgeImpl<T,G> implements Edge<T,G> {

    private double cost;
    private Node<T,G> startNode;
    private Node<T,G> endNode;
    private int index;

    public EdgeImpl(Node<T,G> startNode, Node<T,G> endNode, double cost, int index) {
        this.startNode = startNode;
        this.endNode = endNode;
        this.cost = cost;
        this.index = index;
    }


    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public Node<T, G> getStartNode() {
        return startNode;
    }

    @Override
    public Node<T, G> getEndNode() {
        return endNode;
    }

    @Override
    public void setStartNode(Node<T, G> startNode) {
        this.startNode = startNode;
    }

    @Override
    public void setEndNode(Node<T, G> endNode) {
        this.endNode = endNode;
    }

    @Override
    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public int getIndex() {
        return index;
    }
    
}

