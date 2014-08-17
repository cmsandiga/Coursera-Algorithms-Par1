import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;

public class TestRandomizedQueue {

	@Test
	public void testEnqueue() {
		RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();

		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);

		Assert.assertEquals("Size of queue: ", 3, queue.size());
	}

	@Test(expected = NullPointerException.class)
	public void testEnqueueNoSuchElementException() {
		RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();
		queue.enqueue(null);
	}

	@Test
	public void testResizing() {
		RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(7);
		queue.enqueue(8);
		queue.enqueue(9);
		queue.enqueue(10);
		queue.enqueue(11);
		Assert.assertEquals("Size of queue: ", 11, queue.size());
	}

	@Test
	public void testSample() {
		RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();

		for (int i = 0; i < 1000; i++)
			queue.enqueue(i);

		System.out.println(queue);

		for (int i = 0; i < 800; i++) {
			System.out.println(queue.sample());
		}
	}

	@Test
	public void testDequeuRandom() {
		RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();

		for (int i = 1; i <= 5000; i++) {
			queue.enqueue(StdRandom.uniform(0, 10));
		}

		for (int i = 1; i <= 1000; i++) {
			queue.dequeue();
		}

		Assert.assertEquals("Size of queue: ", 4000, queue.size());
	}

	@Test
	public void testDequeueZeroElements() {
		RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();

		for (int i = 1; i <= 5000; i++) {
			queue.enqueue(StdRandom.uniform(0, 10));
		}

		for (int i = 1; i <= 5000; i++) {
			queue.dequeue();
		}

		Assert.assertEquals("Size of queue: ", 0, queue.size());
	}

	@Test
	public void testIterator() {
		RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();

		for (int i = 1; i <= 10; i++) {
			queue.enqueue(i);
		}

		Iterator<Integer> it = queue.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		System.out.println("Second");
		Iterator<Integer> it2 = queue.iterator();
		while (it2.hasNext()) {
			System.out.println(it2.next());
		}

	}

	@Test(expected = NoSuchElementException.class)
	public void testDequeueNoSuchElements() {
		RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();

		for (int i = 1; i <= 5000; i++) {
			queue.enqueue(StdRandom.uniform(0, 10));
		}

		for (int i = 1; i <= 5000; i++) {
			queue.dequeue();
		}
		System.out.println(queue);
		for (int i = 1; i <= 5000; i++) {
			queue.enqueue(StdRandom.uniform(0, 10));
		}

		for (int i = 1; i <= 5001; i++) {
			queue.dequeue();
		}
		System.out.println(queue);
	}

	@Test
	public void testResizingBalanced() {
		RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();

		for (int i = 1; i <= 5000; i++) {
			queue.enqueue(StdRandom.uniform(0, 10));
		}

		for (int i = 1; i <= 4990; i++) {
			queue.dequeue();
		}
		System.out.println("Size of queue 10 :" + queue);
		Assert.assertEquals("Size of queue: ", 10, queue.size());

		for (int i = 1; i <= 10; i++) {
			queue.enqueue(StdRandom.uniform(0, 10));
		}
		Assert.assertEquals("Size of queue: ", 20, queue.size());
		System.out.println("Size of queue 20 :" + queue);

		for (int i = 1; i <= 7; i++) {
			queue.dequeue();
		}
		Assert.assertEquals("Size of queue: ", 13, queue.size());
		System.out.println("Size of queue 13 :" + queue);

		for (int i = 1; i <= 5; i++) {
			queue.enqueue(StdRandom.uniform(0, 10));
		}
		Assert.assertEquals("Size of queue: ", 18, queue.size());
		System.out.println("Size of queue 18 :" + queue);
		for (int i = 1; i <= 15; i++) {
			queue.dequeue();
		}
		Assert.assertEquals("Size of queue: ", 3, queue.size());
		System.out.println("Size of queue 3 :" + queue);
	}

	@Test
	public void testEnqueueDequeueSample() {
		
		RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();
		
		for (int i = 1; i <= 5; i++) {
			queue.enqueue(StdRandom.uniform(0, 10));
		}
		for (int i = 1; i <= 1; i++) {			
			queue.dequeue();
		}
		
		for (int i = 1; i <= 4; i++) {
			queue.sample();
		}
		
	}
}
