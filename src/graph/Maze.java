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

    //adds a boundary to the maze
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

    //prints a representation of the maze
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

    //creates a graph using a maze's structure, and checks whether its possible
    //to establish a connection between the start and end points
    public boolean isSolvable() {
        //creates a new graph using the 'place' type for its elements
        Graph<Place> graph = new Graph<>();

        Place startingPoint = new Place(startX, startY, size);
        Place endingPoint = new Place(endX, endY, size);

        try {
            //places the vertices on the graph
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (!maze[i][j].equals("@")) {
                        graph.addVertex(new Place(i, j, size));
                    }
                }
            }
            //connects the vertices on the graph
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (maze[i][j].equals("@")) {
                        continue;
                    }
                    //checks whether the current place is connected to the place on its left
                    if (j != 0 && !maze[i][j - 1].equals("@")) {
                        graph.addEdge(new Place(i, j, size), new Place(i, j - 1, size));
                    }
                    //checks whether the current place is connected to the place above
                    if (i != 0 && !maze[i - 1][j].equals("@")) {
                        graph.addEdge(new Place(i, j, size), new Place(i - 1, j, size));
                    }
                }
            }
            //checks whether a connection between the points is possible
            return graph.connected(startingPoint, endingPoint);
        } catch (GraphException e) {
            e.printStackTrace();
        }
        return false;
    }

    //returns a list of the potential neighbours of a given place in the maze
    public Collection<Place> neighbours(Place p) {
        ArrayList<Place> neighboursList = new ArrayList<>();

        //checks whether the current place is a valid edge in the maze
        if (p.getX() > size || p.getY() > size || p.getX() < 0 || p.getY() < 0) {
            return null;
        }

        //checks the neighbours from all direction of the given place
        if (p.getY() > 0 && !maze[p.getX()][p.getY() - 1].equals("@")) {
            neighboursList.add(new Place(p.getX(), p.getY() - 1, size));
        }
        if (p.getX() < size - 1 && !maze[p.getX() + 1][p.getY()].equals("@")) {
            neighboursList.add(new Place(p.getX() + 1, p.getY(), size));
        }
        if (p.getY() < size - 1 && !maze[p.getX()][p.getY() + 1].equals("@")) {
            neighboursList.add(new Place(p.getX(), p.getY() + 1, size));
        }
        if (p.getX() > 0 && !maze[p.getX() - 1][p.getY()].equals("@")) {
            neighboursList.add(new Place(p.getX() - 1, p.getY(), size));
        }
        return neighboursList;
    }
}