package snakeandladder5c3;
public class Dice{
    public int rollDice(){
        Random r=new Random();
        return r.nextInt(6)+1;
    }

}