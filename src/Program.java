import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.Scanner;

public class Program {
    static void main() {

        Scanner sc = new Scanner(System.in);

        ChessMatch chessMatch = new ChessMatch();

        while(true){
            UserInterface.printBoard(chessMatch.getPieces());
            System.out.println();
            System.out.print("Source: ");
            ChessPosition source = UserInterface.readChessPosition(sc);

            System.out.println();
            System.out.print("Target: ");
            ChessPosition target = UserInterface.readChessPosition(sc);

            ChessPiece capturedPiece = chessMatch.porformChessMove(source, target);

        }
    }
}
