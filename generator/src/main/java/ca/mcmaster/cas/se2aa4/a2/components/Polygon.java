package ca.mcmaster.cas.se2aa4.a2.components;

import java.util.List;

/**
 * Polygon class which serves as a high-level recorder for the data generated by
 * the Generator and any properties from the Mesh when finalized before
 * conversion.
 */
public class Polygon implements Poly {

    static int COLOUR_BIT_SIZE = 8;
    private double centroidX, centroidY;
    private float borderThickness;
    private int fillColour, borderColour;

    private List<double[]> verticesList;

    private List<double[]> neighbourList;

    public Polygon() {
    }

    public Polygon(double x, double y) {
        this();
        setCentroid(x, y);
    }

    @Override
    public int compareTo(Poly p) {
        int comp = Double.compare(centroidX, p.getCentroidX());
        return (comp != 0) ? comp : Double.compare(centroidY, p.getCentroidY());
    }

    @Override
    public List<double[]> getNeigbourList() {
        return neighbourList;
    }

    @Override
    public List<double[]> getVertexList() {
        return verticesList;
    }

    @Override
    public double getCentroidX() {
        return centroidX;
    }

    @Override
    public double getCentroidY() {
        return centroidY;
    }

    @Override
    public float getBorderThickness() {
        return borderThickness;
    }

    @Override
    public int getFillColour() {
        return fillColour;
    }

    @Override
    public int getBorderColour() {
        return borderColour;
    }

    @Override
    public void setCentroid(double x, double y) {
        centroidX = x;
        centroidY = y;
    }

    @Override
    public void setBorderThickness(float t) {
        borderThickness = t;
    }

    @Override
    public void setNeighbours(List<double[]> neighbourCentroidList) {
        neighbourList = neighbourCentroidList;
    }

    @Override
    public void setVertices(List<double[]> verticesList) {
        this.verticesList = verticesList;
    }

    @Override
    public void setFillColour(int r, int g, int b, int a) {
        fillColour = toSRGB(r, g, b, a);
    }

    @Override
    public void setBorderColour(int r, int g, int b, int a) {
        borderColour = toSRGB(r, g, b, a);
    }

    @Override
    public void setFillColour(int rgba) {
        fillColour = rgba;
    }

    @Override
    public void setBorderColour(int rgba) {
        borderColour = rgba;
    }

    /**
     * Converts the given red, green, blue, and alpha values into a single integer
     * following Java's sRGB model.
     *
     * @param r
     * @param g
     * @param b
     * @param a
     * @return the colour in Java's sRGB format.
     */
    private static int toSRGB(int r, int g, int b, int a) {
        return (((((a << COLOUR_BIT_SIZE) | r) << COLOUR_BIT_SIZE) | g) << COLOUR_BIT_SIZE) | b;
    }

}
