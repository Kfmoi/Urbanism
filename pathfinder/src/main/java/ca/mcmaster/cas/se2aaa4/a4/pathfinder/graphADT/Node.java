package ca.mcmaster.cas.se2aaa4.a4.pathfinder.graphADT;


public interface Node {
        double getCost();
        void setCost(double cost);
        void setIndex (int index);
        int getIndex();
        Object getProperty(String property);
        void setProperty(String property, Object value);
    }