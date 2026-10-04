import java.util.Scanner;

class InsertionSortPart1 { // Không dùng chữ public để tránh lỗi sai tên file

    // Thủ tục chèn phần tử cuối vào danh sách đã sắp xếp
    public static void insertIntoSorted(int[] arr) {
        int n = arr.length;
        int valueToInsert = arr[n - 1]; // Phần tử cuối cùng cần chèn
        int i = n - 2;

        // Dịch chuyển các phần tử lớn hơn sang phải
        while (i >= 0 && arr[i] > valueToInsert) {
            arr[i + 1] = arr[i];
            printArray(arr); // In ra mảng tại mỗi bước dịch chuyển
            i--;
        }

        // Chèn phần tử vào đúng vị trí
        arr[i + 1] = valueToInsert;
        printArray(arr); // In ra mảng lần cuối
    }

    // Hàm in mảng ra màn hình
    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    // Hàm main để chạy chương trình
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Đọc số lượng phần tử (n)
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            // Đọc các phần tử của mảng
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            // Gọi hàm thực thi
            insertIntoSorted(arr);
        }
        scanner.close();
    }
}