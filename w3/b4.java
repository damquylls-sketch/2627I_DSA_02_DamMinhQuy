package w3;

import java.util.Scanner;
import java.util.Stack;

class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int q = sc.nextInt();
        StringBuilder text = new StringBuilder();
        Stack<String> history = new Stack<>();

        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                // Append
                String w = sc.next();
                history.push(text.toString());
                text.append(w);
            } else if (type == 2) {
                // Delete k ký tự cuối
                int k = sc.nextInt();
                history.push(text.toString());
                text.delete(text.length() - k, text.length());
            } else if (type == 3) {
                // Print ký tự thứ k (index bắt đầu từ 1)
                int k = sc.nextInt();
                System.out.println(text.charAt(k - 1));
            } else if (type == 4) {
                // Undo
                if (!history.isEmpty()) {
                    text = new StringBuilder(history.pop());
                }
            }
        }
        sc.close();
    }
}