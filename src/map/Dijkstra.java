package map;

import java.awt.Color;
import java.util.Iterator;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

public class Dijkstra {
    private static double INFINITY = Double.MAX_VALUE;    //无穷大
    private static double EPSILON = 0.000001;    //无穷小
    private EuclideanGraph G;
    private double[] dist;
    private int[] pred;
    public double time;

    public Dijkstra(EuclideanGraph G) {
        this.G = G;
    }

    //返回执行算法的时间

    public double GetTime() {
        return time;
    }

    // 返回 s 到 d 的最短距离

    public double distance(int s, int d) {
        dijkstra(s, d, 1);
        return dist[d];
    }

    //		打印从 s 到 d 的最短路径（交换 s 和 d 以正确的顺序打印）
    public void showPath(int d, int s) {
        dijkstra(s, d, 1);
        if (pred[d] == -1) {
            System.out.println(d + " is unreachable from " + s);
            return;
        }
        for (int v = d; v != s; v = pred[v])
            System.out.print(v + "-");
        System.out.println(s);
    }
    //		在图形中划出 s 到 d 的最短路径

    public void drawPath(int s, int d) {
        dijkstra(s, d, 1);
        if (pred[d] == -1)
            return;
        Turtle.setColor(Color.red);
        for (int v = d; v != s; v = pred[v])
            G.point(v).drawTo(G.point(pred[v]));
        Turtle.render();
    }

    //		Dijkstra 算法寻找从 s 到 d 的最短路径
    public void dijkstra(int s, int d, int flag) {
        Stopwatch timer = new Stopwatch();
        int V = G.V();

        //		初始化
        dist = new double[V];
        pred = new int[V];
        for (int v = 0; v < V; v++)
            dist[v] = INFINITY;
        for (int v = 0; v < V; v++)
            pred[v] = -1;

        //		索引优先队列
        IndexPQ pq = new IndexPQ(V);
        for (int v = 0; v < V; v++)
            pq.insert(v, dist[v]);

        //		设定源地址
        dist[s] = 0.0;
        pred[s] = s;
        pq.change(s, dist[s]);

        //		运行 Dijkstra 算法
        if (flag == 0) {
            while (!pq.isEmpty()) {
                int v = pq.delMin();
                if (pred[v] == -1)
                    break;
                //		扫描邻近 v 的所有节点 w
                Iterator i = G.neighbors(v);
                while (i.hasNext()) {
                    int w = (int) i.next();
                    if (dist[v] + G.distance(v, w) < dist[w] - EPSILON) {
                        dist[w] = dist[v] + G.distance(v, w);
                        pq.change(w, dist[w]);
                        pred[w] = v;
                    }
                }
            }
            time = timer.elapsedTime();
        } else if (flag == 1) {
            while (!pq.isEmpty()) {
                int v = pq.delMin();
                if (pred[v] == -1)
                    break;
                //		扫描邻近 v 的所有节点 w
                Iterator i = G.neighbors(v);
                while (i.hasNext()) {
                    int w = (int) i.next();
                    if (w == d) {
                        pred[w] = v;
                        time = timer.elapsedTime();
                        return;
                    }
                    if (dist[v] + G.distance(v, w) < dist[w] - EPSILON) {
                        dist[w] = dist[v] + G.distance(v, w);
                        pq.change(w, dist[w]);
                        pred[w] = v;
                    }
                }
            }
            time = timer.elapsedTime();
        }
    }

    public static void main(String[] args) {
        In graphin = new In("usa.txt");
        EuclideanGraph G = new EuclideanGraph(graphin);
        Dijkstra dijkstra = new Dijkstra(G);
        double time;
        int s = 0;
        int d = 50000;
        System.out.println("路径为：");
        dijkstra.showPath(s, d);
        time = dijkstra.GetTime();
        System.out.println("运行时间为：" + time + "s");
    }
}