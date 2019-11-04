import java.awt.*;

//import java.awt.image.BufferedImage;
//import java.io.IOException;
//import java.net.URL;
//import java.io.File;
//import javax.imageio.ImageIO;
import javax.swing.*;
//import java.util.Scanner;

public class PlayChess extends JFrame
	{
		static int className;
		static JFrame frame = new JFrame();
		private static final long	serialVersionUID	= 1L;
		static int largeness = 0;
		static int color1 = 0;
		static int color2 = 1;
		static String name1;
		static String name2;
		static boolean stillPlaying = true;
		static ImageIcon king;

		
		public static void main(String[] args)
			{
//				PlayChess canvas = new PlayChess();
		        JFrame frame = new JFrame();
		        frame.pack();
		        frame.setSize(800, 800);
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.setLayout(null);
		        frame.getContentPane().setBackground(Color.YELLOW);
		        frame.setLocationRelativeTo(null);; //Sets JPanel to center of screen 
		        frame.setResizable(true);
		        frame.setVisible(true);
		        
		        showCurrentBoard();
		        greetPlayer();
		        ChessPieceDatabase.loadData();
//		        while(stillPlaying)
//		        {
//		        	showCurrentBoard();
//		        }
			}

		private static void greetPlayer()
			{
				final JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame, "Welcome to the Game of Chess!!");
				name1 = JOptionPane.showInputDialog("Player 1, what is your name?");
				if(name1.isEmpty())
				{
					cancelGame();
				}
				else if(name1.length() == 1)
					{
						name1.substring(0).toUpperCase();
					}
				else if(name1.length() > 1)
					{						
						name1 = name1.substring(0,1).toUpperCase() + name1.substring(1).toLowerCase();
					}
				JOptionPane.showMessageDialog(frame, "Welcome to chess, " + name1 + "!");
				name2 = JOptionPane.showInputDialog("Player 2, what is your name?");
				if(name2.isEmpty())
				{
					cancelGame();
				}
				else if(name2.length() == 1)
					{
						name2.substring(0).toUpperCase();
					}
				else if(name2.length() > 1)
					{						
						name2 = name2.substring(0,1).toUpperCase() + name2.substring(1).toLowerCase();
					}
				JOptionPane.showMessageDialog(frame, "Welcome to chess, " + name2 + "!");
				
				final String[] colorOptions = {"Black", "White", "Cancel"};
			    String colorType = (String) JOptionPane.showInputDialog(
			    		frame, 
			            name1 + ", which color chess pieces would you like to use?",
			            "Which color?",
			            JOptionPane.QUESTION_MESSAGE,
			            null, 
			            colorOptions, 
			            colorOptions[0]);
			    if(colorType.equals("Cancel"))
			    {
			    	cancelGame();
			    }
			    else if(colorType.equals("White"))
			    	{
			    		color1 = 0;
			    		color2 = 1;
			    	}
			    else if(colorType.equals("Black"))
			    	{
			    		color1 = 1;
			    		color2 = 0;
			    	}
			    if (JOptionPane.showConfirmDialog(frame, name1 + ", you will start first. Are you ready to play?", "Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)
			    {
			    	cancelGame();
			    }
			}
		
		public static void showCurrentBoard()
		{
			king = new ImageIcon(new ImageIcon("KingBW.png").getImage().getScaledInstance(80, 80, Image.SCALE_AREA_AVERAGING));
			JLabel label = new JLabel(king);
			frame.add(label);
			Dimension size = label.getPreferredSize();
			label.setBounds(100, 100, size.width, size.height);
		}
		
		public void paint(Graphics graphics)
		{
			
		}
		
//		public static Image getScaledImage(Image srcImg, int w, int h)
//		{
//			BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
//			Graphics2D g2 = resizedImg.createGraphics();
//			
//			g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//			g2.drawImage(srcImg, 0, 0, w, h, null);
//			g2.dispose();
//			
//			return resizedImg;
//		}
		
		public static void cancelGame()
		{
			JOptionPane.showMessageDialog(frame, "Sorry to see you leave, but thanks for playing while you could!");
			System.exit(0);
		}
	}