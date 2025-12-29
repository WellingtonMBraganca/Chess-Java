import chess.ChessMatch;
import chess.ChessPiece;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

public class UserInterface {
    public static void printBoard(ChessPiece[][] pieces){
        IntStream.range(0, pieces.length).forEach(i -> {
            System.out.print((8 - i) + " ");

            Arrays.stream(pieces[i]).forEach(piece -> printPiece(piece));

            System.out.println();
        });
        System.out.println("  A B C D E F G H");
    }

    private static void printPiece (ChessPiece piece){
        String output = Optional.ofNullable(piece)
                .map(ChessPiece::toString)
                .orElse("-");
        System.out.print(output + " ");
    }


}
