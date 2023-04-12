package ca.mcmaster.cas.se2aa4.a3.island.city;

public class AbstractCityNetwork extends AbstractCityFactory{
    
    @Override
    public City createCity(long seed, int maxCities) {
        return new CityNetwork(seed, maxCities);
    }
}
