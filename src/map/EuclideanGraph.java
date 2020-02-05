package map;

import java.util.Iterator;

import edu.princeton.cs.algs4.In;

public class EuclideanGraph {
    private int V;// ���������
    private int E;// �ߵ�����
    private Node[] adj;// �ڽӱ�
    private Point[] points;    // ƽ���еĵ�

    //		�����ڽӱ�� Node ��
    private static class Node {
        int v;    //��ǰ�� Node ���
        Node next; //�ڽӵ� Node

        Node(int v, Node next) {
            this.v = v;
            this.next = next;
        }
    }

    //		��ӱ�ĵ�����

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

    //���ļ��ж�ȡ��ͼ�������м��

    public EuclideanGraph(In in) {
        V = Integer.parseInt(in.readString());
        E = Integer.parseInt(in.readString());

        //		��ȡƽ���еĶ���
        points = new Point[V];
        for (int i = 0; i < V; i++) {
            int v = Integer.parseInt(in.readString());
            int x = Integer.parseInt(in.readString());
            int y = Integer.parseInt(in.readString());
            if (v < 0 || v >= V)
                throw new RuntimeException("Illegal vertex number");
            points[v] = new Point(x, y);
        }

        //		��ȡƽ���еı�

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

    //		���ʷ���
    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public Point point(int i) {
        return points[i];
    }

    //		����� v �� w ��ŷ����þ���
    public double distance(int v, int w) {
        return points[v].distanceTo(points[w]);
    }

    //		���� v ���ھ��б�ĵ�����

    public Iterator neighbors(int v) {
        return new AdjListIterator(adj[v]);
    }

    //		�ַ�����ʾ��
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

    //		����ͼ��
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