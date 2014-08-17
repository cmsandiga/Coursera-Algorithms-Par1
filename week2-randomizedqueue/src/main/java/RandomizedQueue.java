import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private Item[] items;
	private int size;
	private int capacity = 10;
	private int head = 0;
	private int tail = 0;

	@SuppressWarnings("unchecked")
	public RandomizedQueue() {
		this.items = (Item[]) new Object[10];
		this.size = 0;
	}

	// is the queue empty?
	public boolean isEmpty() {
		return size == 0;
	}

	// return the number of items on the queue
	public int size() {
		return size;
	}

	// add the item
	public void enqueue(Item item) {
		if (item == null)
			throw new NullPointerException();

		if (tail == capacity)
			resize(2 * capacity);

		size++;
		items[tail++] = item;
	}

	// Resizing array
	private void resize(int capacity) {
		this.capacity = capacity;

		@SuppressWarnings("unchecked")
		Item[] copy = (Item[]) new Object[capacity];

		int i = 0;
		for (int j = head; j < tail; i++, j++)
			copy[i] = items[head++];

		tail = i;
		head = 0;
		items = copy;

	}

	// delete and return a random item
	public Item dequeue() {
		if (size == 0)
			throw new NoSuchElementException();

		int random = StdRandom.uniform(head, tail);

		Item item = items[random];

		items[random] = items[head++];
		items[head - 1] = null;
		size--;

		if (size > 0 && size == items.length / 4)
			resize(items.length / 2);

		return item;
	}

	// return (but do not delete) a random item
	public Item sample() {
		if (size == 0)
			throw new NoSuchElementException();

		int random = StdRandom.uniform(head, tail);
		return items[random];
	}

	// return an independent iterator over items in random order
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {

		private Item[] tempItems = items.clone();
		private int tempTail = tail;
		private int tempHead = head;
		private int tempSize = size;

		public boolean hasNext() {
			return tempSize != 0 && tempHead != tempTail;
		}

		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException();

			int random = StdRandom.uniform(tempHead, tempTail);

			Item item = tempItems[random];
			tempItems[random] = tempItems[tempHead++];
			tempItems[tempHead - 1] = null;
			tempSize--;
			return item;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	/*
	 * private String toString() { // TODO Auto-generated method stub return
	 * Arrays.toString((Object[]) items); }
	 */

	// unit testing
	public static void main(String[] args) {
	}
}
