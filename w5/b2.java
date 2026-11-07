package w5;
import java.util.Random;

public class b2 {
    public static void mergeSort(int[] a, int l, int r) {
        if (l >= r) return;
        int m = (l + r) / 2;
        mergeSort(a, l, m);
        mergeSort(a, m + 1, r);
        int[] temp = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;
        while (i <= m && j <= r) temp[k++] = a[i] <= a[j] ? a[i++] : a[j++];
        while (i <= m) temp[k++] = a[i++];
        while (j <= r) temp[k++] = a[j++];
        for (i = 0; i < k; i++) a[l + i] = temp[i];
    }
    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i], j = i - 1;
            while (j >= 0 && a[j] > key) a[j + 1] = a[j--];
            a[j + 1] = key;
        }
    }
    public static void main(String[] args) {
        int n = 20000;
        int[] a = new int[n], b = new int[n];
        Random rand = new Random();

        for (int i = 0; i < n; i++) a[i] = b[i] = rand.nextInt(n);

        long t1 = System.currentTimeMillis();
        mergeSort(a, 0, n - 1);
        System.out.println("MergeSort (Random): " + (System.currentTimeMillis() - t1) + "ms");

        long t2 = System.currentTimeMillis();
        insertionSort(b);
        System.out.println("InsertionSort (Random): " + (System.currentTimeMillis() - t2) + "ms");

    }
}
