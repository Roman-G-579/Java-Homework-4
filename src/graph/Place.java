package graph;

import java.util.Objects;

public class Place {

    private int x;
    private int y;
    private int bound;

    public Place(int x, int y, int bound) {
        this.x = x;
        this.y = y;
        this.bound = bound;

        if (x > bound - 1 || y > bound - 1){
            throw new IllegalArgumentException();
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return x == place.x && y == place.y && bound == place.bound;
    }

    //ensures that the returned hashes are as different from each other as possible
    @Override
    public int hashCode() {
        return Objects.hash(x, y, bound) * 31 + y;
    }
}
