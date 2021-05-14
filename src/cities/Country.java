package cities;

import java.util.*;

public class Country implements Comparable<Country> {

    private Set<City> cities = new TreeSet<>();
    private String name;

    public Country(String name) {
        this.name = name;
    }

    private String getName() {
        return name;
    }

    public void addCity(City city) {
        if (!city.getCountry().equals(this)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    public int population() {
        int totalPopulation = 0;
        for (City city : cities) {
            totalPopulation += city.getPopulation();
        }
        return totalPopulation;
    }

    public String toString() {
        return getName();
    }

    public List<City> smallCities(int under) {
        List<City> underCity = new ArrayList<>();
        for (City city : cities) {
            if (city.getPopulation() < under) {
                underCity.add(city);
            }
        }
        return underCity;
    }

    public String report() {
        StringBuilder report = new StringBuilder();

        report.append(getName()).append("(").append(population()).append(")").append(" : ");
        for (City city : cities) {
            report.append(city.getName()).append("(").append(city.getPopulation()).append("), ");
        }
        return report.delete(report.length() - 2, report.length()).toString();
    }

    @Override
    public int compareTo(Country otherCountry) {
        return getName().compareTo(otherCountry.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return name.equals(country.name);
    }
}
