package ca.mcmaster.cas.se2aaa4.a4.pathfinder.graphADT;


public interface Node<T,G> {
        T getValue();
        G getWeight();
        void setWeight(G weight);
        void setValue (T value);
        void setIndex (int index);
        int getIndex();
    }