import java.util.Random;

public class b3 {
    public static void quickSort(int[] a, int l, int r) {
        if (l >= r) return;
        int pivot = a[(l + r) / 2];
        int i = l, j = r;
        while (i <= j) {
            while (a[i] < pivot) i++;
            while (a[j] > pivot) j--;
            if (i <= j) {
                int temp = a[i]; a[i] = a[j]; a[j] = temp;
                i++; j--;
            }
        }
        quickSort(a, l, j);
        quickSort(a, i, r);
    }

    public static void shuffle(int[] a) {
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            int j = r.nextInt(a.length);
            int temp = a[i]; a[i] = a[j]; a[j] = temp;
        }
    }

    public static void main(String[] args) {
        int n = 8000;
        int[] a = new int[n], b = new int[n];

        for (int i = 0; i < n; i++) a[i] = b[i] = i;
        long t1 = System.currentTimeMillis();
        quickSort(a, 0, n - 1);
        System.out.println("QuickSort (No Shuffle): " + (System.currentTimeMillis() - t1) + "ms");
        long t2 = System.currentTimeMillis();
        shuffle(b);
        quickSort(b, 0, n - 1);
        System.out.println("QuickSort (With Shuffle): " + (System.currentTimeMillis() - t2) + "ms");
    }
}