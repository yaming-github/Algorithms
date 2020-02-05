package map;

public class IndexPQ {
    private int N;// �������ȶ��е�����
    private int[] pq; // �����
    private int[] qp;
    private double[] priority;// ����ֵ

    public IndexPQ(int NMAX) {
        pq = new int[NMAX + 1];
        qp = new int[NMAX + 1];
        priority = new double[NMAX + 1];
        N = 0;
    }

    //���ض����Ƿ�Ϊ��

    public boolean isEmpty() {
        return N == 0;
    }

    //			�Ը������ȼ�����Ԫ�� k

    public void insert(int k, double value) {
        N++;
        qp[k] = N;
        pq[N] = k;
        priority[k] = value;
        fixUp(pq, N);
    }

    //			ɾ����������СԪ�ز�ɾ����������СԪ��
    public int delMin() {
        exch(pq[1], pq[N]);
        fixDown(pq, 1, --N);
        return pq[N + 1];
    }

    //			��Ԫ�� k �����ȼ�����Ϊָ����ֵ

    public void change(int k, double value) {
        priority[k] = value;
        fixUp(pq, qp[k]);
        fixDown(pq, qp[k], N);
    }

    //�ж�����Ԫ�����ȼ���С

    private boolean greater(int i, int j) {
        return priority[i] > priority[j];
    }

    //��������Ԫ��

    private void exch(int i, int j) {
        int t = qp[i];
        qp[i] = qp[j];
        qp[j] = t;
        pq[qp[i]] = i;
        pq[qp[j]] = j;
    }

    //������

    private void fixUp(int[] a, int k) {
        while (k > 1 && greater(a[k / 2], a[k])) {
            exch(a[k], a[k / 2]);
            k = k / 2;
        }
    }

    //�����

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
