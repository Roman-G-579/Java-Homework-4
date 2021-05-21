package graph;

import java.util.*;

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

    public boolean isSolvable() {
        //creates a new graph using the 'place' type for its elements
        Graph<Place> graph = new Graph<>();
        Set<Place> helpSet = new HashSet<>();

        Place startingPoint = new Place(startX, startY, size);
        Place endingPoint = new Place(endX, endY, size);
        Place currentPlace = null;

        try {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (!maze[i][j].equals("@")) {
                        currentPlace = new Place(i, j, size);
                        graph.addVertex(currentPlace);
                        helpSet.add(currentPlace);
                    }
                }
            }
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    //checks whether the current place is connected to the place on its left
                    if (j != 0 && !maze[i][j - 1].equals("@")) {
                        graph.addEdge(currentPlace, new Place(i, j - 1, size));
                    }
                    //checks whether the current place is connected to the place above
                    if (i != 0 && !maze[i - 1][j].equals("@")) {
                        graph.addEdge(currentPlace, new Place(i - 1, j, size));
                    }
                }
            }
            return graph.connected(startingPoint, endingPoint);
        } catch (GraphException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Collection<Place> neighbours(Place p) {// FIXME: 21/05/2021 check if possible to clean this method, if not, check if every point is valid
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


//checks whether the current place is connected to the place on its right
/*                        if (j != size && !maze[i][j + 1].equals("@")) {
                            graph.addEdge(currentPlace, new Place(i, j + 1, size));
                        }
                        //checks whether the current place is connected to the place below
                        if (i != size && !maze[i + 1][j].equals("@")) {
                            Place nextPlace = new Place(i + 1, j, size);
                            graph.addEdge(currentPlace, nextPlace);
                        }*/