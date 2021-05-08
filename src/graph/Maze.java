package graph;

import java.util.Collection;

public class Maze implements GraphInterface<Place> {

    private int size;
    private int startX;
    private int startY;
    private int endX;
    private int endY;

    private String[][] maze;

    public Maze(int size, int startX, int startY, int endX, int endY) {
        this.size = size;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;

        if (startX > size - 1 || startY > size - 1
                || endX > size - 1 || endY > size - 1) {
            throw new IllegalArgumentException();
        }

        maze = new String[size][size];
        maze[startX][startY] = "S";
        maze[endX][endY] = "E";
    }

    public boolean addWall(int x, int y) {
        //checks whether the given coordinate already exists in the maze
        if (maze[x][y].equals("@") ||
                (x == startX && y == startY) || (x == endX && y == endY)) {
            return false;
        }

        if (x > size - 1 || y > size - 1) {
            throw new IllegalArgumentException();
        }

        maze[x][y] = "@";
        return true;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                str.append(maze[i][j]);
            }
            str.append("\n");
        }
        return str.toString();
    }

    public boolean isSolvable() {
        Graph<Place> graph = new Graph<>();
    }

    public Collection<Place> neighbours(Place c){

    }
}
