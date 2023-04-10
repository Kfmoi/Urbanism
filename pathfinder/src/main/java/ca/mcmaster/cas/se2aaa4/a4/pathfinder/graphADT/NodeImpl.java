package ca.mcmaster.cas.se2aaa4.a4.pathfinder.graphADT;


public class NodeImpl<T,G> implements Node<T,G> {
    private T value;
    private G weight;
    private int index;

    public NodeImpl(T value, G weight, int index) {
        this.value = value;
        this.weight = weight;
        this.index = index;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public G getWeight() {
        return weight;
    }

    @Override
    public void setWeight(G weight) {
        this.weight = weight;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
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
 

