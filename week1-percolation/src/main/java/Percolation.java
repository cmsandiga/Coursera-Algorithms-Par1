public class Percolation {

	private boolean grid[][];
	private int N;
	private WeightedQuickUnionUF uf;
	private WeightedQuickUnionUF ufTop;
	private int TOP;
	private int BOTTOM;

	public Percolation(int N) {
		if (N < 1) {
			throw new IllegalArgumentException("Out of range");
		}
		this.N = N;
		this.grid = new boolean[N][N];
		this.TOP = N * N;
		this.BOTTOM = N * N + 1;
		this.uf = new WeightedQuickUnionUF(N * N + 2);
		this.ufTop = new WeightedQuickUnionUF(N * N + 1);
	}

	public void open(int i, int j) {
		validate(i, j);

		grid[i - 1][j - 1] = true;
		
        if (i == 1) {
            uf.union(TOP, xyTo1D(i, j));
            ufTop.union(TOP, xyTo1D(i, j));
        }

        if (i == N) {
        	uf.union(xyTo1D(i, j), BOTTOM);
        }
        
		// Upper
		if (i - 1 >= 0 && isOpen(i - 1, j)){
			uf.union(xyTo1D(i, j), xyTo1D(i - 1, j));
			ufTop.union(xyTo1D(i, j), xyTo1D(i - 1, j));			
		}
		// Right
		if (j + 1 <= N && isOpen(i, j + 1)){
			uf.union(xyTo1D(i, j), xyTo1D(i, j + 1));
			ufTop.union(xyTo1D(i, j), xyTo1D(i - 1, j));
		}
		// Down
		if (i + 1 <= N && isOpen(i + 1, j)){
			uf.union(xyTo1D(i, j), xyTo1D(i + 1, j));
			ufTop.union(xyTo1D(i, j), xyTo1D(i - 1, j));
		}
		// Left
		if (j - 1 >= 0 && isOpen(i, j - 1)){
			uf.union(xyTo1D(i, j), xyTo1D(i, j - 1));
			ufTop.union(xyTo1D(i, j), xyTo1D(i - 1, j));
		}
		if (i - 1 == 0) {
			uf.union(TOP, xyTo1D(i, j));
		}

		
	}

	private int xyTo1D(int x, int y) {
		System.out.println(x + " " + y);
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
		return isOpen(i, j) && ufTop.connected(TOP, xyTo1D(i, j));
	}

	private void validate(int i, int j) {
		if (i < 0 || i > N || j < 0 || j > N) {
			throw new IndexOutOfBoundsException("Out of range");
		}
	}

	public boolean percolates() {

		return uf.connected(TOP, BOTTOM);
	}
}
