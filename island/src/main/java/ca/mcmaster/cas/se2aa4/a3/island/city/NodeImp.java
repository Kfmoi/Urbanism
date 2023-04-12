package ca.mcmaster.cas.se2aa4.a3.island.city;

import java.util.HashMap;
import java.util.Map;

import ca.mcmaster.cas.se2aaa4.a4.pathfinder.graphADT.Node;

public class NodeImp implements Node{
    private double cost;
    private Map<String, Object> properties = new HashMap<>();
    private int index;

    public NodeImp(double cost, int index) {
        this.cost = cost;
        this.index = index;
    }



    @Override
    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public int getIndex() {
        return index;
    }



    @Override
    public double getCost() {
        return cost;
    }



    @Override
    public void setCost(double cost) {
        this.cost = cost;
    }



    @Override
    public Object getProperty(String property) {
        return properties.get(property);
    }



    @Override
    public void setProperty(String property, Object value) {
        properties.put(property, value);
    }


    
}
 

