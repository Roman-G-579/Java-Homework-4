package graph;

import java.util.ArrayList;
import java.util.Arrays;
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
        for (String[] row : maze) {
            Arrays.fill(row, ".");
        }
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

//    public boolean isSolvable() throws GraphException {
//        Place startPoint = new Place(startX, startY, size);
//        Place endPoint = new Place(endX, endY, size);
//
//        graph.addVertex(startPoint);
//        graph.addVertex(endPoint);
//        return true;
//    }

    public Collection<Place> neighbours(Place p) {
        ArrayList<Place> neighboursList = new ArrayList<>();


        if (!maze[p.getX() - 1][p.getY() - 1].equals("@")) {
            neighboursList.add(new Place(p.getX() - 1, p.getY() - 1, size));
        }
        if (!maze[p.getX()][p.getY() - 1].equals("@")) {
            neighboursList.add(new Place(p.getX(), p.getY() - 1, size));
        }
        if (maze[p.getX() + 1][p.getY() - 1].equals("@")) {
            neighboursList.add(new Place(p.getX() + 1, p.getY() - 1, size));
        }
        if (maze[p.getX() + 1][p.getY()].equals("@")) {
            neighboursList.add(new Place(p.getX() + 1, p.getY(), size));
        }
        if (!maze[p.getX() + 1][p.getY() + 1].equals("@")) {
            neighboursList.add(new Place(p.getX() + 1, p.getY() + 1, size));
        }
        if (!maze[p.getX()][p.getY() + 1].equals("@")) {
            neighboursList.add(new Place(p.getX(), p.getY() + 1, size));
        }
        if (maze[p.getX() - 1][p.getY() + 1].equals("@")) {
            neighboursList.add(new Place(p.getX() - 1, p.getY() + 1, size));
        }
        if (maze[p.getX() - 1][p.getY()].equals("@")) {
            neighboursList.add(new Place(p.getX() - 1, p.getY(), size));
        }
        return neighboursList;
    }
}
