import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int x) {
        stack1.push(x);
    }

    private void shiftStacks() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }

    public void dequeue() {
        shiftStacks();
        if (!stack2.isEmpty()) {
            stack2.pop();
        }
    }

    public void print() {
        shiftStacks();
        if (!stack2.isEmpty()) {
            System.out.println(stack2.peek());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();
        
        if (sc.hasNextInt()) {
            int q = sc.nextInt();
            for (int i = 0; i < q; i++) {
                int type = sc.nextInt();
                if (type == 1) {
                    int x = sc.nextInt();
                    queue.enqueue(x);
                } else if (type == 2) {
                    queue.dequeue();
                } else if (type == 3) {
                    queue.print();
                }
            }
        }
        sc.close();
    }
}