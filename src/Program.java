import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.*;

public class Program {
    static void main() {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();


        while(!chessMatch.getCheckMate()){
           try {
               UserInterface.clearScreen();
               UserInterface.printMatch(chessMatch, captured);
               System.out.println();
               System.out.print("Source: ");
               ChessPosition source = UserInterface.readChessPosition(sc);

               boolean[][] possibleMoves = chessMatch.possibleMoves(source);
               UserInterface.clearScreen();
               UserInterface.printBoard(chessMatch.getPieces(), possibleMoves);

               System.out.println();
               System.out.print("Target: ");
               ChessPosition target = UserInterface.readChessPosition(sc);

               ChessPiece capturedPiece = chessMatch.porformChessMove(source, target);

               if (capturedPiece != null){
                   captured.add(capturedPiece);
               }

               if (chessMatch.getPromoted() != null){
                   System.out.println("Select the promoted piece: (B/N/R/Q)");
                   String type = sc.nextLine();
                   while (!type.equals("B") && !type.equals("N") && !type.equals("R") && !type.equals("Q")){
                       System.out.println("invalid value! Enter piece for promotion.");
                       type = sc.nextLine();
                   }


                       chessMatch.replacePromotedPiece(type.toUpperCase());
               }
           }
           catch (ChessException e ){
               System.out.println(e.getMessage());
               sc.nextLine();
           }
           catch (InputMismatchException e){
               System.out.println(e.getMessage());
               sc.nextLine();
           }
        }
        UserInterface.clearScreen();
        UserInterface.printMatch(chessMatch, captured);
    }
}
