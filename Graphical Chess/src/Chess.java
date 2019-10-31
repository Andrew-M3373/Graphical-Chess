
public class Chess
	{
		private int xCoordinate;
		private int yCoordinate;
		private String pieceName;
		private int isPieceAlive;
		private int color;
		
		public Chess(int x, int y, String n, int a, int c)
		{
			xCoordinate = x;
			yCoordinate = y;
			pieceName = n;
			isPieceAlive = a;
			color = c;
		}

		public int getColor()
			{
				return color;
			}

		public void setColor(int color)
			{
				this.color = color;
			}

		public int getxCoordinate()
			{
				return xCoordinate;
			}

		public void setxCoordinate(int xCoordinate)
			{
				this.xCoordinate = xCoordinate;
			}

		public int getyCoordinate()
			{
				return yCoordinate;
			}

		public void setyCoordinate(int yCoordinate)
			{
				this.yCoordinate = yCoordinate;
			}

		public String getPieceName()
			{
				return pieceName;
			}

		public void setPieceName(String pieceName)
			{
				this.pieceName = pieceName;
			}

		public int getIsPieceAlive()
			{
				return isPieceAlive;
			}

		public void setIsPieceAlive(int isPieceAlive)
			{
				this.isPieceAlive = isPieceAlive;
			}

	}
