package snakeandladder5c3;
import java.util.*;
public class Driver {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter board size");
        int boardSize=in.nextInt();
        System.out.println("Enter no of players");
        int noOfPlayers=in.nextInt();
        System.out.println("Enter no of snakes");
        int noOfSnakes=in.nextInt();
        System.out.println("Enter no of ladders");
        int noOfLadders=in.nextInt();

        Game game=new Game(noOfSnakes,noOfLadders,boardSize);
        for(int i=0;i<noOfPlayers;i++){
            System.out.println("Enter player name");
            String pname=in.next();
            Player player=new Player(pname);
            game.addPlayer(player);
        }
        game.playGame();
    }
}
