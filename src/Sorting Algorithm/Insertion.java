package algrorithm;

public class Insertion {
    public static <T> void sort(Comparable<T>[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    private static <T> boolean less(Comparable<T> v, Comparable<T> w) {
        return v.compareTo((T) w) < 0;
    }

    private static <T> void exch(Comparable<T>[] a, int i, int j) {
        Comparable<T> t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static <T> void show(Comparable<T>[] a) {
        //�ڵ����д�ӡ����
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "");
            System.out.println();
        }
    }

    public static <T> boolean isSorted(Comparable<T>[] a) {
        //��������Ԫ���Ƿ�����
        for (int i = 0; i < a.length; i++) {
            if (less(a[i], a[i - 1]))
                return false;
        }
        return true;
    }
}
