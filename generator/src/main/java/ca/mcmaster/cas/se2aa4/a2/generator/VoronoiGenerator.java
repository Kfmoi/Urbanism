package ca.mcmaster.cas.se2aa4.a2.generator;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryCollection;
import org.locationtech.jts.triangulate.VoronoiDiagramBuilder;
import org.locationtech.jts.geom.Polygon;

import ca.mcmaster.cas.se2aa4.a2.components.Vertex;
import ca.mcmaster.cas.se2aa4.a2.components.Vert;
import ca.mcmaster.cas.se2aa4.a2.components.Segment;
import ca.mcmaster.cas.se2aa4.a2.components.Seg;
import ca.mcmaster.cas.se2aa4.a2.components.Poly;

import org.locationtech.jts.geom.Point;
import org.locationtech.jts.algorithm.Centroid;
import org.locationtech.jts.algorithm.ConvexHull;
import org.locationtech.jts.geom.Envelope;
import org.locationtech.jts.geom.PrecisionModel;
import org.locationtech.jts.triangulate.DelaunayTriangulationBuilder;

import ca.mcmaster.cas.se2aa4.a2.mesh.Mesh;
import java.util.*;

public class VoronoiGenerator implements Generator {

    private final Random randomX, randomY;
    private final int numPoints, relaxationLevel;
    final static PrecisionModel HUNDREDTH_PRECISION_MODEL = new PrecisionModel(100);
    public final static int MIN_NUM_POINTS = 20, MIN_RELAXATION_LEVEL = 0;

    public VoronoiGenerator(int numPoints, int relaxationLevel) {
        this.numPoints = Math.max(numPoints, MIN_NUM_POINTS);
        this.relaxationLevel = Math.max(relaxationLevel, MIN_RELAXATION_LEVEL);
        randomX = new Random();
        randomY = new Random();
        warnUser(numPoints, MIN_NUM_POINTS, "NUMBER POINTS");
        warnUser(relaxationLevel, MIN_RELAXATION_LEVEL, "RELAXATION LEVEL");
    }

    public VoronoiGenerator(int numPoints, int relaxationLevel, long seedX, long seedY) {
        this.numPoints = Math.max(numPoints, MIN_NUM_POINTS);
        this.relaxationLevel = Math.max(relaxationLevel, MIN_RELAXATION_LEVEL);
        randomX = new Random(seedX);
        randomY = new Random(seedY);
        warnUser(numPoints, MIN_NUM_POINTS, "NUMBER POINTS");
        warnUser(relaxationLevel, MIN_RELAXATION_LEVEL, "RELAXATION LEVEL");
    }

    static void warnUser(int givenValue, int setValue, String subject) {
        if (givenValue < setValue) {
            System.out.println(String.format(
                    "WARNING: The given value of %1$s was set below the minimum value of %2$s for argument %3$s. Setting %3$s to Default value %2$s",
                    givenValue, setValue, subject));
        }

    }

    @Override
    public void generate(final Mesh mesh) {
        List<Coordinate> randCoord = RandomCoords(mesh.getHeight(), mesh.getWidth());
        List<Polygon> polygons = createPolygons(randCoord);
        for (int i = 0; i < relaxationLevel; i++) {
            randCoord = relaxAllCentroids(polygons, mesh.getHeight(), mesh.getWidth());
            polygons = createPolygons(randCoord);
        }
        // List<Coordinate> deulayneyPol = relaxAllCentroids(polygons, mesh.getHeight(),
        // mesh.getWidth());
        // Will add Delaunay implementation later
        //List<Polygon> deulPoly = new ArrayList<>();

        List<Poly> finalPolys = convertPolygons(polygons, /* deulPoly, */ mesh.getHeight(), mesh.getWidth());

        addAllComponents(mesh, finalPolys);
    }

    /**
     * Adds all the necessary components generated by the polygon to the given mesh.
     *
     * @param mesh     the Mesh to add all components to.
     * @param polygons the list of Polygons from which all relevant components are
     *                 generated.
     */
    void addAllComponents(final Mesh mesh, final List<Poly> polygons) {
        Vert v;
        Seg s;
        List<double[]> vertices;
        for (Poly p : polygons) {
            vertices = p.getVertexList();
            // Add the first vertex of this polygon
            v = new Vertex(vertices.get(0)[0], vertices.get(0)[1]);
            mesh.addVert(v);
            // Add remaining vertices, and since they are ordered radially, they are
            // adjacent to the vertices before and after them.
            // As a result, a segment can be made with this vertex and the vertex before, so
            // add that as well.
            for (int i = 1; i < vertices.size(); i++) {
                v = new Vertex(vertices.get(i)[0], vertices.get(i)[1]);
                mesh.addVert(v);
                s = new Segment(vertices.get(i - 1)[0], vertices.get(i - 1)[1], vertices.get(i)[0], vertices.get(i)[1]);
                mesh.addSeg(s);
            }
            // Add the segment that connects the first vertex with the last one.
            s = new Segment(vertices.get(0)[0], vertices.get(0)[1], vertices.get(vertices.size() - 1)[0],
                    vertices.get(vertices.size() - 1)[1]);
            mesh.addSeg(s);
            mesh.addPoly(p);
        }
    }

