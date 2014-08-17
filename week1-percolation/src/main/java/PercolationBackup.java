public class PercolationBackup {

	private boolean grid[][];
	//private boolean bottomArray[];
	private int N;
	private boolean isPercolated = false;
	private WeightedQuickUnionUF uf;
	private int TOP;
	private int BOTTOM;

	public PercolationBackup(int N) {
		if (N < 1) {
			throw new IllegalArgumentException("Out of range");
		}
		this.N = N;
		this.grid = new boolean[N][N];
		//this.bottomArray = new boolean[N];
		this.TOP = N * N;
		this.BOTTOM = N * N + 1;
		this.uf = new WeightedQuickUnionUF(N * N + 2);
	}

	public void open(int i, int j) {
		validate(i, j);

		if (isOpen(i, j) == false) {
			grid[i - 1][j - 1] = true;

			// Upper
			if (i - 2 >= 0) {
				if (isOpen(i - 1, j)
						&& !uf.connected(xyTo1D(i, j), xyTo1D(i - 1, j)))
					uf.union(xyTo1D(i, j), xyTo1D(i - 1, j));
			}
			// Right
			if (j + 1 <= N) {
				if (isOpen(i, j + 1)
						&& !uf.connected(xyTo1D(i, j), xyTo1D(i, j + 1)))
					uf.union(xyTo1D(i, j), xyTo1D(i, j + 1));

			}
			// Down
			if (i + 1 <= N) {
				if (isOpen(i + 1, j)
						&& !uf.connected(xyTo1D(i, j), xyTo1D(i + 1, j)))
					uf.union(xyTo1D(i, j), xyTo1D(i + 1, j));
			}
			// Left
			if (j - 2 >= 0) {
				if (isOpen(i, j - 1)
						&& !uf.connected(xyTo1D(i, j), xyTo1D(i, j - 1)))
					uf.union(xyTo1D(i, j), xyTo1D(i, j - 1));
			}

			if (i - 1 == 0) {
				uf.union(xyTo1D(i, j), TOP);
			}

			if (i == N) {
				
				uf.union(xyTo1D(i, j), BOTTOM);
			}
			
			

			if (uf.connected(TOP, BOTTOM))
				this.isPercolated = true;
			
			
		}
	}

	private int xyTo1D(int x, int y) {
		validate(x, y);

		int rX = x - 1;
		int rY = y - 1;

		if (rX == 0) {
			return rX + rY;
		} else {
			return N * rX + rY;
		}
	}

	public boolean isOpen(int i, int j) {
		validate(i, j);
		return grid[i - 1][j - 1] == true;
	}

	public boolean isFull(int i, int j) {
		validate(i, j);
		return isOpen(i, j) && uf.connected(xyTo1D(i, j), TOP);
	}

	private void validate(int i, int j) {
		if (i < 0 || i > N || j < 0 || j > N) {
			throw new IndexOutOfBoundsException("Out of range");
		}
	}

	public boolean percolates() {
		return isPercolated;
	}
}
