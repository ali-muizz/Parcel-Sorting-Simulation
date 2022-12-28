import javax.imageio.*;
import java.io.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Background {

	private int x;
	private int y;
	private Center reference;
	private BufferedImage img = null;
	private BufferedImage blimp = null;
	private int blimpYMovement; 
	private int ya;

	public Background(Center reference)
	{
		try
		{
			setImg(ImageIO.read(new File("superpurple.png")));
			setBlimp(ImageIO.read(new File("blimp.png")));
		}
		catch (IOException e)
		{
			System.out.println("No Image");
		}		
		this.setX(0);
		this.setY(0);
		this.setReference(reference);
		setBlimpYMovement(300);
		setYa(1);
	}

	public void paint(Graphics2D g)
	{		
		g.drawImage(getImg(), getX(), getY(), getReference().getWidth() * 2, getReference().getHeight(), null);

		g.drawImage(getImg(), getX() + getReference().getWidth() * 2 - 1, getY(), getReference().getWidth() * 2, getReference().getHeight(), null);

		g.drawImage(getBlimp(), 300, getBlimpYMovement(), -250, 400, null);	
	}

	public void move()
	{
		this.setX(this.getX() - 1);

		if(getX() == -2010)
		{
			this.setX(0);
		}

		if ((getBlimpYMovement() + getYa() > 375 || getBlimpYMovement() + getYa() < 200))
		{
			setYa(getYa() * -1);
		}

		setBlimpYMovement(getBlimpYMovement() + getYa());
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

	public Center getReference() 
	{
		return reference;
	}

	public void setReference(Center reference) 
	{
		this.reference = reference;
	}

	public int getYa() 
	{
		return ya;
	}

	public void setYa(int ya) 
	{
		this.ya = ya;
	}

	public int getBlimpYMovement() 
	{
		return blimpYMovement;
	}

	public void setBlimpYMovement(int blimpYMovement) 
	{
		this.blimpYMovement = blimpYMovement;
	}

	public BufferedImage getImg() 
	{
		return img;
	}

	public void setImg(BufferedImage img) 
	{
		this.img = img;
	}

	public BufferedImage getBlimp() 
	{
		return blimp;
	}

	public void setBlimp(BufferedImage blimp) 
	{
		this.blimp = blimp;
	}
}

