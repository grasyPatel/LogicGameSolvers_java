import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        char tictacBoard[][]= new char[3][3];
        for(int row=0;row<tictacBoard.length;row++){
            for(int column=0;column<tictacBoard[0].length;column++){
                tictacBoard[row][column]=' ';
            }

        }
        char player='X';
        boolean gameOver= false;
        while(gameOver==false){
            boardDisplay(tictacBoard);
            System.out.println("Enter Player"+player+": ");
            int row=scan.nextInt();
            int column=scan.nextInt();
            if(tictacBoard[row][column]==' '){
                tictacBoard[row][column]=player;
                gameOver=gameWon(tictacBoard,player);
                if(gameOver==true){
                    System.out.println("player"+player+"has won");
                }
                else{
                    player=player=='X'?'O':'X';
                }
            }
            else{
                System.out.println("Try Again....Invalid Move!");
            }
        }
        boardDisplay(tictacBoard);
    }
    //Displaying board
    public static void boardDisplay(char [][] board){
        for (int row=0;row<board.length;row++){
            for(int column=0;column<board[0].length;column++){
                System.out.print("| "+board[row][column]+" |");
            }
            System.out.println();
        }
    }
    //Checking if Anyplayer won the game
    public static boolean gameWon(char[][]board,char player){
        for(int row=0;row<board.length;row++){
            if(board[row][0]==player &&board[row][1]==player &&board[row][2]==player){
                return true;
            }
        }
        for(int column=0;column<board.length;column++){
            if(board[0][column]==player &&board[1][column]==player && board[2][column]==player){
                return true;
            }
        }
        if(board[0][0]==player &&board[1][1]==player &&board[2][2]==player){
            return true;
        }
        if(board[0][2]==player && board[1][1]==player && board[2][0]==player){
            return true;
        }
        return false;
    }
}