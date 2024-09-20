public class Minesweeper {

    // Data members
    private char[][] board;   // The game board where cells will be displayed
    private boolean[][] mines; // Array to track the locations of mines
    private boolean[][] revealed; // Array to track which cells have been revealed
    private int rows; // Number of rows in the board
    private int cols; // Number of columns in the board
    private int numMines; // Number of mines in the game
    private boolean gameOver; // Boolean to check if the game is over

    // Constructor to initialize the board with the specified dimensions and number of mines
    public Minesweeper(int rows, int cols, int numMines) {
        this.rows = rows;
        this.cols = cols;
        this.numMines = numMines;
        this.board = new char[rows][cols];
        this.mines = new boolean[rows][cols];
        this.revealed = new boolean[rows][cols];
        this.gameOver = false;

        // Call methods to initialize the board and place mines
        initializeBoard();
        placeMines();
        calculateNumbers();

    }

    public boolean getGameOver(){
        return this.gameOver;
    }

    public void setGameOver(boolean status)
    {
        this.gameOver = status;

    }
    // Method to initialize the game board with empty values
    private void initializeBoard() {
        // TODO: Implement this method
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                this.board[r][c] = '?';
                revealed[r][c] = false;
            }
        }
    }

    // Method to randomly place mines on the board
    private void placeMines() {
        // TODO: Implement this method
        int placement =0;
        while (placement < numMines){
            int ranrow = (int)(Math.random() * rows);
            int rancol = (int)(Math.random() * cols);

            //randomly places mines if no mine at location
            if(!mines[ranrow][rancol]){
                mines[ranrow][rancol] = true;
                placement++;
            }
        }

    }

    // Method to calculate numbers on the board for non-mine cells
    private void calculateNumbers() {
        // TODO: Implement this method
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (!mines[r][c]) {
                int Minesnum = 0;
                //uhh

                }
            }
        }
    }


    // Method to display the current state of the board
    public void displayBoard() {
        // TODO: Implement this method
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (revealed[r][c]) {
                    System.out.print(board[r][c] + " ");
                }else{
                    System.out.println("?"); // ? represent non reveal cell
                }
            }
            System.out.println();
        }
    }

    // Method to handle a player's move (reveal a cell or place a flag)
    public void playerMove(int row, int col, String action) {
        // TODO: Implement this method
        switch (action) {
            case "reveal" -> revealCell(row, col);
            case "flag" -> flagCell(row, col);
            case "unflag" -> unflagCell(row, col);
        }
    }

    // Method to check if the player has won the game
    public boolean checkWin() {
        // TODO: Implement this method
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if(!mines[r][c] && !revealed[r][c]){ //no mines and no revealed?
                    return false; // no win
                }
            }
        }

        return true;
    }

    // Method to check if the player has lost the game
    public boolean checkLoss(int row, int col) {
        // TODO: Implement this method
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if(!mines[r][c] && revealed[r][c]){ //no mines and revealed?
                    return true; //yes?
                }
            }
        }


        return false;
    }

    // Method to reveal a cell (and adjacent cells if necessary)
    private void revealCell(int row, int col) {
        // TODO: Implement this method
        if (revealed[row][col])
            return;

        revealed[row][col] = true;

        if (board[row][col] == '0') {
            for (int r = -1; r <= 1; r++) {
                for (int c = -1; c <= 1; c++) {
                    int thisrow = row + r;
                    int thiscol = col + c;
                    if (thisrow >= 0 && thisrow < rows && thiscol >= 0 && thiscol < cols) {
                        revealCell(thisrow, thiscol);
                    }
                }
            }
        }


    }

    // Method to flag a cell as containing a mine
    private void flagCell(int row, int col) {
        // TODO: Implement this method
        if (!revealed[row][col]){
            board[row][col] = '!';
        }
    }

    // Method to unflag a cell
    private void unflagCell(int row, int col) {
        // TODO: Implement this method
        if (board[row][col] == '!'){
            board[row][col] = ' ';
        }
    }
}