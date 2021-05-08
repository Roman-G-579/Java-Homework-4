package cities;

import java.util.*;

public class Country {

    private Set<City> cities;
    private int totalPopulation;
    private String name;

    public Country(String name) {
        this.name = name;
        cities = new HashSet<>();
    }

    public void addCity(City city) {
        cities.add(city);
    }

    public int population() {
        for (City city : cities) {
            totalPopulation += city.getPopulation();
        }
        return totalPopulation;
    }

    public String toString() {
        return name;
    }

    public List<City> smallCities(int under) {
        List<City> underCity = new ArrayList<>();

        for (City city : cities) {
            if (city.getPopulation() < under) {
                underCity.add(city);
            }
        }
        return Collections.sort(underCity);
    }

    public String report() {
        StringBuilder report = new StringBuilder();

        report.append(name).append("(").append(totalPopulation).append(")").append(" : ");
        for (City city : cities) {
            report.append(city.getName()).append("(").append(city.getPopulation()).append("),");
        }
        return report.delete(report.length() - 1, report.length()).toString();
    }
}
