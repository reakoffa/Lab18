import java.util.ArrayList;

public class LinkedList {
	private Node head;
	private Node current;
	public int count;

	public LinkedList() {
		head = new Node();
		current = head;
	}

	public void addAtStart(Object data) {
		Node newNode = new Node();
		newNode.value = data;
		newNode.next = head.next; // newNode will refer to head's next reference.
		head.next = newNode; // Now head will refer to newNode.
		++count;
	}

	public void removeFromStart() {
		if (count > 0) {
			head = head.next;
			--count;
		} else {
			System.out.println("No element exists in this linked list.");
		}
	}

	public void printAllNodes() {
		System.out.println("Head ->");
		Node curr = head;
		while (curr.next != null) {
			curr = curr.next;
			System.out.println(curr.value);
			System.out.println("->");
		}
		System.out.println("NULL");
	}

	public void printReverse() {
		Node reversedPart = null;
		Node current = head;
		while (current != null) {
			Node next = current.next;
			current.next = reversedPart;
			reversedPart = current;
			current = next;
		}
		head = reversedPart;

	}

	public void removeAll(Object o) {
		Node curr = head;
		if (curr.value == o) {
			curr = curr.next;
			--count;
		}
		while (curr.next != null) {
			if (curr.value == o) {
				curr = curr.next;
				--count;
			}
			curr = curr.next;

		}
	}
	// public boolean removeAt(int index) {
	// Node curr = head;
	// if ((index < count) && (index > 0)) {
	//
	// } else {
	// return false;
	// }
	// }

	public static void countOccurances(int[] num) {
		int[] count = new int[100];
		int temp = 0;
		int i;

		for (i = 0; i < num.length; i++) {
			temp = num[i];
			count[temp]++;
		}

		for (i = 1; i < count.length; i++) {

			if (count[i] > 0 && count[i] == 1) {
				System.out.printf("%d occurs %d time\n", i, count[i]);
			} else if (count[i] >= 2) {
				System.out.printf("%d occurs %d times\n", i, count[i]);
			}
		}

	}
}