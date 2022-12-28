import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;
import java.awt.*;

public class Scanner {

	private BufferedImage blue = null;
	private BufferedImage green = null;
	private BufferedImage yellow = null;
	private BufferedImage among = null;

	private int[] xTriangle;
	private int[] yTriangle;
	private int[] xThreeD;
	private int[] yThreeD;

	public Scanner(int x, int y)
	{
		try {
			setBlue(ImageIO.read(new File("plane.png")));
			setGreen(ImageIO.read(new File("truck.png")));
			setYellow(ImageIO.read(new File("questionmark.png")));
			setAmong(ImageIO.read(new File("amongUs.png")));

		} catch (IOException e) {
			System.out.println("No Image");
		}

		setxTriangle(new int[6]);
		setyTriangle(new int[6]);
		setxThreeD(new int[6]);
		setyThreeD(new int[6]);

	}
	public void paint(Graphics g)
	{
		Graphics g2d = (Graphics2D) g;

		int x = 140;
		int y = 225;

		g2d.setColor(new Color(114, 79, 255));

		getxTriangle()[0] = x + 80; // top left
		getxTriangle()[1] = x + 80; // bottom left
		getxTriangle()[2] = x + 160; // nudge bottom
		getxTriangle()[3] = x + 380; // bottom right
		getxTriangle()[4] = x + 380; // top right
		getxTriangle()[5] = x + 160; // nudge top

		getyTriangle()[0] = y + 20; // top left
		getyTriangle()[1] = y + 120; // bottom left
		getyTriangle()[2] = y + 120; // nudge bottom
		getyTriangle()[3] = y + 340; // bottom right
		getyTriangle()[4] = y - 180; // top right
		getyTriangle()[5] = y + 20; // nudge top

		g2d.fillPolygon(getxTriangle(), getyTriangle(), 6);
		g2d.setColor(Color.black);
		g2d.drawPolygon(getxTriangle(), getyTriangle(), 6);
		g2d.setColor(new Color(114, 79, 255).darker());

		getxThreeD()[0] = x + 40; // top left
		getxThreeD()[1] = x + 80; // bottom left
		getxThreeD()[2] = x + 160; // nudge bottom
		getxThreeD()[3] = x + 380; // top right
		getxThreeD()[4] = x + 335; // top right left
		getxThreeD()[5] = x + 120; // top nudge

		getyThreeD()[0] = y - 30; // top left
		getyThreeD()[1] = y + 20; // bottom left
		getyThreeD()[2] = y + 20; // nudge bottom
		getyThreeD()[3] = y - 180; // top right
		getyThreeD()[4] = y - 230; // top right left
		getyThreeD()[5] = y - 30; // top nudge


		g2d.fillPolygon(getxThreeD(), getyThreeD(), 6);
		g2d.setColor(Color.black);
		g2d.drawPolygon(getxThreeD(), getyThreeD(), 6);

		g.drawImage(getAmong(), 300, 218, 230, 146, null);
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

	public BufferedImage getAmong() 
	{
		return among;
	}

	public void setAmong(BufferedImage among) 
	{
		this.among = among;
	}

	public int[] getxTriangle() 
	{
		return xTriangle;
	}

	public void setxTriangle(int[] xTriangle) 
	{
		this.xTriangle = xTriangle;
	}

	public int[] getyTriangle() 
	{
		return yTriangle;
	}

	public void setyTriangle(int[] yTriangle) 
	{
		this.yTriangle = yTriangle;
	}

	public int[] getxThreeD() 
	{
		return xThreeD;
	}

	public void setxThreeD(int[] xThreeD) 
	{
		this.xThreeD = xThreeD;
	}

	public int[] getyThreeD() 
	{
		return yThreeD;
	}

	public void setyThreeD(int[] yThreeD) 
	{
		this.yThreeD = yThreeD;
	}
}

