package map;

public class IndexPQ {
    private int N;// 索引优先队列的数量
    private int[] pq; // 二叉堆
    private int[] qp;
    private double[] priority;// 优先值

    public IndexPQ(int NMAX) {
        pq = new int[NMAX + 1];
        qp = new int[NMAX + 1];
        priority = new double[NMAX + 1];
        N = 0;
    }

    //返回队列是否为空

    public boolean isEmpty() {
        return N == 0;
    }

    //			以给定优先级插入元素 k

    public void insert(int k, double value) {
        N++;
        qp[k] = N;
        pq[N] = k;
        priority[k] = value;
        fixUp(pq, N);
    }

    //			删除并返回最小元素并删除并返回最小元素
    public int delMin() {
        exch(pq[1], pq[N]);
        fixDown(pq, 1, --N);
        return pq[N + 1];
    }

    //			将元素 k 的优先级更改为指定的值

    public void change(int k, double value) {
        priority[k] = value;
        fixUp(pq, qp[k]);
        fixDown(pq, qp[k], N);
    }

    //判读两个元素优先级大小

    private boolean greater(int i, int j) {
        return priority[i] > priority[j];
    }

    //交换两个元素

    private void exch(int i, int j) {
        int t = qp[i];
        qp[i] = qp[j];
        qp[j] = t;
        pq[qp[i]] = i;
        pq[qp[j]] = j;
    }

    //堆排序

    private void fixUp(int[] a, int k) {
        while (k > 1 && greater(a[k / 2], a[k])) {
            exch(a[k], a[k / 2]);
            k = k / 2;
        }
    }

    //构造堆

    private void fixDown(int[] a, int k, int N) {
        int j;
        while (2 * k <= N) {
            j = 2 * k;
            if (j < N && greater(a[j], a[j + 1]))
                j++;
            if (!greater(a[k], a[j]))
                break;
            exch(a[k], a[j]);
            k = j;
        }
    }
}
