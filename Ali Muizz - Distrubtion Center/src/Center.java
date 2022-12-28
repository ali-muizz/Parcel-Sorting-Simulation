import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Center extends JPanel {

	private Belt[] belt;
	private Scanner scanner;
	private Parcel parcel[];
	private Background theBackground = new Background(this);
	private int[] yEnter;
	private int[] xEnter;
	private BufferedImage blue = null;
	private BufferedImage green = null;
	private BufferedImage yellow = null;

	public Center()
	{
		setBelt(new Belt[4]);
		try {
			setBlue(ImageIO.read(new File("plane.png")));
			setGreen(ImageIO.read(new File("truck.png")));
			setYellow(ImageIO.read(new File("questionmark.png")));

		} catch (IOException e) {
			System.out.println("No Image");
		}
		setxEnter(new int[4]);
		setyEnter(new int[4]);
		setParcel(new Parcel[20]);

		for(int i = 0; i < getParcel().length; i++)
		{
			getParcel()[i] = new Parcel(i * -580, 290);
			getBelt()[0] = new Belt(-100,295,500,50,getParcel()[i], false);
			getBelt()[1] = new Belt(500,140,550,50,getParcel()[i], true);
			getBelt()[2] = new Belt(500,295,550,50,getParcel()[i], true);
			getBelt()[3] = new Belt(500,450,550,50,getParcel()[i], true);
		}

		setScanner(new Scanner(350, 0));

		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				for(int i = 0; i < getParcel().length; i++)
				{
					getParcel()[i].keyPressed(e);
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});
		setFocusable(true);
	}
	@Override

	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;

		getTheBackground().paint(g2d);
		g2d.setColor(Color.GRAY);

		g2d.setColor(Color.BLACK);

		getxEnter()[0] = 140 + 40; 
		getxEnter()[1] = 140 + 40;
		getxEnter()[2] = 140 + 80;
		getxEnter()[3] = 140 + 80;

		getyEnter()[0] = 225 - 30;		// top left
		getyEnter()[1] = 225 + 70;	// bottom left
		getyEnter()[2] = 225 + 70;	// bottom right
		getyEnter()[3] = 225 + 20;	// top right

		g2d.fillPolygon(getxEnter(), getyEnter(), 4);

		for(int f = 0; f < getParcel().length; f++)
		{
			if(getParcel()[f].getX() > 380)
			{
				if(getParcel()[f].getColor() == 1)
				{
					g.drawImage(getBlue(), 150, getTheBackground().getBlimpYMovement() + 150, 80, 80, null);
				}
				if(getParcel()[f].getColor() == 2)
				{
					g.drawImage(getGreen(), 150, getTheBackground().getBlimpYMovement() + 150, 80, 80, null);
				}
				if(getParcel()[f].getColor() == 3)
				{
					g.drawImage(getYellow(), 150, getTheBackground().getBlimpYMovement() + 150, 80, 80, null);
				}
			}
		}

		for(Belt k:getBelt())
		{
			k.paint(g2d);
		}
		for(Parcel i:getParcel())
		{
			i.paint(g2d);
		}

		getScanner().paint(g2d);

		// Makes the scanner light turn on and off
		g2d.setColor(Color.lightGray);
		g2d.setColor(Color.darkGray);

		for (int i = 0; i < getParcel().length; i++) {
			if(getParcel()[i].getX() >= 200 && getParcel()[i].getX() <= 380) 
			{
				g2d.setColor(Color.green);
			}
		}
		g2d.fillOval(240, 275, 45, 45);
	}

	public void move()
	{
		// attempting to make right boxes move

		getTheBackground().move();

		for(int i = 0; i < getParcel().length; i++)
		{
			if(getParcel()[i].getX() > 470 && getParcel()[i].getX() < 1020)
			{
				if(Math.abs(getBelt()[1].getY() - getParcel()[i].getY()) < 50) // Checks the difference in height for which belt to move
				{
					getBelt()[1].move();
				}

				if(Math.abs(getBelt()[2].getY() - getParcel()[i].getY()) < 50) // Checks the difference in height for which belt to move
				{
					getBelt()[2].move();
				}

				if(Math.abs(getBelt()[3].getY() - getParcel()[i].getY()) < 50) // Checks the difference in height for which belt to move
				{
					getBelt()[3].move();
				}
			}
		}

		getBelt()[0].move(); // Always keeps the left one moving

		for(int i = 0; i < getParcel().length; i++)
		{
			getParcel()[i].move();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Center a = new Center();

		JFrame frame = new JFrame("Distribution Center");
		frame.add(a);
		frame.setSize(1020,640);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		while(true)
		{
			a.move();
			a.repaint();
			Thread.sleep(10);
		}

	}
	public Belt[] getBelt() 
	{
		return belt;
	}

	public void setBelt(Belt[] belt) 
	{
		this.belt = belt;
	}

	public Scanner getScanner() 
	{
		return scanner;
	}

	public void setScanner(Scanner scanner) 
	{
		this.scanner = scanner;
	}

	public Parcel[] getParcel() 
	{
		return parcel;
	}

	public void setParcel(Parcel parcel[]) 
	{
		this.parcel = parcel;
	}

	public Background getTheBackground() 
	{
		return theBackground;
	}

	public void setTheBackground(Background theBackground) 
	{
		this.theBackground = theBackground;
	}

	public int[] getyEnter() 
	{
		return yEnter;
	}

	public void setyEnter(int[] yEnter) 
	{
		this.yEnter = yEnter;
	}

	public int[] getxEnter() 
	{
		return xEnter;
	}

	public void setxEnter(int[] xEnter) 
	{
		this.xEnter = xEnter;
	}

	public BufferedImage getBlue() 
	{
		return blue;
	}

	public void setBlue(BufferedImage blue) 
	{
		this.blue = blue;
	}

	public BufferedImage getGreen() 
	{
		return green;
	}

	public void setGreen(BufferedImage green) 
	{
		this.green = green;
	}

	public BufferedImage getYellow() 
	{
		return yellow;
	}

	public void setYellow(BufferedImage yellow) 
	{
		this.yellow = yellow;
	}
}