    public List<Polygon> createPolygons(List<Coordinate> coords) {
        double height = 500;
        double width = 500;

        GeometryFactory geomfactory = new GeometryFactory(HUNDREDTH_PRECISION_MODEL);

        VoronoiDiagramBuilder voronoiBuilder = new VoronoiDiagramBuilder();
        Envelope size = new Envelope(0, width, 0, height);
        voronoiBuilder.setClipEnvelope(size);
        voronoiBuilder.setSites(coords);

        Geometry createdPolys = voronoiBuilder.getSubdivision().getVoronoiDiagram(geomfactory);

        List<Polygon> polygonList = new ArrayList<>();

        GeometryCollection geomCollection = (GeometryCollection) createdPolys;
        for (int j = 0; j < geomCollection.getNumGeometries(); j++) {
            Polygon polygon = (Polygon) geomCollection.getGeometryN(j);
            polygonList.add(polygon);

        }

        Collections.sort(polygonList, new PolygonComparator());
        return polygonList;
    }

    List<Coordinate> RandomCoords(final int height, final int width) {
        List<Coordinate> coords = new ArrayList<>();

        for (int i = 1; i < numPoints; i++) {
            int pointX = randomX.nextInt((height / 5) * 4 + 1);
            int pointY = randomY.nextInt((width / 5) * 4 + 1);
            coords.add(new Coordinate(pointX, pointY));
        }
        return coords;
    }

    private List<double[]> getVertices(final Polygon polygon) {
        GeometryFactory geomFactory = new GeometryFactory(HUNDREDTH_PRECISION_MODEL);
        Coordinate[] coordinates = new Coordinate[10];
        List<double[]> vertices = new ArrayList<>();
        coordinates = polygon.getCoordinates();
        ConvexHull convexHull = new ConvexHull(coordinates, geomFactory);
        Geometry convexPoly = convexHull.getConvexHull();
        for (Coordinate c : convexPoly.getCoordinates()) {
            vertices.add(new double[] { c.getX(), c.getY() });
        }

        return vertices;
    }

    private List<Poly> convertPolygons(final List<Polygon> voronoi, /* final List<Polygon> delauney, */ int height,
            int width) {
        final List<Poly> polys = new ArrayList<>();
        ca.mcmaster.cas.se2aa4.a2.components.Polygon p;
        for (Polygon polygon : voronoi) {
            Coordinate centroidCoord = boundCentroid(polygon, height, width);
            p = new ca.mcmaster.cas.se2aa4.a2.components.Polygon(centroidCoord.getX(), centroidCoord.getY());
            p.setVertices(getVertices(polygon));
            p.setNeighbours(new ArrayList<>());
            polys.add(p);

        }

        return polys;
    }

    // returns coordinate list to pass into createPolygon to smoothen shapes using
    // Lloyd relaxation
    List<Coordinate> getCentroids(final List<Polygon> polygons) {
        List<Coordinate> centroids = new ArrayList<>();
        for (Polygon p : polygons) {
            centroids.add(new Coordinate(p.getCentroid().getX(), p.getCentroid().getY()));
        }
        centroids.sort(Comparator.comparing(Coordinate::getX).thenComparing(Coordinate::getY));
        return centroids;
    }

    Coordinate boundCentroid(final Polygon p, int height, int width) {
        double x = p.getCentroid().getX();
        double y = p.getCentroid().getY();
        x = Math.min(Math.max(x, 0), width);
        y = Math.min(Math.max(y, 0), height);
        return new Coordinate(x, y);
    }

    List<Coordinate> relaxAllCentroids(final List<Polygon> polygons, int height, int width) {
        List<Coordinate> centroids = new ArrayList<>();
        for (Polygon p : polygons) {
            centroids.add(boundCentroid(p, height, width));
        }
        centroids.sort(Comparator.comparing(Coordinate::getX).thenComparing(Coordinate::getY));
        return centroids;
    }

    double[] convertCentroid(final Polygon polygon) {
        return new double[] { polygon.getCentroid().getX(), polygon.getCentroid().getY() };

    }

    private class PolygonComparator implements Comparator<Polygon> {
        @Override
        public int compare(Polygon p1, Polygon p2) {
            int comp = Double.compare(p1.getCentroid().getX(), p2.getCentroid().getX());
            if (comp != 0) {
                return comp;
            }
            return Double.compare(p1.getCentroid().getY(), p2.getCentroid().getY());
        }
    }

}
