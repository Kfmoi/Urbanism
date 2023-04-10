package ca.mcmaster.cas.se2aaa4.a4.pathfinder.graphADT;



public interface Edge<T,G> {
    double getCost();
    Node<T,G> getStartNode();
    Node<T,G> getEndNode();
    void setStartNode(Node<T,G> startNode);
    void setEndNode(Node<T,G> endNode);
    void setCost(double cost);
    void setIndex(int index);
    int getIndex();
}
