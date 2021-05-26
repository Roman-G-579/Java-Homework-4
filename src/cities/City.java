package cities;

import java.util.Objects;

public class City implements Comparable<City> {

    private String name;
    private Country country;
    private int population;

    public City(String name, Country country, int population) {
        this.name = name;
        this.country = country;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public int getPopulation() {
        return population;
    }

    public String toString() {
        return name + " (of " + country + ")";
    }

    @Override
    public boolean equals(Object o) {
        City city = (City) o;
        return Objects.equals(name, city.name) && Objects.equals(country, city.country);
    }

    //compares two cities by the country name and then the city name
    @Override
    public int compareTo(City otherCity) {
        int comparison = getCountry().compareTo(otherCity.getCountry());

        if (comparison == 0) {
            return getName().compareTo(otherCity.getName());
        }
        return comparison;
    }
}