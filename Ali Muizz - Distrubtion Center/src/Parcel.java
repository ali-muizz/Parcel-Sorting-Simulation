import java.awt.*;
import java.awt.event.KeyEvent;

public class Parcel {

	private int x;
	private int y;
	private int height;
	private int length;
	private int width;
	private int threeD;
	private int color;
	private int[] xTop;
	private int[] xSide;
	private int[] yTop;
	private int[] ySide;
	private boolean move;
	private boolean runJumpOnce = true;

	public Parcel(int x, int y)
	{
		this.setX(x);
		this.setY(y);
		this.setxTop(new int[4]);
		this.setyTop(new int[4]);
		this.setxSide(new int[4]);
		this.setySide(new int[4]);
		this.setHeight((int)(Math.random() * 30) + 20);
		this.setLength((int)(Math.random() * 30) + 20);
		this.setWidth((int)(Math.random() * 40) + 10);
		this.setColor((int)(Math.random() * 3)  + 1);
		this.setThreeD(((int) Math.sqrt(this.getL())));
		this.setMove(true);
	}

	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			setMove(!getMove());
		}
	}

	public void paint(Graphics g)
	{
		this.getxTop()[0] = this.getX() + this.getL();
		this.getxTop()[1] = this.getX() - this.getL() + this.getL();
		this.getxTop()[2] = this.getX() - this.getL() - this.getThreeD() + this.getL();
		this.getxTop()[3] = this.getX() - this.getThreeD() + this.getL();

		this.getyTop()[0] = this.getY();
		this.getyTop()[1] = this.getY();
		this.getyTop()[2] = this.getY() - this.getThreeD();;
		this.getyTop()[3] = this.getY() - this.getThreeD();;

		this.getxSide()[0] = this.getX() - this.getL() + this.getL();
		this.getxSide()[1] = this.getX() - this.getL() - this.getThreeD() + this.getL();
		this.getxSide()[2] = this.getX() - this.getL() - this.getThreeD() + this.getL();
		this.getxSide()[3] = this.getX() - this.getL() + this.getL();

		this.getySide()[0] = this.getY() + this.getH();
		this.getySide()[1] = this.getY() + this.getH() - this.getThreeD();;
		this.getySide()[2] = this.getY() - this.getThreeD();;
		this.getySide()[3] = this.getY();

		if(getxTop()[2] < 510 && getxTop()[3] > 480 && isRunJumpOnce()) // Box often glitches and doesn't jump, so this interval checks for the box 
		{

			if(getColor() == 1)
			{
				this.setY(getY() - 155);
				for(int j = 0; j < getxTop().length; j++)
				{
					getyTop()[j] = getyTop()[j] - 200;
					getySide()[j] = getySide()[j] - 200;
				}
			}

			if(getColor() == 3)
			{
				this.setY(getY() + 150);
				for(int k = 0; k < getxTop().length; k++)
				{
					getyTop()[k] = getyTop()[k] + 150;
					getySide()[k] = getySide()[k] + 150;
				}
			}
			setRunJumpOnce(false);
		}

		Graphics2D g2d = (Graphics2D) g;
		{
			if(getColor() == 1)
			{
				g2d.setColor(new Color(135,206,250));
			}
			if(getColor() == 2)
			{
				g2d.setColor(new Color(0,128,0));
			}
			if(getColor() == 3)
			{
				g2d.setColor(new Color(255, 234, 0));
			}

			g.fillRect(this.getX(), this.getY(), this.getL(), this.getH());
			g.fillPolygon(getxTop(), getyTop(), 4);

			if(getColor() == 1)
			{
				g2d.setColor(new Color(135,206,250).darker());
			}
			if(getColor() == 2)
			{
				g2d.setColor(new Color(0,128,0).darker());
			}
			if(getColor() == 3)
			{
				g2d.setColor(new Color(255, 234, 0).darker());
			}

			g.fillPolygon(getxSide(), getySide(), 4);

			g.setColor(Color.black);
			g.drawRect(this.getX(), this.getY(), this.getL(), this.getH());
			g.drawPolygon(getxSide(), getySide(), 4);
			g.drawPolygon(getxTop(), getyTop(), 4);
		}
	}

	public void move()
	{
		if(getMove() == true)
		{
			if(this.getX() + 1 < 1150)
			{
				this.setX(getX() + 1);
			}
		}

		// This keeps the box moving even if the button is pressed past the scanner
		else if(this.getX() > 200)
		{
			if(this.getX() + 1 < 1150)
			{
				this.setX(getX() + 1);
			}
		}
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

	public int getH() 
	{
		return height;
	}

	public void setHeight(int height) 
	{
		this.height = height;
	}

	public int getL() 
	{
		return length;
	}

	public void setLength(int length) 
	{
		this.length = length;
	}

	public int getWidth() 
	{
		return width;
	}

	public void setWidth(int width) 
	{
		this.width = width;
	}

	public int getThreeD() 
	{
		return threeD;
	}

	public void setThreeD(int threeD) 
	{
		this.threeD = threeD;
	}

	public int getColor() 
	{
		return color;
	}

	public void setColor(int color) 
	{
		this.color = color;
	}

	public boolean getMove() 
	{
		return move;
	}

	public void setMove(boolean move) 
	{
		this.move = move;
	}

	public int[] getxTop() 
	{
		return xTop;
	}

	public void setxTop(int[] xTop) 
	{
		this.xTop = xTop;
	}

	public int[] getxSide() 
	{
		return xSide;
	}

	public void setxSide(int[] xSide) 
	{
		this.xSide = xSide;
	}

	public int[] getyTop() 
	{
		return yTop;
	}

	public void setyTop(int[] yTop) 
	{
		this.yTop = yTop;
	}

	public int[] getySide() 
	{
		return ySide;
	}

	public void setySide(int[] ySide) 
	{
		this.ySide = ySide;
	}

	public boolean isRunJumpOnce() 
	{
		return runJumpOnce;
	}

	public void setRunJumpOnce(boolean runJumpOnce) 
	{
		this.runJumpOnce = runJumpOnce;
	}
}
