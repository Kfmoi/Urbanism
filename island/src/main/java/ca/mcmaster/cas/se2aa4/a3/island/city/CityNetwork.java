package ca.mcmaster.cas.se2aa4.a3.island.city;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import ca.mcmaster.cas.se2aa4.a3.island.components.ComponentCollections;
import ca.mcmaster.cas.se2aaa4.a4.pathfinder.graphADT.Graph;
import ca.mcmaster.cas.se2aaa4.a4.pathfinder.graphADT.Node;

public class CityNetwork implements City {
    private Graph graph;
    private int numberOfCities;
    private long seed;
    private Random rand;


    public CityNetwork(long seed, int numberOfCities) {
        this.rand = new Random(seed);
        this.numberOfCities = numberOfCities;
    }

    @Override
    public Set<Integer> assignCityTiles(ComponentCollections collections) {
        Set<Integer> cityTiles = new HashSet<>();
        List<Integer> otherTiles = new ArrayList<>();
        collections.getNonCityPoints().forEach((index) -> otherTiles.add(index));
        numberOfCities = Math.min(otherTiles.size(), numberOfCities);

        while(cityTiles.size() < numberOfCities) {
            cityTiles.add(otherTiles.remove(new Random().nextInt(0,otherTiles.size())));
        }
        return cityTiles;
    }

    public void createNetwork(ComponentCollections collections){
        List<Node> nodes = new ArrayList<>(collections.getAllTiles().size());
        List<List<Integer>> neighList = new ArrayList<>();
        Set<Integer> cityTiles = assignCityTiles(collections);
        graph = new GraphImp(cityTiles.size());

        int index = 0;
        Iterable<Integer> allTiles = collections.getAllTileIdxs();
        for (Integer tile : allTiles) {
            nodes.set(collections.getTileIndex(tile), new NodeImp(0, collections.getTileIndex(tile)));
        }

        Integer centroixIndex;
        index = 0;
        for (int i = 0; i < nodes.size(); i++) {
            neighList = new ArrayList<>();
        }

        for (int i = 0; i < nodes.size(); i++) {
            graph.addNode(nodes.get(i));
            centroixIndex = (Integer) (nodes.get(i).getProperty("centroid"));
            for (Integer neighbour : collections.getTileNeighbourIdxs(centroixIndex)){
                if (collections.isNonCityTile(neighbour)){
                    graph.addEdge(new EdgeImp(index, 1.0, i, collections.getTileIndex(neighbour)));
                    neighList.get(i).add(collections.getTileIndex(neighbour));
                    index++;
                }
            }
        }
        for (int i = 0; i < nodes.size(); i++) {
            graph.setNeighbours(i, neighList.get(i));
        }
    }

}
