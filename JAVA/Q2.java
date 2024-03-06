class Player
{
	public void disp()
	{
		System.out.println("Parent CLass - Player");
	}
}

class Cricket_Player extends Player
{
	private int c;

	public Cricket_Player(int c)
	{
		this.c = c;
	}

	public void cric()
	{
		System.out.println("Total Players in Cricket Team: " + c);
	}
}

class Football_Player extends Player
{
	private int f;

	public Football_Player(int f)
	{
		this.f = f;
	}

	public void fabll()
	{
		System.out.println("Total Players in Football Team: " + f);
	}
}

class Hockey_Player extends Player
{
	private int h;

	public Hockey_Player(int h)
	{
		this.h = h;
	}

	public void hcky()
	{
		System.out.println("Total Players in Hockey Team: " + h);
	}
}

public class Q2
{
	public static void main(String[] args)
	{
		Cricket_Player c1 = new Cricket_Player(11);
		Football_Player f1 = new Football_Player(15);
		Hockey_Player h1 = new Hockey_Player(10);

		c1.cric();
		f1.fabll();
		h1.hcky();
	}
}
