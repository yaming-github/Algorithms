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
        System.out.println("�ɹ���ȡ��ͼ�ļ���");
        Dijkstra dijkstra = new Dijkstra(G);
        Dijkstra dijkstra1 = new Dijkstra(G);
        System.out.println("���������·����ѯ�Ĵ���");
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
        System.out.println("ԭʼ Dijkstra ��ʱ" + time1 + "s ");
        System.out.println("�Ľ� Dijkstra ��ʱ" + time2 + "s ");
    }
}