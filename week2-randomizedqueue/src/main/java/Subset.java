import java.util.Iterator;

public class Subset {

	public static void main(String[] args) {
		

		RandomizedQueue<String> rQueue = new RandomizedQueue<String>();

		int k = Integer.parseInt(args[0]);
		
		while(!StdIn.isEmpty()){
			rQueue.enqueue(StdIn.readString());
		}

		Iterator<String> it = rQueue.iterator();
		for (int i = 0; i < k; i++) {
			StdOut.println(it.next());
		}

	}
}
