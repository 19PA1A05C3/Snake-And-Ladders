package snakeandladder5c3;

import java.util.ArrayDeque;

public class Game {
    private int noOfSnakes;
    private int noOfLadders;
    private Queue<Player> players;
    private List<Snake> snakes;
    private List<Ladder> ladders;
    private Board board;
    private Dice dice;

    public Game(int noOfSnakes,int noOfLadders,int boardSize){
        this.noOfSnakes=noOfSnakes;
        this.noOfLadders=noOfLadders;
        this.players=new ArrayDeque<>();
        snakes=new ArrayList<>(noOfSnakes);
        ladders=new ArrayList<>(noOfLadders);
        board = new Board(boardSize);
        dice=new Dice();
        initBoard();
    }
    private initBoard(){
        Set<String> sl=new HashSet<>();
        Random r=new Random();
        for(int i=0;i<noOfSnakes;i++){
            while(true){
                int snakeHead = r.nextInt(board.getBoardSize()-1)+1;
                int snakeTail=r.nextInt(board.getBoardSize()-1)+1;
                if(snakeTail>=snakeHead)
                    continue;
                String headtailPair=String.valueOf(snakeHead)+snakeTail;
                if(!sl.contains(headtailPair)){
                    Snake snake=new Snake(snakeHead,snakeTail);
                    snakes.add(snake);
                    sl.add(headtailPair);
                    break
                }
            }
        }
        for(int i=0;i<noOfLadders;i++){
            while(true){
                int ladderStart=r.nextInt(board.getBoardSize()-1)+1;
                int ladderEnd=r.nextInt(board.getBoardSize()-1)+1;
                if(ladderStart>=ladderEnd)
                    continue;
                String startendPair=String.valueOf(ladderEnd)+ladderStart;
                if(!sl.contains(startendPair)){
                    Ladder ladder=new Ladder(ladderStart,ladderEnd);
                    ladders.add(ladder);
                    sl.add(startendPair);
                    break;
                }
            }
        }
        public void addPlayer(Player player){
            players.add(player);
        }
        public void playGame(){
            while(True){
                Player player=players.poll();
                int val=dice.roll();
                int newLoc=player.getLocation()+val;
                if(newLoc>board.getBoardSize()){
                    player.setLocation(player.getLocation());
                    players.offer(player);
                }
                else{
                    player.setLocation(getNewLocation(newLoc));
                    if(player.getLocation()==board.getBoardSize()){
                        player.setWon(true);
                        System.out.println("Player "+player.getName()+" Won,");
                    }
                    else{
                        System.out.println("Player "+player.getName()+" moved to "+player.getLocation());
                        players.offer(player);
                    }

                }
                if(players.size()<2){
                    break;
                }
                private int getNewLocation(int newLoc){
                    for(Snake snake:snakes){
                        if(snake.getSnakeHead()==newLoc){
                            System.out.println("Snake Bit");
                            return snake.getSnakeTail();
                        }
                    }
                    for(Ladder ladder:ladders){
                        if (ladder.getLadderStart()==newLoc){
                            System.out.println("Climbed ladder");
                            return ladder.getLadderEnd();
                        }
                    }
                    return newLoc;
                }
            }
        }
    }
    
}
