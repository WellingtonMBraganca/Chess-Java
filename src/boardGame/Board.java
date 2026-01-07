package boardGame;

public class Board {
    private Integer rows;
    private Integer Columns;
    private Piece[][] pieces;

    public Board(Integer rows, Integer columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("Error creating board: There must be at least one row and one column.");
        }
        this.rows = rows;
        Columns = columns;
        pieces = new Piece[rows][columns];
    }

    public Integer getRows() {
        return rows;
    }

    public Integer getColumns() {
        return Columns;
    }

    public Piece piece(int row, int column) {
        if (!positionExist(row, column)) {
            throw new BoardException("The selected position do not exist on the board.");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position) {
        if (!positionExist(position)) {
            throw new BoardException("The selected position do not exist on the board.");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)) {
            throw new BoardException("There is already a piece on this position." + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    private boolean positionExist(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < Columns;
    }

    public boolean positionExist(Position position) {
        return positionExist(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position) {
        if (!positionExist(position)) {
            throw new BoardException("The selected position do not exist on the board.");
        }
        return piece(position) != null;
    }

    public Piece removePiece(Position position){
        if (!positionExist(position)){
            throw new BoardException("Position not on the board.");
        }
        if(piece(position) == null){
            return null;
        }
        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColumn()] = null;
        return aux;
    }
}
