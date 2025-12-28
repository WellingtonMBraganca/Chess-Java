import chess.ChessMatch;

public class Program {
    static void main() {

        ChessMatch chessMatch = new ChessMatch();
        UserInterface.printBoard(chessMatch.getPieces());
    }
}
