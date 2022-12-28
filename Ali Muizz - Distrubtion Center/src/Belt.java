import java.awt.*;

public class Belt {

	private int x;
	private int y;
	private int w;
	private int h;

	private int[] xBelt;
	private int[] yBelt;

	private int[] xButton;
	private int[] yButton;

	private int beltLineIncrement;
	private Parcel theParcel;

	private boolean forceMove;
	private int angleIncrease;

	int counter;

	public Belt(int x, int y, int w, int h, Parcel b, boolean force)
	{
		this.setX(x);
		this.setY(y);
		this.setW(w);
		this.setH(h);
		setForceMove(force);

		this.setxBelt(new int[4]);
		this.setyBelt(new int[4]);
		this.setyButton(new int[3]);
		this.setxButton(new int[3]);

		this.getxBelt()[0] = getX();
		this.getxBelt()[1] = getX() + getW();
		this.getxBelt()[2] = getX() + getW() + 15;
		this.getxBelt()[3] = getX() + 15;

		this.getyBelt()[0] = getY();
		this.getyBelt()[1] = getY();
		this.getyBelt()[2] = getY() + getH();
		this.getyBelt()[3] = getY() + getH();

		this.setTheParcel(b);

		this.counter = 1;
		setAngleIncrease(0);
	}

	public void paint(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;

		// Belt
		g2d.setColor(Color.DARK_GRAY);
		g2d.fillPolygon(getxBelt(), getyBelt(), 4);
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.fillRect(getX() + 15, getY() + getH(), getW() + 15, 20);
		g2d.setColor(Color.BLACK);
		g2d.drawPolygon(getxBelt(), getyBelt(), 4);
		g2d.drawRect(getX() + 15, getY() + getH(), getW() + 15, 20);

		// Draws the lines for the  belt
		for(int i = 0; i < 1110; i = i + 20)
		{
			if(i > getX() + 20)
			{
				g2d.setColor(Color.BLACK);
				g2d.drawLine(-50 + i + getBeltLineIncrement(), getY(), -50 + i + getBeltLineIncrement() + 50 , getY() + getH());


				g2d.setColor(new Color(0, 0, 0));

				g2d.fillArc(i - 12 - 10, getY() + getH() , 20, 20, 0 + this.getAngleIncrease(), 180); // the wheels

				g2d.setColor(new Color(60, 60, 60));

				g2d.fillArc(i - 12 - 10, getY() + getH() , 20, 20, 180 + this.getAngleIncrease(), 180); // the wheels

			}
		}

		// draws the button for the  belt
		g2d.setColor(Color.BLACK);
		g2d.drawRect(150,366,30,30);
		g2d.setColor(Color.gray);
		g2d.fillRect(150,366,30,30);
		g2d.setColor(Color.black);
		g2d.drawRect(150, 366, 30, 30);

		if(getTheParcel().getMove() == true)
		{
			g2d.setColor(Color.GREEN);
			g2d.fillOval(150, 366, 30, 30);
		}
		if(getTheParcel().getMove() == false)
		{
			g2d.setColor(Color.RED);
			g2d.fillOval (150, 366, 30, 30);
		}

		getxButton()[0] = 150;
		getxButton()[1] = 150;
		getxButton()[2] = 130;
		getyButton()[0] = 366;
		getyButton()[1] = 396;
		getyButton()[2] = 366;
		g2d.setColor(Color.gray.darker());
		g2d.fillPolygon(getxButton(), getyButton(), 3);
		g2d.setColor(Color.black);
		g2d.drawPolygon(getxButton(), getyButton(), 3);
	}

	public void move()
	{
		if(isForceMove()) // Doesn't let the stop button stop the conveyor belts of the right side
		{
			this.setBeltLineIncrement(this.getBeltLineIncrement() + 1);

			if (getF() == 20)
			{
				this.setBeltLineIncrement(0);
			}
			setAngleIncrease(getAngleIncrease() -3);

		}

		if(getTheParcel().getMove() == true && !isForceMove() )
		{

			this.setBeltLineIncrement(this.getBeltLineIncrement() + 1);

			if (getF() == 20)
			{
				this.setBeltLineIncrement(0);				
			}
			setAngleIncrease(getAngleIncrease() -3);
		}
	}
	public int getF()
	{
		return getBeltLineIncrement();
	}

	public int getX() 
	{
		return x;
	}

	public void setX(int x) 
	{
		this.x = x;
	}

	public int getY() 
	{
		return y;
	}

	public void setY(int y) 
	{
		this.y = y;
	}

	public int getW() 
	{
		return w;
	}

	public void setW(int w) 
	{
		this.w = w;
	}

	public int getH() 
	{
		return h;
	}

	public void setH(int h) 
	{
		this.h = h;
	}

	public int[] getxBelt() 
	{
		return xBelt;
	}

	public void setxBelt(int[] xBelt) 
	{
		this.xBelt = xBelt;
	}

	public int[] getyBelt() 
	{
		return yBelt;
	}

	public void setyBelt(int[] yBelt) 
	{
		this.yBelt = yBelt;
	}

	public int[] getxButton() 
	{
		return xButton;
	}

	public void setxButton(int[] xButton) 
	{
		this.xButton = xButton;
	}

	public int[] getyButton() 
	{
		return yButton;
	}

	public void setyButton(int[] yButton) 
	{
		this.yButton = yButton;
	}

	public int getBeltLineIncrement() 
	{
		return beltLineIncrement;
	}

	public void setBeltLineIncrement(int beltLineIncrement) 
	{
		this.beltLineIncrement = beltLineIncrement;
	}

	public Parcel getTheParcel() 
	{
		return theParcel;
	}

	public void setTheParcel(Parcel theParcel) 
	{
		this.theParcel = theParcel;
	}

	public boolean isForceMove() 
	{
		return forceMove;
	}

	public void setForceMove(boolean forceMove) 
	{
		this.forceMove = forceMove;
	}

	public int getAngleIncrease() 
	{
		return angleIncrease;
	}

	public void setAngleIncrease(int angleIncrease) 
	{
		this.angleIncrease = angleIncrease;
	}
}

