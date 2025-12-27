package boardGame;

public class Piece {
    //Somente classes no mesmo pacote e subclasses acessam esse atributo protected
    // Para que a camada de partida não tenha acesso a camada de tabuleiro...
    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }
}
