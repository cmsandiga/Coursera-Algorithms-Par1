import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;

public class TestDeque {

	@Test
	public void testingSizeMethod() {
		Deque<Integer> dequeu = new Deque<Integer>();

		dequeu.addFirst(4);
		dequeu.addFirst(5);

		Assert.assertEquals("Test Lenght", dequeu.size(), 2);
	}

	@Test
	public void testIterator() {
		Deque<Integer> dequeu = new Deque<Integer>();
		dequeu.addFirst(4);
		dequeu.addFirst(5);
		dequeu.addFirst(6);

		Iterator<Integer> iterator = dequeu.iterator();

		int lastInserted = 6;
		while (iterator.hasNext()) {
			Assert.assertEquals("Numbers in correct order", lastInserted--,
					iterator.next().intValue());
		}
	}

	@Test
	public void testAddingElementsAndRemoving() {
		Deque<Integer> dequeu = new Deque<Integer>();
		dequeu.addFirst(1);
		dequeu.addFirst(2);
		dequeu.addFirst(3);
		dequeu.addFirst(4);
		dequeu.addFirst(5);

		Assert.assertEquals("Test Lenght", dequeu.size(), 5);

		dequeu.removeFirst();
		dequeu.removeLast();

		Assert.assertEquals("Test Lenght", dequeu.size(), 3);

		int lastInserted = 4;

		for (Integer integer : dequeu) {
			Assert.assertEquals("Numbers in correct order", lastInserted--,
					integer.intValue());
		}
	}

	@Test
	public void testLastItem() {
		Deque<Integer> dequeu = new Deque<Integer>();

		for (int i = 100; i >= 1; i--) {
			dequeu.addFirst(i);
		}

		for (int i = 0; i < 20; i++) {
			dequeu.removeFirst();
			dequeu.removeLast();
		}

		Assert.assertEquals("Testing removing ",
				dequeu.removeLast().intValue(), 80);
		Assert.assertEquals("Testing removing ",
				dequeu.removeLast().intValue(), 79);
		Assert.assertEquals("Testing removing ",
				dequeu.removeLast().intValue(), 78);
		Assert.assertEquals("Testing removing ",
				dequeu.removeLast().intValue(), 77);

		Assert.assertEquals("Testing removing ", dequeu.removeFirst()
				.intValue(), 21);
		Assert.assertEquals("Testing removing ", dequeu.removeFirst()
				.intValue(), 22);
		Assert.assertEquals("Testing removing ", dequeu.removeFirst()
				.intValue(), 23);
		Assert.assertEquals("Testing removing ", dequeu.removeFirst()
				.intValue(), 24);
		Assert.assertEquals("Testing removing ", dequeu.removeFirst()
				.intValue(), 25);
	}

	@Test
	public void testAddLastItemRemoveFirst() {
		Deque<Integer> deque = new Deque<Integer>();

		for (int i = 1; i <= 100; i++)
			deque.addLast(i);

		for (int i = 1; i <= 100; i++)
			deque.removeFirst();

		for (int i = 1; i <= 50; i++)
			deque.addLast(i);

		Assert.assertEquals("Testing removing ", 50, deque.size());
	}

	@Test
	public void testAddFirstAddLastRemoveFirstRemoveLast() {
		Deque<Integer> deque = new Deque<Integer>();

		for (int i = 1; i <= 1000; i++)
			deque.addFirst(i);

		for (int i = 1; i <= 500; i++)
			deque.addLast(i);

		for (int i = 1; i <= 100; i++)
			deque.removeFirst();

		for (int i = 1; i <= 1000; i++)
			deque.removeLast();

		Assert.assertEquals("Testing removing ", 400, deque.size());
	}

	@Test
	public void testRandomCalling1() {
		Deque<Integer> deque = new Deque<Integer>();

		deque.addFirst(1);
		deque.removeLast();

		deque.addLast(1);
		deque.removeFirst();

		Assert.assertEquals("Testing removing ", 0, deque.size());
	}

	@Test
	public void testRandomCalling2() {
		Deque<Integer> deque = new Deque<Integer>();

		deque.addLast(1);
		deque.removeFirst();

		deque.addFirst(1);
		deque.removeLast();

		deque.addLast(1);
		deque.removeFirst();

		Assert.assertEquals("Testing removing ", 0, deque.size());
	}

