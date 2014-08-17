import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

	private Node<Item> first, last;

	private int size;

	public Deque() {
		this.first = new Node<Item>();
		this.last = new Node<Item>();
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	// insert the item at the front
	public void addFirst(Item item) {
		if (item == null) {
			throw new NullPointerException();
		}

		Node<Item> oldNode = first;
		first = new Node<Item>();
		first.item = item;
		first.next = oldNode;

		if (isEmpty())
			last = first;
		else
			oldNode.prev = first;
		size++;
	}

	// insert the item at the end
	public void addLast(Item item) {
		if (item == null) {
			throw new NullPointerException();
		}

		Node<Item> oldNode = last;
		last = new Node<Item>();
		last.item = item;
		last.prev = oldNode;

		if (isEmpty())
			first = last;
		else
			oldNode.next = last;
		size++;
	}

	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	// delete and return the item at the front
	public Item removeFirst() {
		if (size == 0) {
			throw new NoSuchElementException();
		}

		Item item = first.item;
		first.item = null;
		first.prev = null;
		first = first.next;
		size--;
		if (isEmpty()){
			first = null;
			last = null;
		}
		return item;
	}

	// delete and return the item at the end
	public Item removeLast() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		Item item = last.item;
		last.item = null;
		last.next = null;
		last = last.prev;
		size--;
		if (isEmpty()){
			first = null;
			last = null;
		}
		return item;
	}

	public static void main(String[] args) {

	}

	@SuppressWarnings("hiding")
	private class Node<Item> {
		public Item item;
		public Node<Item> next;
		public Node<Item> prev;

	}

	private class ListIterator implements Iterator<Item> {

		private Node<Item> current = first;
		private int currentSize = size;
		public boolean hasNext() {
			return current != null && currentSize != 0;
		}

		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			currentSize--;
			return item;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
