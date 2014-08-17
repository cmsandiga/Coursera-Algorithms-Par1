public class PercolationStatsBackup {

	private int T;
	private double[] threaholder;

	public PercolationStatsBackup(int N, int T) {

		if (N <= 0 || T <= 0) {
			throw new IllegalArgumentException("Please greather than one");
		}

		this.T = T;
		this.threaholder = new double[T];

		for (int i = 1; i <= T; i++) {
			Percolation percolation = new Percolation(N);

			int counter = 0;

			while (!percolation.percolates()) {
				int k = StdRandom.uniform(1, N + 1);
				int l = StdRandom.uniform(1, N + 1);

				if (!percolation.isOpen(k, l)) {
					percolation.open(k, l);
					counter++;
				}				
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

		PercolationStatsBackup percolationStats = new PercolationStatsBackup(N, T);

		StdOut.println("mean \t\t:" + percolationStats.mean());
		StdOut.println("stddev \t\t:" + percolationStats.stddev());
		StdOut.println("95% confidence interval \t\t:"
				+ percolationStats.confidenceLo() + " , "
				+ percolationStats.confidenceHi());

	}
}
