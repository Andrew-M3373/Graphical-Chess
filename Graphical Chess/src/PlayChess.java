import java.awt.*;
import java.util.ArrayList;

//import java.awt.image.BufferedImage;
//import java.io.IOException;
//import java.net.URL;
//import java.io.File;
//import javax.imageio.ImageIO;
import javax.swing.*;
//import java.util.Scanner;

public class PlayChess extends Canvas
	{
		static JFrame frame = new JFrame();
		private static final long	serialVersionUID	= 1L;
		static int largeness = 0;
		static int color1 = 0;
		static int color2 = 1;
		static String name1;
		static String name2;
		static boolean stillPlaying = true;
		static ImageIcon piece;
		static ImageIcon checkerboard;
		static int SearchInt;
		static String xyPlayerOne;
		static String x1;
		static String y1;
		static String xyPlayerTwo;
		static String x2;
		static String y2;
		static String pieceName;
		static String x;
		static String toMoveTo1;
		static String toMoveTo2;

		
		public static void main(String[] args)
			{
		        final JFrame frame = new JFrame("Chess Game");
		        frame.pack();
		        frame.setSize(840, 800);
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.setLayout(null);
		        frame.getContentPane().setBackground(Color.YELLOW);
		        frame.setLocationRelativeTo(null);; //Sets JPanel to center of screen 
		        frame.setResizable(true);
		        frame.setVisible(true);

		        greetPlayer();
		        ChessPieceDatabase.loadData();
		        
		        while(stillPlaying)
		        {
		        	// The following initiates all of the images and places them in the JFrame
		        	for(Chess c: ChessPieceDatabase.chessPieces)
		        	{
//		        		JLabel label = new JLabel("A");
//		        		label.setFont(new Font("Arial", 30, 30));
//		        		label.setBounds(0, 0, 200, 50);;
//		        		frame.add(label);
				        piece = new ImageIcon(new ImageIcon(c.getFile()).getImage().getScaledInstance(80, 80, Image.SCALE_AREA_AVERAGING));
						JLabel pieceLabel = new JLabel(piece);
						frame.add(pieceLabel);
						Dimension pieceSize = pieceLabel.getPreferredSize();
						pieceLabel.setBounds(100 + (80*c.getxCoordinate()), 20 + (80*c.getyCoordinate()), pieceSize.width, pieceSize.height);
		        	}
		        	// The following creates the background of the chess board
			        checkerboard = new ImageIcon(new ImageIcon("Checkerboard.png").getImage().getScaledInstance(640, 640, Image.SCALE_AREA_AVERAGING));
			        JLabel checkerboardLabel = new JLabel(checkerboard);
			        frame.add(checkerboardLabel);
			        Dimension checkerboardSize = checkerboardLabel.getPreferredSize();
			        checkerboardLabel.setBounds(100, 20, checkerboardSize.width, checkerboardSize.height);
			        
			        oneSecondDelay();
			        
			        playerOneMove();
			        playerTwoMove();
		        }
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

		private static void playerOneMove() 
		{
			final JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, name1 + ", it is your turn.");
			xyPlayerOne = JOptionPane.showInputDialog("Please type the complete coordinates \nof the piece you would like to move. \n(Example: b3)")
					.substring(0).toLowerCase();
			x1 = xyPlayerOne.substring(0,1);
			y1 = xyPlayerOne.substring(1);
			for(Chess c: ChessPieceDatabase.chessPieces)
			{
				switch(c.getyCoordinate())
				{
				case 0: 
					x = "a"; 
					break;
				case 1: 
					x = "b"; 
					break;
				case 2: 
					x = "c"; 
					break;
				case 3: 
					x = "d"; 
					break;
				case 4: 
					x = "e"; 
					break;
				case 5: 
					x = "f"; 
					break;
				case 6: 
					x = "g"; 
					break;
				case 7: 
					x = "h"; 
					break;
				}
				if(y1.equals(c.getyCoordinate()) && x1.equals(x))
				{
					pieceName = c.getPieceName();
					movePiece();
				}
			}
		}

		private static void playerTwoMove() 
		{
			final JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, name2 + ", it is your turn.");
		}

		private static void movePiece() 
		{
			final JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "You have chosen to move your " + pieceName);
			if(pieceName.equals("Pawn"))
			{
//				toMoveTo1 = (String) JOptionPane.showInputDialog(frame, 
//						"You have the following options to move your " + pieceName + " to.", 
//						"Which spot?", 
//						JOptionPane.QUESTION_MESSAGE, 
//						null, 
//						, possibleMoves.get(0));
			}
		}

		private static void oneSecondDelay() 
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		public static void cancelGame()
		{
			JOptionPane.showMessageDialog(frame, "Sorry to see you leave, but thanks for playing while you could!");
			System.exit(0);
		}
	}