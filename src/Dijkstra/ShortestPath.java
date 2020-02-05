package map;

import java.util.Scanner;

import edu.princeton.cs.algs4.In;

public class ShortestPath {
    public static void main(String[] args) {
        int s, d, count;
        double time1 = 0.0, time2 = 0.0;
        Scanner input = new Scanner(System.in);
        In graphin = new In("usa.txt");
        EuclideanGraph G = new EuclideanGraph(graphin);
        System.out.println("成功读取地图文件！");
        Dijkstra dijkstra = new Dijkstra(G);
        Dijkstra dijkstra1 = new Dijkstra(G);
        System.out.println("请输入最短路径查询的次数");
        count = input.nextInt();
        input.close();
        for (int i = 0; i < count; i++) {
            s = (int) (Math.random() * 87574);
            d = (int) (Math.random() * 87574);

            //System.out.println(s + " " + d);

            dijkstra.dijkstra(s, d, 0);
            time1 += dijkstra.time;
            dijkstra1.dijkstra(s, d, 1);
            time2 += dijkstra1.time;
        }
        System.out.println("原始 Dijkstra 耗时" + time1 + "s ");
        System.out.println("改进 Dijkstra 耗时" + time2 + "s ");
    }
}