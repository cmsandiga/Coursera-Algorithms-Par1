import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Fast
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
		Point[] aux = new Point[N];

		for (int i = 0; i < N; i++)
		{
			int x = in.readInt();
			int y = in.readInt();

			Point p = new Point(x, y);
			Point newpoint = new Point(x, y);
			p.draw();
			points[i] = p;
			aux[i] = newpoint;
		}
		// display to screen all at once
		StdDraw.show(0);

		// reset the pen radius
		StdDraw.setPenRadius();

		Set<String> trackPrinted = new HashSet<String>();
		// Arrays.sort(points);
		for (int p = 0; p < points.length; p++)
		{
			Point origin = points[p];
			List<Point> pointsList = new ArrayList<Point>();

			pointsList.add(origin);

			Arrays.sort(aux, origin.SLOPE_ORDER);

			for (int q = 1; q < aux.length; q++)
			{

				if (!(q + 1 == aux.length) && origin.slopeTo(aux[q]) == origin.slopeTo(aux[q + 1]))
				{
					pointsList.add(aux[q]);
				}
				else if (pointsList.size() >= 3)
				{
					pointsList.add(aux[q]);

					Collections.sort(pointsList);
					StringBuffer sb = new StringBuffer();

					for (int i = 0; i < pointsList.size(); i++)
					{
						sb.append(pointsList.get(i));

						if (i != pointsList.size() - 1) sb.append(" -> ");
					}	

					if (!trackPrinted.contains(sb.toString()))
					{
						trackPrinted.add(sb.toString());
						pointsList.get(0).drawTo(pointsList.get(pointsList.size() - 1));
						StdDraw.show(0);
					}

					pointsList.clear();
					pointsList.add(origin);

				}
				else
				{
					pointsList.clear();
					pointsList.add(origin);

				}
			}
		}
	}
}