	@Test
	public void testRandomCalling3() {
		Deque<Integer> deque = new Deque<Integer>();

		deque.addFirst(1);
		deque.addFirst(1);
		deque.removeLast();

		Assert.assertEquals("Testing removing ", 1, deque.size());
	}

	@Test
	public void testRandomCalling4() {
		Deque<Integer> deque = new Deque<Integer>();

		deque.addLast(1);
		deque.addLast(1);
		deque.removeLast();

		Assert.assertEquals("Testing removing ", 1, deque.size());
	}

	@Test
	public void testRandomCalling5() {
		Deque<Integer> deque = new Deque<Integer>();

		deque.addFirst(1);
		deque.addFirst(1);
		deque.removeFirst();

		Assert.assertEquals("Testing removing ", 1, deque.size());
	}

	@Test
	public void testRandomCalling7() {
		Deque<Integer> deque = new Deque<Integer>();

		deque.addLast(1);
		deque.addLast(1);
		deque.removeFirst();
		Assert.assertEquals("Testing removing ", 1, deque.size());
	}

	@Test
	public void testRandomOperationWithAddFirst() {
		Deque<Integer> deque = new Deque<Integer>();

		for (int i = 0; i < 10; i++) {
			deque.addFirst(i);
		}

		for (int i = 0; i < 5; i++) {
			int random = StdRandom.uniform(1, 5);

			switch (random) {
			case 1:
				deque.removeFirst();
				break;
			case 2:
				deque.removeLast();
				break;
			case 3:
				deque.addFirst(random);
				break;
			case 4:
				deque.addLast(random);
				break;
			}
		}

	}

	

	@Test
	public void testRandomCalling6() {
		Deque<Integer> deque = new Deque<Integer>();

		deque.addFirst(1);
		deque.addFirst(1);
		deque.removeLast();

		Assert.assertEquals("Testing removing ", 1, deque.size());
	}
	
	@Test
	public void testIteratorThenOfRandom() {
		Deque<Integer> deque = new Deque<Integer>();

		for (int i = 1; i <= 10; i++) {
			deque.addFirst(i);
		}
		
		for (int i = 1; i <= 10; i++) {
			deque.addLast(i);
		}
		
		for (int i = 1; i <= 10; i++) {
			deque.removeFirst();
		}
		
		Assert.assertEquals("Testing removing ", 10, deque.size());
		
		Iterator<Integer> iterator = deque.iterator();

		
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}
	@Test
	public void testLoitering() {
		Deque<Integer> deque = new Deque<Integer>();

		for (int i = 0; i < 100; i++) {
			deque.addLast(i);
		}
		
		for (int i = 0; i < 100; i++) {
			deque.removeFirst();
		}

		for (int i = 0; i < 100; i++) {
			deque.addFirst(i);
		}
		
		for (int i = 0; i < 100; i++) {
			deque.removeLast();
		}
		
		Assert.assertEquals("Testing removing ", 0, deque.size());
	}
	
	@Test(expected = NullPointerException.class)
	public void testAddFirstNull() {
		Deque<Integer> dequeu = new Deque<Integer>();
		dequeu.addFirst(null);
	}

	@Test(expected = NullPointerException.class)
	public void testAddLastNull() {
		Deque<Integer> dequeu = new Deque<Integer>();
		dequeu.addLast(null);
	}

	@Test(expected = NoSuchElementException.class)
	public void testRemoveFirstException() {
		Deque<Integer> dequeu = new Deque<Integer>();
		dequeu.removeFirst();
	}

	@Test(expected = NoSuchElementException.class)
	public void testRemoveLastException() {
		Deque<Integer> dequeu = new Deque<Integer>();
		dequeu.removeLast();
	}

	@Test(expected = NoSuchElementException.class)
	public void testNextIteratorException() {
		Deque<Integer> dequeu = new Deque<Integer>();
		dequeu.iterator().next();
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testUnsupportedOperationException() {
		Deque<Integer> dequeu = new Deque<Integer>();
		dequeu.iterator().remove();
	}

}
