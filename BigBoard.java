public class BigBoard {

    private MiniBoard[] bigBoard;
    private int boardRowSize;
    private int boardColSize;

    //default construction of the big board
    BigBoard() { this(3, 3); }

    //constructor for big board if change size but will generally just be
    //3x3
    BigBoard(int rowSize, int colSize) {
        this.setSize(rowSize, colSize);
    }

    //sets size of the big board
    public void setSize(int row, int col) {
        this.boardColSize = col;
        this.boardRowSize = row;
        init();
    }

    //initializes a 3x3 tic tac toe board which a mini board in each square
    private void init() {
        bigBoard = new MiniBoard[boardColSize * boardRowSize];
        for(int i = 0; i < bigBoard.length; i++) {
            MiniBoard mb = new MiniBoard(3, 3);
            bigBoard[i] = mb;
        }
    }

    public boolean isFull(int boardNumber) {
        if(boardNumber < 0) {
            boardNumber ++;
        }
        else if (boardNumber > 9) {
            boardNumber--;
        }
        return bigBoard[boardNumber-1].isFull();
    }

    public boolean makeMove(String mark, int board, int row, int col) {
         if(bigBoard[board].makeMove(mark, row, col)) {
             return true;
         }
         return false;
    }

    //prints every board sequentially but not in a 9x9 orientation
    public void printSequential() {
        for(int i = 0; i < bigBoard.length; i++) {
            bigBoard[i].print();
            System.out.println();
        }
        System.out.println("");
    }

    //prints the board in a 9x9 and tells you what board is what row and column
    //each for loop calls for a certain row for a certain board and
    //prints the needed rows so that they can be side by side
    public void printBoard() {
        for(int i = 0; i < 3; i++) {
            System.out.print("Board " + (i+1) + " | ");
            bigBoard[i].printRowOne();
            System.out.print("| ");
        }
        System.out.println();
        for(int i = 0; i < 3; i++) {
            System.out.print("Board " + (i+1) + " | ");
            bigBoard[i].printRowTwo();
            System.out.print("| ");
        }
        System.out.println();
        for(int i = 0; i < 3; i++) {
            System.out.print("Board " + (i+1) + " | ");
            bigBoard[i].printRowThree();
            System.out.print("| ");
        }
        System.out.println();
        for(int i = 3; i < 6; i++) {
            System.out.print("Board " + (i+1) + " | ");
            bigBoard[i].printRowOne();
            System.out.print("| ");
        }
        System.out.println();
        for(int i = 3; i < 6; i++) {
            System.out.print("Board " + (i+1) + " | ");
            bigBoard[i].printRowTwo();
            System.out.print("| ");
        }
        System.out.println();
        for(int i = 3; i < 6; i++) {
            System.out.print("Board " + (i+1) + " | ");
            bigBoard[i].printRowThree();
            System.out.print("| ");
        }
        System.out.println();
        for(int i = 6; i < 9; i++) {
            System.out.print("Board " + (i+1) + " | ");
            bigBoard[i].printRowOne();
            System.out.print("| ");
        }
        System.out.println();
        for(int i = 6; i < 9; i++) {
            System.out.print("Board " + (i+1) + " | ");
            bigBoard[i].printRowTwo();
            System.out.print("| ");
        }
        System.out.println();
        for(int i = 6; i < 9; i++) {
            System.out.print("Board " + (i+1) + " | ");
            bigBoard[i].printRowThree();
            System.out.print("| ");
        }
        System.out.println();
    }
    private boolean isWinner(int boardNumber) {
        //checks methods to see if there is a winner and returns true
        //if any of the methods are true
        if(getRowWin(boardNumber)) {
            return true;
        }
        else if(getColWin(boardNumber)) {
            return true;
        }
        else if(topLbottomRDiagonal(boardNumber)) {
            return true;
        }
        else if(bottomLtopRDiagonal(boardNumber)) {
            return true;
        }
        else
            return false;
    }

    //function that checks every single row if there is a winning state of the board
    private boolean getRowWin(int boardNumber) {
        boolean rowWin = false;
        int possibleWin = 0;
        //outer for loop loops through the rows
        for(int row = 0; row < bigBoard[boardNumber].getRowSize(); row++) {
            //inner for loop checks the columns of each row
            for(int col = 0; col < bigBoard[boardNumber].getColSize() - 1; col++) {
                //if checks if atleast 2 spots in the row are matching to check if there is a winning condition
                if(bigBoard[boardNumber].getMark(row, col).equals(bigBoard[boardNumber].getMark(row, col + 1)) && !bigBoard[boardNumber].getMark(row, col).equals("-")) {
                    //if atleast 2 are matching, this for loop checks this entire row to see if its a winning state
                    for(int i = 0; i < bigBoard[boardNumber].getColSize() -1; i++) {
                        if(!bigBoard[boardNumber].getMark(row, i).equals(bigBoard[boardNumber].getMark(row, i+1))) {
                            rowWin = false;
                            break;
                        }
                        //if not every spot equals eachother then it is not a win otherwise it is and then it breaks out
                        //of the triple for loop
                        else rowWin = true;
                    }
                }
                if(rowWin)
                    break;
            }
            if(rowWin) {
                break;
            }
        }
        return rowWin;
    }

    //this method checks each column to see if there is a winning state of the board
    private boolean getColWin(int boardNumber) {
        boolean colWin = false;
        int possibleWin = 0;
        //checks all columns to see if theres a possible winner
        //outer for loops through columns
        for(int col = 0; col < bigBoard[boardNumber].getColSize(); col++) {
            //inner for looks through the rows of each column to see if atleast 2 are matching and not -
            for(int row = 0; row < bigBoard[boardNumber].getRowSize() - 1; row++) {
                //if atleast 2 are matching, goes into another for loop that checks that entire column
                if(bigBoard[boardNumber].getMark(row, col).equals(bigBoard[boardNumber].getMark(row +  1, col)) && !bigBoard[boardNumber].getMark(row, col).equals("-")) {
                    for(int i = 0; i < bigBoard[boardNumber].getRowSize()-1; i++) {
                        //if any part of the column doesnt match, it is not a win and returns to looking through each row
                        //otherwise it is and it breaks out of all of the for loops
                        if(!bigBoard[boardNumber].getMark(i, col).equals(bigBoard[boardNumber].getMark(i + 1, col))) {
                            colWin = false;
                            break;
                        }
                        else colWin = true;
                    }
                }
                if(colWin)
                    break;
            }
            if(colWin){
                break;
            }
        }
        return colWin;
    }

    private boolean topLbottomRDiagonal (int boardNumber) {
        boolean tLbR = false;
        int col = 0;
        for(int row = 0; row < bigBoard[boardNumber].getRowSize() - 1; row++) {
            if(bigBoard[boardNumber].getMark(row, col).equals(bigBoard[boardNumber].getMark(row+1, col+1)) && !bigBoard[boardNumber].getMark(row,col).equals("-")
                    && !bigBoard[boardNumber].getMark(0, 0).equals("-"))   {
                tLbR = true;
                break;
            }
            col++;
        }
        col = 0;
        for(int row = 0; row < bigBoard[boardNumber].getRowSize() - 1; row++) {
            if(!bigBoard[boardNumber].getMark(row, col).equals(bigBoard[boardNumber].getMark(row + 1, col + 1))) {
                tLbR = false;
                break;
            }
            col++;
        }

        return tLbR;
    }

    private boolean bottomLtopRDiagonal (int boardNumber) {
        boolean bLtR = false;
        int col = bigBoard[boardNumber].getColSize() - 1;
        for(int row = 0; row < bigBoard[boardNumber].getRowSize() - 1; row++) {
            if(bigBoard[boardNumber].getMark(row,col).equals(bigBoard[boardNumber].getMark(row + 1, col - 1)) && !bigBoard[boardNumber].getMark(row,col).equals("-")
                    && !bigBoard[boardNumber].getMark(bigBoard[boardNumber].getRowSize() -1, bigBoard[boardNumber].getColSize() - 1).equals("-")) {
                bLtR = true;
                break;
            }
            col--;
        }
        col = bigBoard[boardNumber].getColSize() - 1;
        for(int row = 0; row < bigBoard[boardNumber].getRowSize() - 1; row++) {
            if(!bigBoard[boardNumber].getMark(row, col).equals(bigBoard[boardNumber].getMark(row + 1, col - 1))) {
                bLtR = false;
                break;
            }
            col--;
        }
        return bLtR;
    }
}
