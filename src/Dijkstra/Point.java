package map;

public class Point {
    private final static double SCALEX = 0.0001 * 1000.0;
    private final static double SCALEY = 0.0001 * 1000.0 * 1.3;
    private int x;    // x 坐标
    private int y;    // y 坐标

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //		转换为字符串
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    //		返回到点 p 的欧几里得距离
    public double distanceTo(Point p) {
        double dx = this.x - p.x;
        double dy = this.y - p.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    //		画一个点

    public void draw() {
        Turtle.fly(x * SCALEX, y * SCALEY);
        Turtle.spot(2, x);
    }

    //		画一个线到点 P

    public void drawTo(Point q) {
        Point p = this;
        Turtle.fly(p.x * SCALEX, p.y * SCALEY);
        Turtle.go(q.x * SCALEX, q.y * SCALEY);
    }
}
