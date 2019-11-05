import java.util.ArrayList;

public class ChessPieceDatabase
	{
		static ArrayList<Chess>chessPieces = new ArrayList<Chess>();
		public static void loadData()
		{
			chessPieces.add(new Chess(0,0,"Rook",0,PlayChess.color1,"RookW.png"));
			chessPieces.add(new Chess(7,0,"Rook",0,PlayChess.color1,"RookW.png"));
			chessPieces.add(new Chess(1,0,"Knight",0,PlayChess.color1,"KnightW.png"));
			chessPieces.add(new Chess(6,0,"Knight",0,PlayChess.color1,"KnightW.png"));
			chessPieces.add(new Chess(2,0,"Bishop",0,PlayChess.color1,"BishopW.png"));
			chessPieces.add(new Chess(5,0,"Bishop",0,PlayChess.color1,"BishopW.png"));
			chessPieces.add(new Chess(3,0,"King",0,PlayChess.color1,"KingW.png"));
			chessPieces.add(new Chess(4,0,"Queen",0,PlayChess.color1,"QueenW.png"));
			chessPieces.add(new Chess(0,1,"Pawn",0,PlayChess.color1,"PawnW.png"));
			chessPieces.add(new Chess(1,1,"Pawn",0,PlayChess.color1,"PawnW.png"));
			chessPieces.add(new Chess(2,1,"Pawn",0,PlayChess.color1,"PawnW.png"));
			chessPieces.add(new Chess(3,1,"Pawn",0,PlayChess.color1,"PawnW.png"));
			chessPieces.add(new Chess(4,1,"Pawn",0,PlayChess.color1,"PawnW.png"));
			chessPieces.add(new Chess(5,1,"Pawn",0,PlayChess.color1,"PawnW.png"));
			chessPieces.add(new Chess(6,1,"Pawn",0,PlayChess.color1,"PawnW.png"));
			chessPieces.add(new Chess(7,1,"Pawn",0,PlayChess.color1,"PawnW.png"));
			chessPieces.add(new Chess(0,7,"Rook",0,PlayChess.color2,"RookB.png"));
			chessPieces.add(new Chess(7,7,"Rook",0,PlayChess.color2,"RookB.png"));
			chessPieces.add(new Chess(1,7,"Knight",0,PlayChess.color2,"KnightB.png"));
			chessPieces.add(new Chess(6,7,"Knight",0,PlayChess.color2,"KnightB.png"));
			chessPieces.add(new Chess(2,7,"Bishop",0,PlayChess.color2,"BishopB.png"));
			chessPieces.add(new Chess(5,7,"Bishop",0,PlayChess.color2,"BishopB.png"));
			chessPieces.add(new Chess(3,7,"King",0,PlayChess.color2,"KingB2.png"));
			chessPieces.add(new Chess(4,7,"Queen",0,PlayChess.color2,"QueenB.png"));
			chessPieces.add(new Chess(0,6,"Pawn",0,PlayChess.color2,"PawnB.png"));
			chessPieces.add(new Chess(1,6,"Pawn",0,PlayChess.color2,"PawnB.png"));
			chessPieces.add(new Chess(2,6,"Pawn",0,PlayChess.color2,"PawnB.png"));
			chessPieces.add(new Chess(3,6,"Pawn",0,PlayChess.color2,"PawnB.png"));
			chessPieces.add(new Chess(4,6,"Pawn",0,PlayChess.color2,"PawnB.png"));
			chessPieces.add(new Chess(5,6,"Pawn",0,PlayChess.color2,"PawnB.png"));
			chessPieces.add(new Chess(6,6,"Pawn",0,PlayChess.color2,"PawnB.png"));
			chessPieces.add(new Chess(7,6,"Pawn",0,PlayChess.color2,"PawnB.png"));
		}
	}
