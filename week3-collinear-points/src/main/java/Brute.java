import java.util.Arrays;

public class Brute
{
	public static void main(String[] args)
	{

		// rescale coordinates and turn on animation mode
		StdDraw.setXscale(0, 32768);
		StdDraw.setYscale(0, 32768);
		StdDraw.show(0);
		StdDraw.setPenRadius(0.01); // make the points a bit larger

		// read in the input
		String filename = args[0];
		In in = new In(filename);
		int N = in.readInt();

		Point[] points = new Point[N];

		for (int i = 0; i < N; i++)
		{
			int x = in.readInt();
			int y = in.readInt();

			Point p = new Point(x, y);
			p.draw();
			points[i] = p;
		}

		// display to screen all at once
		StdDraw.show(0);

		// reset the pen radius
		StdDraw.setPenRadius();

		for (int p = 0; p < points.length; p++)
			for (int q = p + 1; q < points.length; q++)
				for (int r = q + 1; r < points.length; r++)
					for (int s = r + 1; s < points.length; s++)
					{

						double pq = points[p].slopeTo(points[q]);
						double pr = points[p].slopeTo(points[r]);
						double ps = points[p].slopeTo(points[s]);

						if (pq == pr && pq == ps)
						{
							Point[] sub = { points[p], points[q], points[r], points[s] };
							Arrays.sort(sub);

							String text = new StringBuilder(64).append(sub[0]).append(" -> ").append(sub[1]).append(" -> ").append(sub[2])
									.append(" -> ").append(sub[3]).toString();
							StdOut.println(text);

							sub[0].drawTo(sub[sub.length - 1]);
							StdDraw.show(0);
						}
					}
	}
}
