 abstract class Car{
    public abstract void drive();

    

    public void playmusic(){
        System.out.println("play the music ");
    }
}
class punch extends Car{
    public void drive(){
        System.out.println("Driving..");
    }
}


public class Abstraction{
    public static void main (String args[]){
        Car obj =  new punch();
        obj.drive();
        obj.playmusic();
        

    }
}