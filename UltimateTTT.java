public class UltimateTTT {

    private BigBoard mainGame;
    private AbstractPlayer[] players = new AbstractPlayer[2];
    private String[] marks = {"X", "O"};

    private int gameBoardSize = 9;
    private int gameRowSize = 3;
    private int gameColSize = 3;
    private int turnNumber = 0;
    private int mostRecentBoard;
    private String[] winnerTable = new String[9];

    private int currentPlayerIndex = -1;

    //constructor for the game
    public UltimateTTT() {
        //creating a human player and a computer player and putting both in an array
        AbstractPlayer APlayer1 = new ComputerPlayer("Player 1", marks[0]);
        AbstractPlayer APlayer2 = new ComputerPlayer("Player 2", marks[1]);
        setPlayers(APlayer1, APlayer2);
        setBoard();
    }

    //creates the 3x3 ultimate ttt board
    private void setBoard() { this.mainGame = new BigBoard(3, 3); }

    //sets human player to player 1 and computer player to play 2
    public void setPlayers(AbstractPlayer player1, AbstractPlayer player2) {
        players[0] = player1;
        players[1] = player2;
    }

    //print call to print the state of the game
    public void printGame() {
        //mainGame.printSequential();
        mainGame.printBoard();
    }

    //actual game function where its running
    public void start() {
        System.out.println("Game start");
        //the next board that must be played by the next player due to the
        //previous player picking that spot in the mini board
        String mark = players[0].getMark();
        int selectedBoardNumber = players[0].selectBoardNumber(gameBoardSize);
        int selectedRowValue = players[0].selectRowValue(gameRowSize);
        int selectedColValue = players[0].selectColValue(gameColSize);
        mostRecentBoard = (selectedRowValue + 1) * (selectedColValue + 1);
        do {
            switchPlayer();

            System.out.println("Required next board : " + mostRecentBoard);

            //need an if statement for the first time it starts as the next make move wont be the same
            //due to players no longer being able to pick a random board unless a board is full
            if(turnNumber == 0) {
                mainGame.makeMove(mark, selectedBoardNumber, selectedRowValue, selectedColValue);
                mostRecentBoard = getNextRequiredBoard((selectedRowValue + 1), (selectedColValue + 1));
                turnNumber++;
           }else if (mainGame.isFull(mostRecentBoard)) {
                int newBoard = players[currentPlayerIndex].selectAvailableBoard(mostRecentBoard);
                int newRow = players[currentPlayerIndex].selectRowValue(gameRowSize);
                int newCol = players[currentPlayerIndex].selectColValue(gameColSize);
                while(!mainGame.makeMove(mark, newBoard, newRow, newCol));
                mostRecentBoard = getNextRequiredBoard((newRow + 1), (newCol + 1));
            }
            else {
                int newRow = players[currentPlayerIndex].selectRowValue(gameRowSize);
                int newCol = players[currentPlayerIndex].selectColValue(gameColSize);
                while (!mainGame.makeMove(players[currentPlayerIndex].getMark(), players[currentPlayerIndex].nextRequiredBoard(mostRecentBoard), newRow, newCol));
                mostRecentBoard = getNextRequiredBoard((newRow + 1), (newCol + 1));
            }
            System.out.println("Printing board...");
            mainGame.printBoard();
            System.out.println();
        } while(!gameOver());
    }

    //every turn changes player from human to computer
    private void switchPlayer() {
        if(this.currentPlayerIndex == -1 || this.currentPlayerIndex == 1)
            this.currentPlayerIndex = 0;
        else this.currentPlayerIndex = 1;
    }

    //function that gets the board that needs to be played in next
    private int getNextRequiredBoard(int row, int col) {
        System.out.println("row for next board | " + row );
        System.out.println("col for next board | " + col );
        int boardNumber = 0;
        if(row == 1 && col == 1) {
            boardNumber = 1;
        }
        else if(row == 1 && col == 2) {
            boardNumber = 2;
        }
        else if(row == 1 && col == 3) {
            boardNumber = 3;
        }
        else if(row == 2 && col == 1) {
            boardNumber = 4;
        }
        else if(row == 2 && col == 2) {
            boardNumber = 5;
        }
        else if(row == 2 && col == 3) {
            boardNumber = 6;
        }
        else if(row == 3 && col == 1) {
            boardNumber = 7;
        }
        else if(row == 3 && col == 2) {
            boardNumber = 8;
        }
        else if(row == 3 && col == 3) {
            boardNumber = 9;
        }
        else
            boardNumber = 4;
        return boardNumber;
    }


    //checks all 9 boards repeatedly to see if there is a winner in any of them
    //and if as soon as it finds a winner, it sets that winner to an array that holds winning boards
    //but doesn't update after it finds the first winner so that the boards can still be played
    private boolean gameOver() {
        return false;
    }

}
