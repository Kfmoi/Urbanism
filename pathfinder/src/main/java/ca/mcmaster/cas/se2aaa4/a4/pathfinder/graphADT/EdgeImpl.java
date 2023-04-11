package ca.mcmaster.cas.se2aaa4.a4.pathfinder.graphADT;


public class EdgeImpl implements Edge {

    private double cost;
    private int sourceIndex;
    private int destinationIndex;
    private int index;

    public EdgeImpl(int index, double cost, int sourceIndex, int destinationIndex) {
        this.cost = cost;
        this.sourceIndex = sourceIndex;
        this.destinationIndex = destinationIndex;
        this.index = index;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public int getDestinationIndex() {
        return destinationIndex;
    }

    @Override
    public int getSourceIndex() {
        return sourceIndex;
    }

    @Override
    public void setDestinationIndex(int destinationIndex) {
        this.destinationIndex = destinationIndex;
    }

    @Override
    public void setSourceIndex(int sourceIndex) {
        this.sourceIndex = sourceIndex;
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

