public class MiniBoard {

    private Box[] boxes;
    private int boardRowSize;
    private int boardColSize;

    //default construction
    MiniBoard() { this(3, 3); }

    //construction for board if changing but will pretty much only be 3x3
    MiniBoard(int rowSize, int colSize) {
        this.setSize(rowSize,colSize);
    }

    //sets size of board which will just be 3x3
    public void setSize (int row, int col) {
        this.boardColSize = col;
        this.boardRowSize = row;
        init();
    }

    public int getColSize() { return boardColSize; }

    public int getRowSize() { return boardRowSize; }

    public String getMark(int row, int col) { return boxes[row * this.boardRowSize + col].getPlaceHolder(); }


    //initialize a tictactoe board with boxes filled with -
    private void init() {
        boxes = new Box[boardColSize * boardRowSize];
        for(int i = 0; i < boxes.length; i++) {
            Box b = new Box(i / boardRowSize, i % boardColSize);
            boxes[i] = b;
        }
    }

    public boolean makeMove(String mark, int row, int col) {
         if(boxes[row * boardRowSize + col].setPlaceHolder(mark)) {
             return true;
         }
         return false;
    }

    //prints the entire tictactoe board
    public void print() {
        for(int i = 0; i < boxes.length; i++) {
            if(i != 0 && i % boardColSize == 0) System.out.println();
            boxes[i].print();
        }
        System.out.println("");
    }

    //print for row 1
    public void printRowOne() {
        for(int i = 0; i < 3; i++) {
            boxes[i].print();
        }
    }

    //print for row 2
    public void printRowTwo() {
        for(int i = 3; i < 6; i++) {
            boxes[i].print();
        }
    }

    //print for row 3
    public void printRowThree() {
        for(int i = 6; i < 9; i++) {
            boxes[i].print();
        }
    }

    //checks if tic tac toe board is full and if any is available
    //then it returns false
    //if there isnt any available boxes then it returns true
    public boolean isFull() {
        for(Box b : boxes)
            if(b.isAvailable()) return false;
            return true;
    }

}
