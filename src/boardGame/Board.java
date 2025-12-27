package boardGame;

public class Board {
    private Integer rows;
    private Integer Columns;
    private Piece[][] pieces;

    public Board(Integer rows, Integer columns) {
        this.rows = rows;
        Columns = columns;
        pieces = new Piece[rows][columns];
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getColumns() {
        return Columns;
    }

    public void setColumns(Integer columns) {
        Columns = columns;
    }


}
