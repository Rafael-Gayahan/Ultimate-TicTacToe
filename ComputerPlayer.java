public class ComputerPlayer extends AbstractPlayer {

    public ComputerPlayer(String name, String mark) {
        super(name, mark);
    }

    public int selectBoardNumber(int board) {
        return board - 1;
    }

    public int nextRequiredBoard(int board) { return board - 1; }

    //this function is created for if a board is full so the computer
    //has to pick a different board to play
    //the board that was full is passed in to this function
    public int selectAvailableBoard(int board) {
        int pick;
        //do while loops until a board that is not full is picked
        do {
            pick = randomNumber(9);
        }while(pick == board);
        //returns new board pick
        return pick - 1;
    }

    public int selectRowValue(int range) {
        int row;
        do {
            row = randomNumber(range);
        } while (row < 0 || row > range);
        return row;
    }

    public int selectColValue(int range) {
        int col;
        do {
            col = randomNumber(range);
        } while (col < 0 || col > range);
        return col;}

    private int randomNumber (int range) { return (int)(Math.random() * range); }
}
