package map;

import java.util.Iterator;

import edu.princeton.cs.algs4.In;

public class EuclideanGraph {
    private int V;// 顶点的数量
    private int E;// 边的数量
    private Node[] adj;// 邻接表
    private Point[] points;    // 平面中的点

    //		用于邻接表的 Node 类
    private static class Node {
        int v;    //当前的 Node 编号
        Node next; //邻接的 Node

        Node(int v, Node next) {
            this.v = v;
            this.next = next;
        }
    }

    //		领接表的迭代器

    private class AdjListIterator implements Iterator {
        private Node x;

        AdjListIterator(Node x) {
            this.x = x;
        }

        public boolean hasNext() {
            return x != null;
        }

        public Object next() {
            int v = x.v;
            x = x.next;
            return v;
        }
    }

    //从文件中读取地图，并进行检查

    public EuclideanGraph(In in) {
        V = Integer.parseInt(in.readString());
        E = Integer.parseInt(in.readString());

        //		读取平面中的顶点
        points = new Point[V];
        for (int i = 0; i < V; i++) {
            int v = Integer.parseInt(in.readString());
            int x = Integer.parseInt(in.readString());
            int y = Integer.parseInt(in.readString());
            if (v < 0 || v >= V)
                throw new RuntimeException("Illegal vertex number");
            points[v] = new Point(x, y);
        }

        //		读取平面中的边

        adj = new Node[V];
        for (int i = 0; i < E; i++) {
            int v = Integer.parseInt(in.readString());
            int w = Integer.parseInt(in.readString());
            if (v < 0 || v >= V)
                throw new RuntimeException("Illegal vertex number");
            if (w < 0 || w >= V)
                throw new RuntimeException("Illegal vertex number");
            adj[v] = new Node(w, adj[v]);
            adj[w] = new Node(v, adj[w]);
        }
    }

    //		访问方法
    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public Point point(int i) {
        return points[i];
    }

    //		计算从 v 到 w 的欧几里得距离
    public double distance(int v, int w) {
        return points[v].distanceTo(points[w]);
    }

    //		返回 v 的邻居列表的迭代器

    public Iterator neighbors(int v) {
        return new AdjListIterator(adj[v]);
    }

    //		字符串表示法
    public String toString() {
        String s = "";
        String NEWLINE = System.getProperty("line.separator");
        s += "V = " + V + NEWLINE;
        s += "E = " + E + NEWLINE;
        for (int v = 0; v < V && v < 1000; v++) {
            String t = v + " " + points[v] + ": ";
            for (Node x = adj[v]; x != null; x = x.next)
                t += x.v + " ";
            s += t + NEWLINE;
        }
        return s;
    }

    //		绘制图形
    public void draw() {
        for (int v = 0; v < V; v++) {
            //	    	points[v].draw();
            for (Node x = adj[v]; x != null; x = x.next) {
                int w = x.v;
                points[v].drawTo(points[w]);
            }
        }
        Turtle.render();
    }

    public static void main(String args[]) {
        Turtle.create(1000, 700);
        In in = new In("usa.txt");
        EuclideanGraph G = new EuclideanGraph(in);
        System.out.println(G);
        G.draw();
    }
}