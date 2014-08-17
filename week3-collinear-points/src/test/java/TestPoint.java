import org.junit.Assert;
import org.junit.Test;

public class TestPoint
{

	@Test
	public void testOne()
	{
		Point p = new Point(90, 165);
		Point q = new Point(397, 165);
		int c = p.compareTo(q);
		Assert.assertEquals(-1, c);
	}

	@Test
	public void testTwo()
	{
		Point p = new Point(24676, 535);
		Point q = new Point(32470, 535);
		int c = p.compareTo(q);
		Assert.assertEquals(-1, c);
	}

	@Test
	public void testThree()
	{
		Point p = new Point(7, 6);
		Point q = new Point(7, 6);
		int c = p.compareTo(q);
		Assert.assertEquals(0, c);
	}

	@Test
	public void slopeOne()
	{
		Point p = new Point(70, 86);
		Point q = new Point(70, 330);

		double pq = p.slopeTo(q);// = Infinity
	
		Assert.assertEquals(Double.POSITIVE_INFINITY, pq, 0);
	}

	
	@Test
	public void slopeFour()
	{
		Point p = new Point(305, 319);
		Point q = new Point(305, 113);

		double pq = p.slopeTo(q);// = -Infinity
		
	
		Assert.assertEquals(Double.POSITIVE_INFINITY, pq, 0);
		
	}
	@Test
	public void fastOne()
	{
		Point p = new Point(30000, 0);
		Point q = new Point(20000, 10000);
		Point r = new Point(10000, 20000);
		Point s = new Point(0, 30000);
		
		double pq = p.slopeTo(q);
		double pr = p.slopeTo(r);
		double ps = p.slopeTo(s);
		Assert.assertEquals(pq, pr, 0);
		Assert.assertEquals(pq, ps, 0);
	}
	
	@Test
	public void fastTwo()
	{
		Point p = new Point(18000, 2000);
		Point q = new Point(9000, 6000);
		Point r = new Point(0, 10000);
		
		
		double pq = p.slopeTo(q);
		double pr = p.slopeTo(r);

		Assert.assertEquals(pq, pr, 0);

	}
	
	@Test
	public void fastThree()
	{
		Point p = new Point(10000, 0);
		Point q = new Point(8000, 2000);
		Point r = new Point(2000, 8000);
		Point s = new Point(0, 10000);
		
		
		double pq = p.slopeTo(q);
		double pr = p.slopeTo(r);
		double ps = p.slopeTo(s);

		Assert.assertEquals(pq, pr, 0);
		Assert.assertEquals(pq, ps, 0);
	}

	@Test
	public void fastFour()
	{
		Point p = new Point(30000, 0);
		Point q = new Point(9000, 6000);
		Point r = new Point(2000, 8000);
		
		
		double pq = p.slopeTo(q);
		double pr = p.slopeTo(r);

		Assert.assertEquals(pq, pr, 0);
	}
	
	@Test
	public void fastFive()
	{
		Point p = new Point(30000, 0);
		Point q = new Point(20000, 10000);
		Point r = new Point(10000, 20000);
		Point s = new Point(0, 30000);
		
		
		double pq = p.slopeTo(q);
		double pr = p.slopeTo(r);
		double ps = p.slopeTo(s);

		Assert.assertEquals(pq, pr, 0);
		Assert.assertEquals(pq, ps, 0);
	}
	
	@Test
	public void fastSix()
	{
		Point p = new Point(10000, 0);
		Point q = new Point(13000, 0);
		Point r = new Point(20000, 0);
		Point s = new Point(30000, 0);
		
		
		double pq = p.slopeTo(q);
		double pr = p.slopeTo(r);
		double ps = p.slopeTo(s);

		Assert.assertEquals(pq, pr, 0);
		Assert.assertEquals(pq, ps, 0);
	}
	
	@Test
	public void fastSeven()
	{
		Point p = new Point(20000, 0);
		Point q = new Point(18000, 2000);
		Point r = new Point(2000, 18000);		
		
		double pq = p.slopeTo(q);
		double pr = p.slopeTo(r);


		Assert.assertEquals(pq, pr, 0);
	}
	
	@Test
	public void fastEight()
	{
		Point p = new Point(13000, 0);
		Point q = new Point(11000, 3000);
		Point r = new Point (9000, 6000) ;
		Point s = new Point(5000, 12000);
		
		double pq = p.slopeTo(q);
		double pr = p.slopeTo(r);
		double ps = p.slopeTo(s);


		Assert.assertEquals(pq, pr, 0);
		Assert.assertEquals(pq, ps, 0);

	}

}
