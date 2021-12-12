package snakeandladder5c3;

public class Player {
    private String name;
    private int location;
    private boolean won;
    public Player(String name){
        this.setName(name);
        this.location=0;
        this.won=false;
    }
    public String getName() {
        return name;
    }
    public void setLocation(int loc){
        this.location=loc;
    }
    public int getLocation(){
        return location;
    }
    public void setWon(boolean var){
        this.won=var;
    }
    
}
