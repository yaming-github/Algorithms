package map;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

public class Paths {
    public static void main(String[] args) {
        //		read in the graph from a file
        String filename = "usa.txt";
        In graphin = new In(filename);
        Turtle.create(1000, 700);
        EuclideanGraph G = new EuclideanGraph(graphin);
        System.out.println("完成图的读取 " + filename);
        System.out.println("请输入查找对");
        G.draw();

        //		read in the s-d pairs from standard input
        Dijkstra dijkstra = new Dijkstra(G);
        while (!StdIn.isEmpty()) {
            int s = StdIn.readInt();
            int d = StdIn.readInt();
            dijkstra.showPath(s, d);
            dijkstra.drawPath(s, d);
            System.out.println();
        }
    }
}
