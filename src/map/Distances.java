package map;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

public class Distances {
    public static void main(String[] args) {

        //read in the graph from a file
        In graphin = new In("usa.txt");
        EuclideanGraph G = new EuclideanGraph(graphin);
        Dijkstra dijkstra = new Dijkstra(G);
        System.err.println("Done reading the graph " + "usa.txt");
        System.err.println("Enter query pairs from stdin");

        //read in the s-d pairs from standard input
        while (!StdIn.isEmpty()) {
            int s = StdIn.readInt();
            int d = StdIn.readInt();
            System.out.println(dijkstra.distance(s, d));
        }
    }
}