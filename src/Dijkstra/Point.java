package map;

public class Point {
    private final static double SCALEX = 0.0001 * 1000.0;
    private final static double SCALEY = 0.0001 * 1000.0 * 1.3;
    private int x;    // x ����
    private int y;    // y ����

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //		ת��Ϊ�ַ���
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    //		���ص��� p ��ŷ����þ���
    public double distanceTo(Point p) {
        double dx = this.x - p.x;
        double dy = this.y - p.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    //		��һ����

    public void draw() {
        Turtle.fly(x * SCALEX, y * SCALEY);
        Turtle.spot(2, x);
    }

    //		��һ���ߵ��� P

    public void drawTo(Point q) {
        Point p = this;
        Turtle.fly(p.x * SCALEX, p.y * SCALEY);
        Turtle.go(q.x * SCALEX, q.y * SCALEY);
    }
}
