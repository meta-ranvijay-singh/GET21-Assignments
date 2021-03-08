package DS_StackAndQueue_Q2;

import java.util.Scanner;

public class Main {

	public static void mainMenu() {
		System.out.println("\n----------Main Menu---------");
		System.out.println("1. Enter element in queue.");
		System.out.println("2. Delete first element from queue.");
		System.out.println("3. Check empty.");
		System.out.println("4. Check full.");
		System.out.println("5. Display Queue.");
		System.out.println("0. Exit");
		System.out.print("Enter your choice :");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Queue queue;
		CircularQueue circular_queue;
		int capacity, choice, queuetype;

		System.out.println("Choose Queue type :");
		System.out.println("1. Linear Queue");
		System.out.println("2. Circular Queue");
		System.out.println("Enter :");
		queuetype = in.nextInt();

		if (queuetype == 1) {
			System.out.println("Enter capacity off the queue :");
			capacity = in.nextInt();

			queue = new Queue(capacity);

			do {
				mainMenu();
				choice = in.nextInt();

				switch (choice) {
				case 1:
					System.out.print("Enter element :");
					queue.Enqueue(in.nextInt());
					queue.Display();
					break;
				case 2:
					queue.Dequeue();
					queue.Display();
					break;
				case 3:
					if (queue.isEmpty()) {
						System.out.println("Queue is empty.");
					} else {
						System.out.println("Queue is not empty.");
					}
					break;
				case 4:
					if (queue.isFull()) {
						System.out.println("Queue is full.");
					} else {
						System.out.println("Queue is not full.");
					}
					break;
				case 5:
					queue.Display();
					break;
				default:
					System.exit(0);
					break;
				}
			} while (choice != 0);
		} else if (queuetype == 2) {

			System.out.println("Enter capacity off the queue :");
			capacity = in.nextInt();

			circular_queue = new CircularQueue(capacity);

			do {
				mainMenu();
				choice = in.nextInt();

				switch (choice) {
				case 1:
					System.out.print("Enter element :");
					circular_queue.Enqueue(in.nextInt());
					circular_queue.Display();
					break;
				case 2:
					circular_queue.Dequeue();
					circular_queue.Display();
					break;
				case 3:
					if (circular_queue.isEmpty()) {
						System.out.println("Queue is empty.");
					} else {
						System.out.println("Queue is not empty.");
					}
					break;
				case 4:
					if (circular_queue.isFull()) {
						System.out.println("Queue is full.");
					} else {
						System.out.println("Queue is not full.");
					}
					break;
				case 5:
					circular_queue.Display();
					break;
				default:
					System.exit(0);
					break;
				}
			} while (choice != 0);
		} else {
			System.out.println("Wrong Choice!!");
		}
		in.close();
	}
}
