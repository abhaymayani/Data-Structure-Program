package circulerqueue;

import java.util.Scanner;

public class CirculerQueueAbhay {

    public static int size;
    int rear, front;
    int item[];

    public CirculerQueueAbhay(int size) {
        front = -1;
        rear = -1;
        item = new int[size];
    }

    void cinsert(int ele) {
        if (isfull()) {
            System.err.print("queue is full...");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            item[rear] = ele;
            System.out.println(ele + " inserted");
        }
    }

    void cdelete() {
        if (isempty()) {
            System.out.println("aa khali chhe");
        } else {
            int poped = item[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % size;
            }
            if (poped != -1) {
                System.out.println("Deleted Element is " + poped);
            }
        }
    }

    void display() {
        int i;
        if (isempty()) {
            System.out.println("Queue is empty...");
        } else {
            for (i = front; i != rear; i = (i + 1) % size) {
                System.out.println(item[i]);
            }
            System.out.println(item[i]);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the size of queue : ");
        size = s.nextInt();
        CirculerQueueAbhay abhay = new CirculerQueueAbhay(size);

        while (true) {
            System.out.println("1. insert element");
            System.out.println("2. delete element");
            System.out.println("3. display element");
            System.out.println("4. exit");

            System.out.print("Enter the choice : ");
            int ch = s.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Enter the element : ");
                    int ele = s.nextInt();
                    abhay.cinsert(ele);

                    break;
                case 2:
                    abhay.cdelete();
                    break;
                case 3:
                    abhay.display();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Enter proper choice :");
                    break;
            }

        }
    }

    boolean isfull() {
        if (front == 0 && rear == size - 1) {
            return true;
        }
        if (front == rear + 1) {
            return true;
        }
        return false;
    }

    boolean isempty() {
        if (front == -1) {
            return true;
        }
        return false;
    }
}
