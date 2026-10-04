package w3;

import java.util.Scanner;

class EqualStacks {
    public static int equalStacks(int[] h1, int[] h2, int[] h3) {
        int sum1 = 0, sum2 = 0, sum3 = 0;

        for (int i : h1) sum1 += i;
        for (int i : h2) sum2 += i;
        for (int i : h3) sum3 += i;

        int i = 0, j = 0, k = 0;

        while (true) {
            // Nếu vượt quá số lượng phần tử của bất kỳ mảng nào
            if (i == h1.length || j == h2.length || k == h3.length) {
                return 0;
            }

            // Nếu chiều cao bằng nhau
            if (sum1 == sum2 && sum2 == sum3) {
                return sum1;
            }

            // Giảm chiều cao của chồng lớn nhất
            if (sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= h1[i++];
            } else if (sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= h2[j++];
            } else if (sum3 >= sum1 && sum3 >= sum2) {
                sum3 -= h3[k++];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();

        int[] h1 = new int[n1];
        int[] h2 = new int[n2];
        int[] h3 = new int[n3];

        for (int i = 0; i < n1; i++) h1[i] = sc.nextInt();
        for (int i = 0; i < n2; i++) h2[i] = sc.nextInt();
        for (int i = 0; i < n3; i++) h3[i] = sc.nextInt();

        System.out.println(equalStacks(h1, h2, h3));
        sc.close();
    }
}