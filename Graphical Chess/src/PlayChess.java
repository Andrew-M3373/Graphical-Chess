import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.Scanner;
public class PlayChess extends Canvas
	{
		static int className;
		static JFrame frame = new JFrame();
		private static final long	serialVersionUID	= 1L;
		static int largeness = 0;
		static int color1 = 0;
		static int color2 = 1;
		static String name1;
		static String name2;

		
		public static void main(String[] args)
			{
				PlayChess canvas = new PlayChess();
		        JFrame frame = new JFrame();
		        ImageIcon king = new ImageIcon("King3.png");
		        JLabel label = new JLabel(king);
		        frame.add(label);
		        frame.pack();
		        frame.setSize(800, 800);
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.getContentPane().add(canvas).setBackground(Color.white);
		        frame.setLocationRelativeTo(null); //Sets JPanel to center of screen 
		        frame.setResizable(true);
		        frame.setVisible(true);
		        
		        
		        graphicallyGreetPlayer();
		        ChessPieceDatabase.loadData();
			}

		private static void graphicallyGreetPlayer()
			{
				name1 = JOptionPane.showInputDialog("Player 1, what is your name?");
				if(name1.length() == 1)
					{
						name1.substring(0).toUpperCase();
					}
				else if(name1.length() > 1)
					{						
						name1 = name1.substring(0,1).toUpperCase() + name1.substring(1).toLowerCase();
					}
				JOptionPane.showMessageDialog(frame, "Welcome to chess, " + name1 + "!");
				name2 = JOptionPane.showInputDialog("Player 2, what is your name?");
				if(name2.length() == 1)
					{
						name2.substring(0).toUpperCase();
					}
				else if(name2.length() > 1)
					{						
						name2 = name2.substring(0,1).toUpperCase() + name2.substring(1).toLowerCase();
					}
				JOptionPane.showMessageDialog(frame, "Welcome to chess, " + name2 + "!");
				
				final String[] colorOptions = {"Black", "White" };
				final JFrame frame = new JFrame();
			    String colorType = (String) JOptionPane.showInputDialog(
			    		frame, 
			            name1 + " , Which color chess pieces would you like to use?",
			            "Which color?",
			            JOptionPane.QUESTION_MESSAGE,
			            null, 
			            colorOptions, 
			            colorOptions[0]);
			    JOptionPane.showMessageDialog(frame, "Player 1, " + name1 + ", you will start first. Are you ready to play?");
			    if(colorType.equals("White"))
			    	{
			    		color1 = 0;
			    		color2 = 1;
			    	}
			    else if(colorType.equals("Black"))
			    	{
			    		color1 = 1;
			    		color2 = 0;
			    	}
			}
		
		public void paint(Graphics graphics)
		{
			graphics.setColor(new Color(0,255,0));
//			graphics
	        ImageIcon king = new ImageIcon("King.png");
	        
		}
		
		public BufferedImage scaleImage(int WIDTH, int HEIGHT, String filename)
		{
			BufferedImage bi = null;
			try
				{
					ImageIcon ii = new ImageIcon("King.png");
					bi = new BufferedImage(25, 25, BufferedImage.TYPE_INT_RGB);
					Graphics2D g2d = (Graphics2D) bi.createGraphics();
					g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
					g2d.drawImage(ii.getImage(), 0, 0, 25, 25, null);
				}
			catch (Exception e)
				{
					e.printStackTrace();
					return null;
				}
			return bi;
		}
	}