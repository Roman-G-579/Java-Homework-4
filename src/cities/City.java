package cities;

public class City {

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
}
