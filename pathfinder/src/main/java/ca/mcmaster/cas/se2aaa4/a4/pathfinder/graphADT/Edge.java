package ca.mcmaster.cas.se2aaa4.a4.pathfinder.graphADT;



public interface Edge {
    double getCost();
    int getDestinationIndex();
    int getSourceIndex();
    void setDestinationIndex(int destinationIndex);
    void setSourceIndex(int sourceIndex);
    void setCost(double cost);
    void setIndex(int index);
    int getIndex();
}
