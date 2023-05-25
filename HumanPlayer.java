import java.util.*;

public class HumanPlayer extends AbstractPlayer {
    Scanner input = new Scanner(System.in);

    public HumanPlayer(String name, String mark) {
        super(name, mark);
    }

    public int selectBoardNumber(int range) {
        System.out.println("Please select a valid board number (1 to 9)");
        int board;
        do {
            board = input.nextInt() - 1;
        } while (board < 0 && board > range);
        return board;
    }

    public int nextRequiredBoard(int board) {
        return board - 1;
    }

    //function to keep a player from picking a full board after a found board has been
    //found
    public int selectAvailableBoard(int board) {
        System.out.println("Please select a different board as board" + board + " is full");
        int newBoard;
        do {
            newBoard = input.nextInt() - 1;
        } while(newBoard == board);
        return newBoard;
    }

    public int selectRowValue(int range) {
        System.out.println("Select a valid row number (1 to 3)");
        int row;
        do {
            row = input.nextInt() - 1;
        } while (row < 0 || row > range);
        return row;
    }

    public int selectColValue(int range) {
        System.out.println("Select a valid column number (1 to 3)");
        int col;
        do {
            col = input.nextInt() - 1;
        } while (col < 0 || col > range);
        return col;
    }
}
