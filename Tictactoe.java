import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tictactoe {
    // VARIABLES

    static String matrix[][] = {{"1","2","3"},{"4","5","6"},{"7","8","9"}};
    static boolean gameOver = false;
    static String turn = "O";

    public static boolean checkWin(){
        for(byte i = 0;i<matrix.length;i++){
            // WIN BY ROWS
            if(matrix[i][0].equals(matrix[i][1]) && matrix[i][0].equals(matrix[i][2])){
                return true;
            }else if(i==0){
                for(byte j =0;j<3;j++){
                    // WIN BY COLUMNS
                    if(matrix[i][j].equals(matrix[i+1][j]) && matrix[i][j].equals(matrix[i+2][j])){
                        return true;
                    }
                }
            }else{
                // WIN BY DIAGONALS
                if(matrix[0][0].equals(matrix[1][1]) && matrix[0][0].equals(matrix[2][2])){
                    return true;
                }else if(matrix[0][2].equals(matrix[1][1]) && matrix[0][2].equals(matrix[2][0])){
                    return true;
                }
            }
        }
        
        return false;
    }

    public static void changeTurn(){
        if (turn.equals("O")){
            turn="X";
        }else {
            turn="O";
        }
    }

    public static void main(String[] args) throws IOException{

        // BUFFERED READER
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("\t\tTic Tac Toe");

        maingame: while(gameOver != true){

            // TIC TAC TOE BOARD

            System.out.println(" --------");
            for(int i = 0;i < matrix.length;i++){
                System.out.print("| ");
                for(int j = 0;j<matrix[i].length;j++){
                    System.out.print(matrix[i][j]+" ");
                }
                System.out.print(" |");
                System.out.println();
            }
            System.out.println(" --------");

            // GAME LOGIC

            gamepart: while(true){
                System.out.println("\t\t "+turn+"'s turn");
                System.out.print("Enter the box you want to fill: ");
                String box = br.readLine();
                if(Integer.parseInt(box) <= 9 && Integer.parseInt(box) >= 1){
                    byte compareCount = 0;
                    for(int i = 0;i < matrix.length;i++){
                        for(int j = 0;j<matrix[i].length;j++){
                            if(box.compareTo(matrix[i][j]) == 0){
                                compareCount++;
                                matrix[i][j] = turn;
                            }
                        }
                    }
                    if(compareCount != 1){
                        System.out.println("Your input is invalid");
                        continue gamepart;
                    }else{
                        break gamepart;
                    }
                }else{
                    System.out.println("Your input is invalid");
                    continue gamepart;
                }
            }
            if(checkWin()){
                System.out.println(turn+" won the game!!!!");
                break maingame;
            }
            changeTurn();
        }
    }
}
