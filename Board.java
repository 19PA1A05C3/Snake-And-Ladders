package snakeandladder5c3;

public class Board {
    private int size;
    private int start;
    private int end;
    public Board(int size){
        this.size=size;
        start=1;
        setEnd(start+size-1);
    }
    public int getBoardSize(){
        return size;
    }
}
