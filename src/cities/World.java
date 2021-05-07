package cities;

import java.util.Map;

public class World {

    private Map<String, Country> countries;
    private int worldPopulation;

    public void addCountry(String name) {
        countries.put(name, new Country(name));
    }

    public void addCity(String name, String countryName, int population)
            throws IllegalArgumentException {
        countries.get(countryName).addCity(new City(name, countries.get(countryName), population));
    }

    public int population() {
        return 0;
    }
}
