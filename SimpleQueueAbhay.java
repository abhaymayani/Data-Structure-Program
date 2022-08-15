package simplequeue;

import java.util.Scanner;

public class SimpleQueueAbhay {

    int item[];
    static int size;
    int front, rear;

    public SimpleQueueAbhay(int size) {
        item = new int[size];
        front = -1;
        rear = -1;
    }

    public void qempty() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue is empty");
            return;
        }
    }

    public void qfull() {
        if (rear == size - 1) {
            System.out.println("Queue is full");
        }
    }

    void insert(int value) {
        if (rear == size - 1) {
            System.out.println("Queue is full...");
//            System.exit(1);
        } else {
            if (front == -1) {
                front = 0;
            }
            rear++;
            item[rear] = value;
            System.out.println(value + " is inserted");
        }
    }

    void delete() {
        if (rear == -1 && front == -1) {
            System.out.println("Queue is emplty");
        } else {
            int ele = item[front];
            if (front >= rear) {
                front = -1;
                rear = -1;
            } else {
                front++;
            }
            System.err.println(ele + " is deleted");
        }
    }

    void display() {
        if (rear == -1 && front == -1) {
            System.out.println("Queue is empty");
        } else {
            for (int i = front; i <= rear; i++) {
                System.out.println(item[i] + "  ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your Queue Size : ");
        size = s.nextInt();
        SimpleQueueAbhay queueAbhay = new SimpleQueueAbhay(size);

        int ch;

        while (true) {
            System.out.println("1. Insert the element");
            System.out.println("2. Delete the Element");
            System.out.println("3. Display Queue");
            System.out.println("4. Search element");
            System.out.println("0. Exit");

            System.out.println("Enter choice you wqant to perform : ");
            ch = s.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter the value : ");
                    int value = s.nextInt();
                    queueAbhay.insert(value);
                    break;
                case 2:
                    queueAbhay.delete();
                    break;
                case 3:
                    queueAbhay.display();
                    break;
                case 4:
                    System.out.println("Enter the Eelement you want to search : ");
                    int find = s.nextInt();
                    queueAbhay.search(find);
//                    if (res == -1) {          aa return type thi karvu hoy to aa logic
//                        System.out.println("not found");
//                    } else {
//                        System.out.println(find + " is found at[" + res + "] position");
//
//                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Enter right choice");
            }
        }
    }

    private void search(int find) {
        int flag = 0;
        if (front == -1 && rear == -1) {
            System.out.println("Queue is Empty...");
        } else {
            for (int i = front; i <= rear; i++) {
                if (item[i] == find) {
                    flag = 1;
                    System.out.println(find + " is found at[" + i + "] position");
//                    return i;
                }
            }
            if (flag == 0) {
                System.out.println("not found");
            }
        }
//        return -1;
    }

}
