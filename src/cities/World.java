package cities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class World {

    private Map<String, Country> countries = new TreeMap<>();

    public void addCountry(String name) {
        countries.put(name, new Country(name));
    }

    public void addCity(String name, String countryName, int population) throws IllegalArgumentException {
        if(countries.containsKey(countryName)) {
            Country country = countries.get(countryName);
            country.addCity(new City(name,  country, population));
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int population() {
        int total = 0;
        for(Map.Entry<String, Country> entry : countries.entrySet()){
            total += entry.getValue().population();
        }
        return total;
    }

    public List<City> smallCities(int under) {
        List<City> underCity = new ArrayList<>();
        for(Map.Entry<String, Country> entry : countries.entrySet()){
            underCity.addAll(entry.getValue().smallCities(under));
        }
        return underCity;
    }

    public String report(){
        StringBuilder report = new StringBuilder();
        for(Map.Entry<String, Country> entry : countries.entrySet()){
            report.append(entry.getValue().report()).append("\n");
        }
        report.append("Total population is ").append(population()).append("\n");
        return report.toString();
    }
}
