public class PercolationStats {

	private int T;
	private double[] threaholder;

	public PercolationStats(int N, int T) {

		if (N <= 0 || T <= 0) {
			throw new IllegalArgumentException("Please greather than one");
		}

		this.T = T;
		this.threaholder = new double[T];

		for (int i = 1; i <= T; i++) {
			Percolation percolation = new Percolation(N);

			int counter = 0;
			int p;
			int q;
			
			while (!percolation.percolates()) {
				do {
					p = StdRandom.uniform(1, N + 1);
					q = StdRandom.uniform(1, N + 1);
				} while (percolation.isOpen(p, q));

				percolation.open(p, q);
				counter++;
			}

			threaholder[i - 1] = (counter * 1.0) / (N * N);
		}
	}

	public double mean() {
		return StdStats.mean(threaholder);
	}

	public double stddev() {
		return StdStats.stddev(threaholder);
	}

	public double confidenceLo() {
		return mean() - (1.96 * stddev()) / Math.sqrt(T);
	}

	public double confidenceHi() {
		return mean() + (1.96 * stddev()) / Math.sqrt(T);
	}

	public static void main(String[] args) {

		int N = Integer.parseInt(args[0]);
		int T = Integer.parseInt(args[1]);

		if (N < 1 || T < 1) {
			throw new IndexOutOfBoundsException("Out of range");
		}

		PercolationStats percolationStats = new PercolationStats(N, T);

		StdOut.println("mean \t\t:" + percolationStats.mean());
		StdOut.println("stddev \t\t:" + percolationStats.stddev());
		StdOut.println("95% confidence interval \t\t:"
				+ percolationStats.confidenceLo() + " , "
				+ percolationStats.confidenceHi());

	}
}
